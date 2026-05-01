package com.moi.controller.invoice;
import com.moi.dao.InvoiceDao;
import com.moi.dao.InvoiceDaoImpl;
import com.moi.model.InvoiceModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.moi.model.InvoiceDetailModel;


import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/invoices")
public class InvoiceServletController extends HttpServlet {

    private InvoiceDao invoiceDao = new InvoiceDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String[] idProducts = request.getParameterValues("idProduct[]");
            String[] quantities = request.getParameterValues("quantity[]");
            String[] prices = request.getParameterValues("price[]");
            String[] imeis = request.getParameterValues("imei[]");

            if (idProducts == null || quantities == null || prices == null || imeis == null) {
                throw new NumberFormatException("Campos incompletos");
            }

            List<InvoiceDetailModel> details = new ArrayList<>();

            for (int i = 0; i < idProducts.length; i++) {

                InvoiceDetailModel detail = new InvoiceDetailModel();

                detail.setIdProduct(Long.parseLong(idProducts[i]));
                detail.setQuantity(Integer.parseInt(quantities[i]));
                detail.setPrice(Float.parseFloat(prices[i]));

                List<String> imeiList = new ArrayList<>();
                imeiList.add(imeis[i]);

                detail.setImeis(imeiList);

                details.add(detail);
            }

            InvoiceModel model = new InvoiceModel();
            model.setFecha(request.getParameter("fecha"));
            model.setNombre(request.getParameter("nombre"));
            model.setIdClient(Long.parseLong(request.getParameter("idClient")));
            model.setCodEmpleado(Integer.parseInt(request.getParameter("codEmpleado")));
            model.setFactura(1);

            model.setDetails(details);

            invoiceDao.insertFullInvoice(model);

            request.setAttribute("loginMessage", "Factura generada con éxito");

            // PRG pattern (mejor práctica)
            response.sendRedirect("invoices");
            return;

        } catch (NumberFormatException e) {

            request.setAttribute("loginMessage", "Datos inválidos, verifique los campos");
            e.printStackTrace();

            request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp")
                    .forward(request, response);
        }
    }
}