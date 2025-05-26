package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.EmployeeAuthorizedModel;

import java.sql.*;
import java.util.List;

public class EmployeeAuthorizedDAOImpl implements EmployeeAuthorizedDAO{


    @Override
    public void insertEmployeeAuthorized(EmployeeAuthorizedModel model) {
        String insertQuery ="INSERT INTO _user\n" +
                "(first_name, last_name, username, role, password)\n"+
                "VALUES(?,?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFirst_name());
            preparedStatement.setString(2, model.getLast_name());
            preparedStatement.setString(3, model.getUsername());
            preparedStatement.setString(4, model.getRole());
            preparedStatement.setString(5, model.getPassword());



            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            System.err.println("employeAuthorizedDAOImpl fallo para insertar : " + e.getMessage());

        }
    }

    @Override
    public EmployeeAuthorizedModel getEmployeeAuthorizedByFirst_name(String first_name) {
        return null;
    }

    @Override
    public EmployeeAuthorizedModel getEmployeeByUsername(String username) {
        String query = "SELECT * FROM _user WHERE username = ?";
        EmployeeAuthorizedModel model = null;
     try (Connection connection = ConexionDb.getConnection();
     PreparedStatement preparedStatement = connection.prepareStatement(query)) {

         preparedStatement.setString(1,username);
         ResultSet resultSet = preparedStatement.executeQuery();

         if(resultSet.next()){
             model = new EmployeeAuthorizedModel();
             model.setFirst_name(resultSet.getString("first_name"));
             model.setLast_name(resultSet.getString("last_name"));
             model.setUsername(resultSet.getString("username"));
             model.setRole(resultSet.getString("role"));
             model.setPassword(resultSet.getString("password"));
         }
     }catch (SQLException e) {
         System.out.println("Error buscando empleado autorizado por username : " + e.getMessage());
     }
     return model;
    }

    @Override
    public boolean employeeExist(String username) {

        String query = "SELECT * FROM _user WHERE username = ?";

        try (Connection connection = ConexionDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        }catch (SQLException e) {
            System.err.println("EmployeeAutorizedImpl employeeExist fallo al buscar empleado por username :" + e.getMessage());

        }
        return false;
    }


}
