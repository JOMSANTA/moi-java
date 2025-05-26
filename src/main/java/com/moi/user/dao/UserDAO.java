package com.moi.user.dao;

import com.moi.user.model.UserModel;

public interface UserDAO {

    void insertUser(UserModel model);

    UserModel getUserByUsername(String username);

    boolean userExist(String username);

}
