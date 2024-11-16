package com.moi.dao;

import com.moi.controller.employee.EmployeeServletController;
import com.moi.model.EmployeeModel;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
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
        String insertQuery = "INSERT INTO moi.employees\n" +
                "(documento, nombres, apellidos, celular, correo, cargo, fechaNacimiento, sucursal)\n" +
                "VALUES(?,?,?,?,?,?,?,?);";
            ResultSet rs = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, model.getDocumento());
            preparedStatement.setString(2, model.getNombres());
            preparedStatement.setString(3, model.getApellidos());
            preparedStatement.setLong(4, model.getCelular());
            preparedStatement.setString(5, model.getCorreo());
            preparedStatement.setString(6, model.getCargo());
            preparedStatement.setString(7, model.getFechaNacimiento().toString());
            preparedStatement.setString(8, model.getSucursal());



            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            System.err.println("UserDAOImpl fallo para insertar empleado: " + e.getMessage());

        }

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
                String fecha= resultSet.getString("fechaNacimiento");
                employeeModel.setFechaNacimiento(LocalDate.parse(fecha));
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
