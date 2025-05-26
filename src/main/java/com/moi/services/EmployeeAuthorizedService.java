package com.moi.services;

import com.moi.dao.EmployeeAuthorizedDAO;
import com.moi.dao.EmployeeAuthorizedDAOImpl;
import com.moi.model.EmployeeAuthorizedModel;
import com.moi.util.PasswordUtil;
import jakarta.servlet.annotation.WebServlet;

import java.util.ArrayList;
import java.util.List;


public class EmployeeAuthorizedService {

    private  final EmployeeAuthorizedDAO employeeAuthorizedDAO = new EmployeeAuthorizedDAOImpl();


    public List<String> validarUserAuthorized(EmployeeAuthorizedModel employeeAuthorizedModel, String confirmPassword) {
        List<String> errors = new ArrayList<>();

        if (employeeAuthorizedModel.getFirst_name() == null || employeeAuthorizedModel.getFirst_name().isBlank()) {
            errors.add("Nombre es obligatorio");

        }
        if (employeeAuthorizedModel.getLast_name() == null || employeeAuthorizedModel.getLast_name().isBlank()) {
            errors.add("Apellido es obligatorio");

        }
        if (employeeAuthorizedModel.getUsername() == null || employeeAuthorizedModel.getUsername().isBlank()) {
            errors.add("Nombre de usuario es obligatorio");

        }
        if (employeeAuthorizedModel.getPassword() == null || employeeAuthorizedModel.getPassword().isBlank()) {
            errors.add("Password es obligatorio");

        }
        if (employeeAuthorizedModel.getPassword() == null || employeeAuthorizedModel.getPassword().length() < 6) {
            errors.add("Password debe tener minimo 6 caracteres");

        }
        if (employeeAuthorizedDAO.employeeExist(employeeAuthorizedModel.getUsername())){
            errors.add("Ya existe el nombre de usuario");
        }
        return errors;
    }
    public  void insertEmployeeAuthorized(EmployeeAuthorizedModel employeeAuthorizedModel){
       String hashPassword = PasswordUtil.hash(employeeAuthorizedModel.getPassword());
       employeeAuthorizedModel.setPassword(hashPassword);
        employeeAuthorizedDAO.insertEmployeeAuthorized(employeeAuthorizedModel);
    }

    public  EmployeeAuthorizedModel getEmployeeAuthorizedByUsername(String username) {
        return employeeAuthorizedDAO.getEmployeeByUsername(username);

    }

    public boolean loginEmployeeAuthorized(String username, String plainPassword) {
        EmployeeAuthorizedModel model = employeeAuthorizedDAO.getEmployeeAuthorizedByFirst_name(username);
        //si usrname no existe
        if (model == null) {
            return false;
        }
        return PasswordUtil.matches(plainPassword, model.getPassword());

    }

}