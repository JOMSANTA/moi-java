package com.moi.dao;

import com.moi.model.EmployeeAuthorizedModel;

public interface EmployeeAuthorizedDAO {
    void insertEmployeeAuthorized(EmployeeAuthorizedModel model);

    EmployeeAuthorizedModel getEmployeeAuthorizedByFirst_name(String first_name);

    EmployeeAuthorizedModel getEmployeeByUsername(String user_name);

    boolean employeeExist(String username);
}
