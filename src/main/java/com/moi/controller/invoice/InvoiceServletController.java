package com.moi.controller.invoice;

import com.moi.dao.InvoiceDaoImpl;
import com.moi.model.InvoiceModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/invoices")
public class InvoiceServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("documento");
        String codEmpleado = request.getParameter("codEmpleado");
        String producto = request.getParameter("producto");
        String codigoProducto = request.getParameter("codigoProducto");
        String imei = request.getParameter("imei");
        String cantidad = request.getParameter("cantidad");
        String valorUnitario = request.getParameter("valorUnitario");
        String subTotal = request.getParameter("subTotal");
        String iva = request.getParameter("iva");
        String total = request.getParameter("total");




        if (documento !=  null && !documento.isEmpty() && codEmpleado != null && !codEmpleado.isEmpty()) {
            InvoiceModel model = new InvoiceModel();
            model.setFecha(fecha != null ? fecha : "");
            model.setNombre(nombre);
            try {


                model.setDocumento(Long.parseLong(documento));
                model.setCodEmpleado(Integer.parseInt(codEmpleado));
                model.setProducto(producto);
                model.setCodigoProducto(codigoProducto);
                model.setImei(Long.parseLong(imei));

                int quantity = (cantidad != null && !cantidad.isEmpty()) ? Integer.parseInt(cantidad) : 0;
                int unitValue = (valorUnitario != null && !valorUnitario.isEmpty()) ? Integer.parseInt(valorUnitario) : 0;
                int totalValue = unitValue * quantity;

                float ivaValue = totalValue * 0.19f;
                float subTotalValue = totalValue - ivaValue;
                int randomNum = (int) (Math.random() * 101);


                model.setCantidad(quantity);
                model.setValorUnitario(unitValue);
                model.setSubTotal(subTotalValue);
                model.setIva(19);
                model.setTotal(totalValue);
                model.setFactura(randomNum);//pilas a cambio


                InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
                invoiceDao.insertInvoice(model);
                System.out.println("Factura generada con exito");
                request.setAttribute("loginMessage", "Factura generada con exito");

            } catch (NumberFormatException e) {
                request.setAttribute("loginMessage", "Registre cliente, Datos invalidos, intentelo nuevamente");
                e.printStackTrace();

            }
        }else {
            request.setAttribute("loginMessage", "Registre cliente, Datos inválidos, inténtelo nuevamente");
        }
        request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp").forward(request, response);

        // response.sendRedirect(request.getContextPath()+"/invoices");

    }
}