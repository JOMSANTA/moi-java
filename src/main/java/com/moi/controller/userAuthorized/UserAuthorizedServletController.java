package com.moi.controller.userAuthorized;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/usersAuthorized")
public class UserAuthorizedServletController extends HttpServlet {
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
        request.getRequestDispatcher("WEB-INF/views/usersAuthorized/userAuthorized.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//prueba verificacion si esta obteniendo los datos
 /*       System.out.println("nombre es :"+ first_name);
        System.out.println("apellido es :"+ last_name);
        System.out.println("username es :"+ username);
        System.out.println("password es :"+ password);
*/
    }
}
