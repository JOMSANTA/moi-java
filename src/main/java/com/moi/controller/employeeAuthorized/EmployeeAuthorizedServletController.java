package com.moi.controller.employeeAuthorized;


import com.moi.dao.EmployeeAuthorizedDAOImpl;
import com.moi.model.EmployeeAuthorizedModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/employeesAuthorized")
public class EmployeeAuthorizedServletController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/employeesAuthorized/employeeAuthorized.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name= request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (first_name != null) {
            EmployeeAuthorizedModel model= new EmployeeAuthorizedModel();
            model.setFirst_name(first_name);
            model.setLast_name(last_name);
            model.setUsername(username);
            model.setPassword(password);



            EmployeeAuthorizedDAOImpl employeeAuthorizedDAO = new EmployeeAuthorizedDAOImpl();
            employeeAuthorizedDAO.insertEmployeeAutorized(model);

            System.out.println("empleado autorizado");


        }else {
            request.setAttribute("error al ingresar empleado", "loginMessage");

        }
        response.sendRedirect(request.getContextPath()+"/employeesAuthorized");
    }
}