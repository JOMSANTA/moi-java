package com.moi.auth.service;

import com.moi.user.dao.UserDAO;
import com.moi.user.dao.UserDAOImpl;
import com.moi.user.model.UserModel;
import com.moi.util.PasswordUtil;

public class AuthService {

    private final UserDAO userDAO = new UserDAOImpl();

    public UserModel validate(String username, String password) {
        UserModel user = userDAO.getUserByUsername(username);

        // 🔍 DEBUG aquí
        System.out.println("User from DB: " + user);

        if (user == null) return null;

        System.out.println("Stored password: " + user.getPassword());

        boolean isValid = PasswordUtil.matches(password, user.getPassword());

        // ✅ AQ
        System.out.println("Password matches: " + isValid);
        // 🔍 PRUEBA
        System.out.println("Test matches admin1234: " +
                PasswordUtil.matches("admin1234", user.getPassword()));

        if (isValid) return user;

        return null;
    }

}
