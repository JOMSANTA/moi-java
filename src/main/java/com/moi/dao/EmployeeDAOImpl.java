package com.moi.dao;

import com.moi.model.EmployeeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }


    @Override
    public void insertEmployee(EmployeeModel model) {

       // String insertQuery= "INSERT INTO empleados (`documento`, `nombres`, `apellidos`, `celular`, `correo`, `cargo`, `fechaNacimiento`, `sucursal`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?');";

    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        String selectQuery = "SELECT * FROM employees;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                EmployeeModel employeeModel= new EmployeeModel();
                employeeModel.setDocumento(resultSet.getInt("documento"));
                employeeModel.setNombres(resultSet.getString("nombres"));
                employeeModel.setApellidos(resultSet.getString("apellidos"));
                employeeModel.setCodigo(resultSet.getInt("codigo"));
                employeeModel.setCelular(resultSet.getLong("celular"));
                employeeModel.setCorreo(resultSet.getString("correo"));
                employeeModel.setCargo(resultSet.getString("cargo"));
                employeeModel.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                employeeModel.setSucursal(resultSet.getString("sucursal"));

                employees.add(employeeModel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;

    }

    @Override
    public EmployeeModel getEmployeeByDocumento(int documento) {
        return null;
    }

    @Override
    public EmployeeModel getEmployeeByCodigo(int codigo) {
        return null;
    }

    @Override
    public EmployeeModel getEmployeeByNombres(String nombres) {
        return null;
    }

    @Override
    public EmployeeModel getEmplloyeeByApellidos(String apellidos) {
        return null;
    }

    @Override
    public void updateEmployee(String documento, EmployeeModel model) {

    }

    @Override
    public void deleteEmployee(String documento) {

    }
}
