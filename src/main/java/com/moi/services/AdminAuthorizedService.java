package com.moi.services;

import com.moi.dao.AdminAuthorizedDAO;
import com.moi.dao.AdminAuthorizedDAOImpl;
import com.moi.model.AdminAuthorizedModel;
import com.moi.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class AdminAuthorizedService {

    private final AdminAuthorizedDAO adminAuthorizedDAO = new AdminAuthorizedDAOImpl();

    public List<String> validarAdminAutorized(AdminAuthorizedModel adminAuthorizedModel, String confirmPassword) {
        List<String> errors = new ArrayList<>();

        if (adminAuthorizedModel.getFirst_name() == null || adminAuthorizedModel.getFirst_name().isBlank()) {
            errors.add("Nombre es obligatorio");
        }
        if (adminAuthorizedModel.getLast_name() == null || adminAuthorizedModel.getLast_name().isBlank()) {
            errors.add("Apellido es obligatorio");
        }
        if (adminAuthorizedModel.getUsername() == null || adminAuthorizedModel.getUsername().isBlank()) {
            errors.add("Nombre de usuario es obligatorio");
        }
        if (adminAuthorizedModel.getPassword() == null || adminAuthorizedModel.getPassword().isBlank()) {
            errors.add("Password es obligatorio");
        }
        if (adminAuthorizedModel.getPassword() == null || adminAuthorizedModel.getPassword().length() < 8) {
            errors.add("Password debe tener minimo 8 caracteres");
        }
        if (adminAuthorizedDAO.adminExist(adminAuthorizedModel.getUsername())){
            errors.add("Ya existe el nombre de usuario");
        }
        return errors;
    }

    public void insertAdminAuthorized(AdminAuthorizedModel adminAuthorizedModel){
        String hashPassword = PasswordUtil.hash(adminAuthorizedModel.getPassword());
        adminAuthorizedModel.setPassword(hashPassword);
        adminAuthorizedDAO.insertAdminAuthorized(adminAuthorizedModel);
    }


    public  AdminAuthorizedModel getAdminAuthorizedByUsername(String username) {
        return  adminAuthorizedDAO.getAdminAuthorizedByUsername(username);

    }

    public boolean loginAdminAuthorized(String username, String plainPassword) {
        AdminAuthorizedModel model= adminAuthorizedDAO.getAdminAuthorizedByUsername(username);
        //si el usuario no existe
        if (model == null) {
            return  false;
        }
        return PasswordUtil.matches(plainPassword, model.getPassword());
    }
}
