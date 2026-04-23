package com.moi.controller.employee;

import com.moi.dao.EmployeeDAOImpl;
import com.moi.model.EmployeeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@WebServlet("/employees")
public class EmployeeServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeeModel> employees = new EmployeeDAOImpl().getAllEmployees();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/WEB-INF/views/employees/employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String documento = request.getParameter("document");
        String nombres = request.getParameter("name");
        String apellidos = request.getParameter("lastname");
        String codigo =request.getParameter("code");
        String celular = request.getParameter("cel");
        String correo = request.getParameter("email");
        String cargo = request.getParameter("role");
        String fechaNacimiento = request.getParameter("birthdate");
        String sucursal = request.getParameter("branch");


        if (documento != null) {
            EmployeeModel model= new EmployeeModel();
            model.setDocument(Long.parseLong(documento));
            model.setName(nombres);
            model.setLastname(apellidos);
            model.setCode(Integer.parseInt(codigo));
            model.setCel(Long.parseLong(celular));
            model.setEmail(correo);
            model.setRole(cargo);
            model.setBirthdate(LocalDate.parse(fechaNacimiento));
            model.setBranch(sucursal);

             EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
             employeeDAO.insertEmployee(model);

            System.out.println("empleado agregado");

            // doGet(request, response);//otra opcion
        } else {
            request.setAttribute("error al ingresar empleado", "loginMessage");

        }


        response.sendRedirect(request.getContextPath()+"/employees");
    }
}
