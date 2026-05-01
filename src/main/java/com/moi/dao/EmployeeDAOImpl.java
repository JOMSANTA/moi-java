package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.controller.employee.EmployeeServletController;
import com.moi.model.EmployeeModel;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void insertEmployee(EmployeeModel model) {
        String insertQuery = "INSERT INTO employ\n" +
                "(documento, nombres, apellidos, codigo, celular, correo, cargo, fechaNacimiento, sucursal)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setLong(1, model.getDocumento());
            preparedStatement.setString(2, model.getNombres());
            preparedStatement.setString(3, model.getApellidos());
            preparedStatement.setInt(4, model.getCodigo());
            preparedStatement.setLong(5, model.getCelular());
            preparedStatement.setString(6, model.getCorreo());
            preparedStatement.setString(7, model.getCargo());
            preparedStatement.setString(8, model.getFechaNacimiento().toString());
            preparedStatement.setString(9, model.getSucursal());


            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("employeDAOImpl fallo para insertar empleado: " + e.getMessage());

        }

    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        String selectQuery = "SELECT * FROM employ;";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

              while (resultSet.next()) {

                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setDocumento(resultSet.getLong("documento"));
                employeeModel.setNombres(resultSet.getString("nombres"));
                employeeModel.setApellidos(resultSet.getString("apellidos"));
                employeeModel.setCodigo(resultSet.getInt("codigo"));
                employeeModel.setCelular(resultSet.getLong("celular"));
                employeeModel.setCorreo(resultSet.getString("correo"));
                employeeModel.setCargo(resultSet.getString("cargo"));
                String fecha = resultSet.getString("fechaNacimiento");
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
    public EmployeeModel getEmployeeByDocumento(long documento) {
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
