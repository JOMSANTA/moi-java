package com.moi.dao;



import com.moi.model.EmployeeAuthorizedModel;

import java.util.List;

public interface EmployeeAuthorizedDAO {

    void  insertUser(EmployeeAuthorizedModel model);
    EmployeeAuthorizedModel getUserById(int id);
    List<EmployeeAuthorizedModel> getAllUser();
    void  updateUser(int id, EmployeeAuthorizedModel model);
    void  deleteUser(int id);
}
