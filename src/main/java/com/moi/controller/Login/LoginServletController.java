package com.moi.controller.Login;

import com.moi.auth.service.AuthService;
import com.moi.user.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/login")
public class LoginServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AuthService service = new AuthService();
        UserModel userModel = service.validate(username, password);


        if (userModel != null) {
            // login ok
            HttpSession session = request.getSession(false);
            session.setAttribute("user", userModel);

            if (userModel.getRole() != null && userModel.getRole().equals("ADMIN")) {
                response.sendRedirect("admin-options");
            } else {
                response.sendRedirect("adviser-options");
            }

        } else {
            // login err
            request.setAttribute("loginMessage", "Los datos no son validos, verifique y reintente");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

    }
}







