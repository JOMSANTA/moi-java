package com.moi.controller.reports;

import com.moi.dao.EmployeeDAOImpl;
import com.moi.dao.ReportDAOImpl;
import com.moi.model.EmployeeModel;
import com.moi.model.ReportModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet ("/reports")
public class ReportServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ReportModel> reports = new ReportDAOImpl().getAllReports();
        request.setAttribute("reports", reports);


       request.getRequestDispatcher("/WEB-INF/views/reports/report.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String date = request.getParameter("date");
        String sucursal = request.getParameter("sucursal");
        String postpago = request.getParameter("postpago");
        String kitContado = request.getParameter("kitContado");
        String kitCuotas = request.getParameter("kitCuotas");
        String tv = request.getParameter("tv");
        String otros = request.getParameter("otros");
        String quantity = request.getParameter("quantity");


        if (sucursal != null) {
            ReportModel model = new ReportModel();
            model.setDate(date != null ? date : "");
            model.setSucursal(sucursal);
            model.setPostpago(Integer.parseInt(postpago));
            model.setKitContado(Integer.parseInt(kitContado));
            model.setKitCuotas(Integer.parseInt(kitCuotas));
            model.setTv(Integer.parseInt(tv));
            model.setOtros(otros);
            model.setQuantity(Integer.parseInt(quantity));


            ReportDAOImpl reportDAO = new ReportDAOImpl();
            reportDAO.insertReport(model);

            System.out.println("reporte agregado");
        } else {
            request.setAttribute("error al ingresar reporte", "reportMessge");

        }


        response.sendRedirect(request.getContextPath()+"/reports");
    }
}
