package com.moi.controller.InsertPayroll;

import com.moi.dao.PayrollDAOImpl;
import com.moi.model.PayrollModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/payrollsInsert")

public class InsertPayrollServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PayrollModel> payrollsInsert = new PayrollDAOImpl().getAllPayrolls();
        request.setAttribute("payrollsInsert", payrollsInsert);

        request.getRequestDispatcher("/WEB-INF/views/payrollsInsert/insertPayroll.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String date = request.getParameter("date");
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String basico = request.getParameter("basico");
        String prepago = request.getParameter("prepago");
        String postpago = request.getParameter("postpago");
        String detalle = request.getParameter("detalle");
        String otros = request.getParameter("otros");
        String subtotal = request.getParameter("subtotal");
        String total = request.getParameter("total");

        if (nombre != null){

            PayrollModel model = new PayrollModel();
            model.setDate(date != null ? date : "");
            model.setCodigo(Integer.parseInt(codigo));
            model.setNombre(nombre);
            model.setBasico(Integer.parseInt(basico));
            model.setPrepago(Integer.parseInt(prepago));
            model.setPostpago(Integer.parseInt(postpago));
            model.setDetalle(detalle);
            model.setOtros(Integer.parseInt(otros));
            model.setSubtotal(Integer.parseInt(subtotal));
            model.setTotal(Integer.parseInt(total));

            PayrollDAOImpl payrollDAO = new PayrollDAOImpl();
            payrollDAO.insertPay(model);

            System.out.println("pago agregado");


        }else {
            request.setAttribute("error al ingresar pago", "insertPayrollMessage");

        }
        response.sendRedirect(request.getContextPath()+"/payrollsInsert");
    }
}
