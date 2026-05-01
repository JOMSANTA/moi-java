package com.moi.controller.administratorOption;

import com.moi.user.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin-options")
public class AdministratorOptionServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
        UserModel userModel = (UserModel) session.getAttribute("user");
        if (userModel != null && "ADMIN".equals(userModel.getRole())) {
            request.getRequestDispatcher("/WEB-INF/views/administratorOptions/administrationOption.jsp")
                    .forward(request, response);
            return;
        }
        }
            request.setAttribute("loginMessage", "No esta autorizado, intentelo nuevamente");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }
}
