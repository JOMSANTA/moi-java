package com.moi.controller.adminAuthorized;

import com.moi.dao.AdminAuthorizedDAOImpl;
import com.moi.model.AdminAuthorizedModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/adminsAuthorized")
public class AdminAuthorizedServletController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/adminsAuthorized/adminAuthorized.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (first_name != null){
            AdminAuthorizedModel model= new AdminAuthorizedModel();
            model.setFirst_name(first_name);
            model.setLast_name(last_name);
            model.setUsername(username);
            model.setPassword(password);

            AdminAuthorizedDAOImpl adminAuthorizedDAO = new AdminAuthorizedDAOImpl();
            adminAuthorizedDAO.insertAdminAuthorized(model);

            System.out.println("Administrador autorizado");
        }else {
            request.setAttribute("error al ingresar administrador", "loginMessage");
        }
        response.sendRedirect(request.getContextPath()+"/adminsAuthorized");
    }
}
