package com.moi.controller.Payroll;

import com.moi.dao.PayrollDAOImpl;
import com.moi.model.PayrollModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/payrolls")
public class PayrollServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<PayrollModel> payrolls = new PayrollDAOImpl().getAllPayrolls();
        request.setAttribute("payrolls", payrolls);


       request.getRequestDispatcher("/WEB-INF/views/payrolls/payroll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recibir datos del formulario
        String date = req.getParameter("date");
        int code = Integer.parseInt(req.getParameter("code"));
        String name = req.getParameter("name");
        int basico = Integer.parseInt(req.getParameter("basico"));
        int prepago = Integer.parseInt(req.getParameter("prepago"));
        int postpago = Integer.parseInt(req.getParameter("postpago"));
        String detalle = req.getParameter("detalle");
        int otros = Integer.parseInt(req.getParameter("otros"));

        // Calcular subtotal y total automáticamente
        int subtotal = basico + prepago + postpago + otros;
        int total = subtotal; // Si tienes impuestos u otros cargos, agregarlos aquí

        // Crear modelo usando constructor vacío y setters
        PayrollModel model = new PayrollModel();
        model.setDate(date);
        model.setCode(code);
        model.setName(name);
        model.setBasico(basico);
        model.setPrepago(prepago);
        model.setPostpago(postpago);
        model.setDetalle(detalle);
        model.setOtros(otros);
        model.setSubtotal(subtotal);
        model.setTotal(total);

        // Insertar en la base de datos
        PayrollDAOImpl dao = new PayrollDAOImpl();
        dao.insertPay(model);

        // Redirigir para refrescar la lista de nóminas
        resp.sendRedirect("payrolls");
    }
}
