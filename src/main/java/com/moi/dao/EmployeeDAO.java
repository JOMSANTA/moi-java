package com.moi.dao;

import com.moi.model.EmployeeModel;

import java.util.List;

public interface EmployeeDAO {

void  insertEmployee (EmployeeModel model);
List<EmployeeModel> getAllEmployees();
EmployeeModel getEmployeeByDocumento(int documento);
EmployeeModel getEmployeeByCodigo(int codigo);
EmployeeModel getEmployeeByNombres(String nombres);
EmployeeModel getEmplloyeeByApellidos(String apellidos);
void  updateEmployee (String documento, EmployeeModel model);
void  deleteEmployee (String documento);
}
