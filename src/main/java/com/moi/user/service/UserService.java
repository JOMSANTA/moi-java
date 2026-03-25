package com.moi.user.service;


import com.moi.user.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<String> validateUser(String username, String password) {
        List<String> errors = new ArrayList<>();

        if (username == null || username.isBlank()) {
             errors.add("username es necesario");

        }
        if (password == null || password.isBlank()) {
            errors.add("contraseña es necesaria");

        }
        else if (password.length() < 4) {
            errors.add("contraseña debe tener minimo cuatro caracteres");

        }

        return errors;
    }

}
