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


        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String codigo =request.getParameter("codigo");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        String cargo = request.getParameter("cargo");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String sucursal = request.getParameter("sucursal");


        if (documento != null) {
            EmployeeModel model= new EmployeeModel();
            model.setDocumento(Long.parseLong(documento));
            model.setNombres(nombres);
            model.setApellidos(apellidos);
            model.setCodigo(Integer.parseInt(codigo));
            model.setCelular(Long.parseLong(celular));
            model.setCorreo(correo);
            model.setCargo(cargo);
            model.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
            model.setSucursal(sucursal);

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
