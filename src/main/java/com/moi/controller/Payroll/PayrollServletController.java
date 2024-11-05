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

    }
}
