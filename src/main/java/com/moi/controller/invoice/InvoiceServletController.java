package com.moi.controller.invoice;

import com.moi.dao.InvoiceDao;
import com.moi.dao.InvoiceDaoImpl;
import com.moi.model.InvoiceModel;
import com.moi.model.InvoiceDetailModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/invoices")
public class InvoiceServletController extends HttpServlet {

    private InvoiceDao invoiceDao = new InvoiceDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long lastInvoiceNumber = invoiceDao.getLastInvoiceNumber();
        long nextInvoiceNumber = lastInvoiceNumber + 1;

        request.setAttribute("nextInvoiceNumber", nextInvoiceNumber);

        request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // =========================
            //  CABECERA
            // =========================
            String fechaHora = request.getParameter("fechaHora");
            String idClient = request.getParameter("idClient");
            String cliente = request.getParameter("name");
            String codEmployee = request.getParameter("codEmployee");

            String[] products = request.getParameterValues("name[]");
            String[] colors = request.getParameterValues("color[]");
            String[] codes = request.getParameterValues("code[]");
            String[] imeis = request.getParameterValues("imei[]");
            String[] prices = request.getParameterValues("price[]");
            String[] quantities = request.getParameterValues("quantity[]");

            // =========================
            // VALIDACION
            // =========================
            if (fechaHora == null || idClient == null || cliente == null ||
                    products == null || products.length == 0) {

                request.setAttribute("loginMessage", "Todos los campos son obligatorios");
                request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp")
                        .forward(request, response);
                return;
            }

            // =========================
            //  CREAR FACTURA
            // =========================
            InvoiceModel invoice = new InvoiceModel();
            invoice.setDate(LocalDateTime.parse(fechaHora));
            invoice.setIdClient(Long.parseLong(idClient));
            invoice.setName(cliente);
            invoice.setCodEmployee(Integer.parseInt(codEmployee));

            // =========================
            // DETALLES
            // =========================
            List<InvoiceDetailModel> details = new ArrayList<>();
            float subTotal = 0;

            for (int i = 0; i < products.length; i++) {

                // evitar filas vacías
                if (products[i] == null || products[i].isEmpty()) continue;

                InvoiceDetailModel detail = new InvoiceDetailModel();

                detail.setProduct(products[i]);
                detail.setColor(colors[i]);
                detail.setCode(codes[i]);

                List<String> imeiList = new ArrayList<>();
                if (imeis != null && imeis.length > i && imeis[i] != null && !imeis[i].isEmpty()) {
                    imeiList.add(imeis[i]);
                }
                detail.setImeis(imeiList);

                detail.setIdProduct(0);

                float price = 0;
                int quantity = 0;

                if (prices[i] != null && !prices[i].isEmpty()) {
                    price = Float.parseFloat(prices[i]);
                }

                if (quantities[i] != null && !quantities[i].isEmpty()) {
                    quantity = Integer.parseInt(quantities[i]);
                }
                if (price <= 0 || quantity <= 0) continue;

                detail.setPrice(price);
                detail.setQuantity(quantity);

                subTotal += detail.getPrice() * detail.getQuantity();

                details.add(detail);
            }

            // =========================
            // TOTALES
            // =========================
            int iva = (int) (subTotal * 0.19);
            float total = subTotal + iva;

            invoice.setSubTotal(subTotal);
            invoice.setIva(iva);
            invoice.setTotal(total);
            invoice.setDetails(details);

            // =========================
            // GUARDAR EN BD
            // =========================
            invoiceDao.insertFullInvoice(invoice);

            // =========================
            //  RESPUESTA
            // =========================
            response.sendRedirect("invoices");

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("loginMessage", "Error al procesar la factura");
            request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp")
                    .forward(request, response);
        }
    }
}