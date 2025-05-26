package com.moi.controller.adminAuthorized;

import com.moi.dao.AdminAuthorizedDAOImpl;
import com.moi.model.AdminAuthorizedModel;
import com.moi.services.AdminAuthorizedService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

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


        AdminAuthorizedModel adminAuthorizedModel = new AdminAuthorizedModel();
        adminAuthorizedModel.setFirst_name(first_name);
        adminAuthorizedModel.setLast_name(last_name);
        adminAuthorizedModel.setUsername(username);
        adminAuthorizedModel.setPassword(password);
//validar
        AdminAuthorizedService adminAuthorizedService = new AdminAuthorizedService();

        List<String> errors = adminAuthorizedService.validarAdminAutorized(adminAuthorizedModel, password);
//validar si admin existe
        AdminAuthorizedDAOImpl dao = new AdminAuthorizedDAOImpl();
        if (dao.adminExist(username)) {
            errors.add("Reintente con un username diferente");
        }

        if (!errors.isEmpty()) {
//si existen errores,reenviar con los errores
            request.setAttribute("errors", errors);
            request.setAttribute("adminAuthorizedModel", adminAuthorizedModel);
            request.setAttribute("errorsMessage", "Error en la autorizacion de administrador, reintentalo.");
            request.getRequestDispatcher("/WEB-INF/views/adminsAuthorized/adminAuthorized.jsp").forward(request, response);

        } else {
            //registrar y enviar mensaje
            adminAuthorizedService.insertAdminAuthorized(adminAuthorizedModel);
            request.setAttribute("successMessage", "Administrador " + first_name + " autorizado");
            request.setAttribute("adminAuthorizedModel", new AdminAuthorizedModel());
            //limpiar el formulario
            request.getRequestDispatcher("/WEB-INF/views/adminsAuthorized/adminAuthorized.jsp").forward(request, response);

            String errorsMessage = " Fallo en autorizar administrador, intentalo nuevamente" + first_name;
            request.setAttribute("errors", errors);
            request.setAttribute("adminAuthorizedModel", adminAuthorizedModel);
            request.setAttribute("errorsMessage", errorsMessage);
        }
    }
}