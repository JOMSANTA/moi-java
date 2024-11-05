package com.moi.controller.employee;

import com.moi.dao.EmployeeDAOImpl;
import com.moi.model.EmployeeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet ("/employees")
public class employeeServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeeModel> employees = new EmployeeDAOImpl().getAllEmployees();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/WEB-INF/views/employees/employee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
