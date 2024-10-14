package com.moi.dao;

import com.moi.model.AuthorizedModel;

import java.util.List;

public interface AuthorizedDAO {

    void  insertUser(AuthorizedModel model);
    AuthorizedModel getUserById(int id);
    List<AuthorizedModel> getAllUser();
    void  updateUser(int id, AuthorizedModel model);
    void  deleteUser(int id);
}
