package com.moi.controller.employee;

import com.moi.dao.EmployeeDAOImpl;
import com.moi.dao.PayrollDAOImpl;
import com.moi.model.EmployeeModel;
import com.moi.model.PayrollModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/employeesRegister")
public class EmployeeRegServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeeModel> employeesRegister = new EmployeeDAOImpl().getAllEmployees();
        request.setAttribute("employeesRegister", employeesRegister);
        request.getRequestDispatcher("/WEB-INF/views/employeesRegister/employee-register.jsp").forward(request, response);
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


        } else {
            request.setAttribute("error al ingresar empleado", "loginMessage");

        }

        response.sendRedirect(request.getContextPath()+"/employeesRegister");
    }
}
