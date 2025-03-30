package com.moi.dao;

import com.moi.model.EmployeeAuthorizedModel;

import java.util.List;

public interface EmployeeAuthorizedDAO {
    void insertEmployeeAutorized (EmployeeAuthorizedModel model);
    List <EmployeeAuthorizedModel> getAllEmployeeAuthorized();
    EmployeeAuthorizedModel getEmployeeAuthorizedByFirst_name(String first_name);
    EmployeeAuthorizedModel getEmployeeAuthorizedByLast_name(String last_name);
    EmployeeAuthorizedModel getEmployeeAuthorizedByUsername(String user_name);
    void updateEmployeeAuthorized(int id);
    void deleteEmployeeAuthorized(int id);

}
