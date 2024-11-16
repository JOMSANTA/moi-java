package com.moi.controller.productRegister;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/productsRegister")
public class ProductRegisterServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/productsRegister/productRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String producto = request.getParameter("producto");
        String color = request.getParameter("color");
        int numeroExistencias = Integer.parseInt(request.getParameter("numeroExistencias"));
        int imei = Integer.parseInt(request.getParameter("imei"));
        String fechaLimiteVenta = request.getParameter("fechaLimiteVenta");
        String tipoDeProducto = request.getParameter("tipoDeProducto");




    }
}
