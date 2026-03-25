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

    private static final String LOGIN_VIEW = "/WEB-INF/views/login.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache");//HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies

        request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 🔍 DEBUG aquí
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        if (username == null || username.isBlank() ||
        password == null || password.isBlank()){

            request.setAttribute("loginMessage", "Todos los campos son obligatorios");
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
            return;
        }

        AuthService service = new AuthService();
        UserModel userModel = service.validate(username, password);


        if (userModel != null) {
            // invalidar sesion anterior

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null){
                oldSession.invalidate();
            }
            // nueva sesion
            HttpSession session = request.getSession();
            session.setAttribute("user", userModel);

            // redireccion por rol
            if ("ADMIN".equals( userModel.getRole())) {
                response.sendRedirect(request.getContextPath() + "/admin-options");
            } else {
                response.sendRedirect(request.getContextPath() + "/adviser-options");
            }

        } else {
            // login err
            request.setAttribute("loginMessage", " Datos incorrectos ");
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
        }

    }
}







