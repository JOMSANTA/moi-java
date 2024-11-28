package com.moi.dao;

import com.moi.model.AdminAuthorizedModel;

import java.util.List;

public interface AdminAuthorizedDAO {
    void insertAdminAuthorized(AdminAuthorizedModel model);
    List<AdminAuthorizedModel>getAllAdminAuthorized();
    AdminAuthorizedModel getAdminAuthorizedByFirst_name(String first_name);
    void updateAdminAuthorized(int id);
    void deleteAdminAuthorized(int id);
}
