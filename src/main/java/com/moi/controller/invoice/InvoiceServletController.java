package com.moi.controller.invoice;

import com.moi.dao.InvoiceDaoImpl;
import com.moi.model.InvoiceModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

       Date fecha = Date.valueOf(request.getParameter("fecha"));
        String nombre = request.getParameter("nombre");
        int documento = request.getIntHeader("documento");
        int factura = request.getIntHeader("factura");
        String codigoEmpleado = request.getParameter("codigoEmpleado");
        String producto = request.getParameter("producto");
        int codigoProducto = request.getIntHeader("codigoproducto");
        int imei = request.getIntHeader("imei");
        int cantidad = request.getIntHeader("cantidad");
        int valor = request.getIntHeader("valor");
        int subTotal = request.getIntHeader("subTotal");
        int iva = request.getIntHeader("iva");
        int total = request.getIntHeader("total");

        InvoiceModel invoiceModel = new InvoiceModel();

        if (invoiceModel ==  null ) {
            request.setAttribute("loginMessage","Factura generada con exito") ;
            request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp"). forward(request, response);
        }else {
            request.setAttribute("loginMessage", "Datos invalidos, intentelo nuevamente");
            request.getRequestDispatcher("/WEB-INF/views/invoices/invoice-list.jsp").forward(request, response);


        }



    }
}

