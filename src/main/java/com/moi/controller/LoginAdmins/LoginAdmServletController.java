package com.moi.controller.LoginAdmins;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/loginAdm")
public class LoginAdmServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/views/loginAdm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (username.equalsIgnoreCase("santa") && password.equals("12345")) {
            request.setAttribute("loginMessage", "acceso valido");
            request.getRequestDispatcher("/WEB-INF/views/administratorOptions/administrationOption.jsp").forward(request, response);

        }else {
            request.setAttribute("loginMessage","acceso invalido");
        }

        request.getRequestDispatcher("/WEB-INF/views/loginAdm.jsp").forward(request,response);
    }
}
