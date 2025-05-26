
package com.moi.controller.employeeAuthorized;


import com.moi.dao.EmployeeAuthorizedDAOImpl;
import com.moi.model.EmployeeAuthorizedModel;
import com.moi.services.EmployeeAuthorizedService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String role = request.getParameter("role");
        String password = request.getParameter("password");


        EmployeeAuthorizedModel employeeAuthorizedModel= new EmployeeAuthorizedModel();
        employeeAuthorizedModel.setFirst_name(first_name);
        employeeAuthorizedModel.setLast_name(last_name);
        employeeAuthorizedModel.setUsername(username);
        employeeAuthorizedModel.setRole(role);
        employeeAuthorizedModel.setPassword(password);
//validar
        EmployeeAuthorizedService employeeAuthorizedService = new EmployeeAuthorizedService();

        List<String> errors = new ArrayList<>();
                //employeeAuthorizedService.validarEmployeeAuthorized(employeeAuthorizedModel, password);
//validar si usuario existe
        EmployeeAuthorizedDAOImpl dao = new EmployeeAuthorizedDAOImpl();
        if (dao.employeeExist(username)){
            errors.add("Reintente con un username diferente");
        }

        if (!errors.isEmpty()){
//si existen errores,reenviar con los errores
            request.setAttribute("errors", errors);
            request.setAttribute("employeeModel", employeeAuthorizedModel);
            request.setAttribute("errorsMessage","Error en la autorizacion de empleado, reintentalo.");
            request.getRequestDispatcher("/WEB-INF/views/employeesAuthorized/employeeAuthorized.jsp").forward(request, response);

        }else {
            //registrar y enviar mensaje
            employeeAuthorizedService.insertEmployeeAuthorized(employeeAuthorizedModel);
            request.setAttribute("successMessage", "Empleado " + first_name + " autorizado" );
            request.setAttribute("employeeModel",new EmployeeAuthorizedModel());
            //limpiar el formulario
            request.getRequestDispatcher("/WEB-INF/views/employeesAuthorized/employeeAuthorized.jsp").forward(request, response);

            String errorsMessage = " Fallo en autorizar empleado, intentalo nuevamente" + first_name;
            request.setAttribute("errors", errors);
            request.setAttribute("employeeModel", employeeAuthorizedModel);
            request.setAttribute("errorsMessage", errorsMessage);
        }

}
}
