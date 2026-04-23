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
                "(document, name, lastname, code, cel, email, role, birthdate, branch)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setLong(1, model.getDocument());
            preparedStatement.setString(2, model.getName());
            preparedStatement.setString(3, model.getLastname());
            preparedStatement.setInt(4, model.getCode());
            preparedStatement.setLong(5, model.getCel());
            preparedStatement.setString(6, model.getEmail());
            preparedStatement.setString(7, model.getRole());

            if (model.getBirthdate() != null) {
                preparedStatement.setDate(8, Date.valueOf(model.getBirthdate()));
            } else {
                preparedStatement.setDate(8, null);
            }

            preparedStatement.setString(9, model.getBranch());


            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Filas insertadas: " + rowsInserted);


        } catch (SQLException e) {
            System.err.println("Error insertando empleado:");
            e.printStackTrace();
        }

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


    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        String selectQuery = "SELECT * FROM employ;";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setDocument(resultSet.getLong("document"));
                employeeModel.setName(resultSet.getString("name"));
                employeeModel.setLastname(resultSet.getString("lastname"));
                employeeModel.setCode(resultSet.getInt("code"));
                employeeModel.setCel(resultSet.getLong("cel"));
                employeeModel.setEmail(resultSet.getString("email"));
                employeeModel.setRole(resultSet.getString("role"));
                String birthdate = resultSet.getString("birthdate");
                employeeModel.setBirthdate(LocalDate.parse(birthdate));
                employeeModel.setBranch(resultSet.getString("branch"));

                employees.add(employeeModel);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;

    }
}

