package com.moi.dao;

import com.moi.model.UserModel;

import javax.servlet.http.HttpServlet;
import java.util.List;

public interface UserDAO {
    void insertUser(UserModel model);
    UserModel getUserById(long id);
    UserModel getUserByUsernameANDPassword(String username, String password);
    List<UserModel> getAllUser();
    void  updateUser(long id, UserModel model);
    void deleteUserById(long id);

}
