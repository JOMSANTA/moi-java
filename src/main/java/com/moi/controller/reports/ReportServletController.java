package com.moi.controller.reports;

import com.moi.dao.ReportDAOImpl;
import com.moi.model.ReportModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet ("/reports")
public class ReportServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ReportModel> reports = new ReportDAOImpl().getAllReports();
        request.setAttribute("reports", reports);


       request.getRequestDispatcher("/WEB-INF/views/reports/report.jsp").forward(request, response);
    }
}
