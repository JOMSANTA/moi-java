package com.moi.user.controller;


import com.moi.user.dao.UserDAO;
import com.moi.user.dao.UserDAOImpl;
import com.moi.user.model.UserModel;
import com.moi.user.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();

        //validacion
        List<String> errors = userService.validateUser(username, password);

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.setAttribute("errorMessage", "Registro invalido. intenta nuevamente");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            return;
        }
        // modelo
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        // hash passw
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userModel.setPassword(passwordEncoder.encode(password));

        // guardar bd con dao

        UserDAO userDAO = new UserDAOImpl();
        userDAO.insertUser(userModel);

        // mensaje
        request.setAttribute("successMessage", " Registro correcto : " + username);
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);


       }

}
