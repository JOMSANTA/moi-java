package com.moi.controller.employeeAuthorized;


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

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "rootpassword";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }

    }
    private Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/views/employeesAuthorized/employeeAuthorized.jsp").forward(request,response);
    }
}
