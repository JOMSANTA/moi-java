package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.AdminAuthorizedModel;
import com.moi.model.EmployeeAuthorizedModel;

import java.sql.*;
import java.util.List;

public class AdminAuthorizedDAOImpl implements AdminAuthorizedDAO{



    @Override
    public void insertAdminAuthorized(AdminAuthorizedModel model) {
        String insertQuery="INSERT INTO adminauthorized\n" +
                "(first_name, last_name, username, password)\n"+
                "VALUES(?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFirst_name());
            preparedStatement.setString(2, model.getLast_name());
            preparedStatement.setString(3, model.getUsername());
            preparedStatement.setString(4, model.getPassword());



            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            System.err.println("employeAuthorizedDAOImpl fallo para insertar administrador: " + e.getMessage());

        }
    }

    @Override
    public List<AdminAuthorizedModel> getAllAdminAuthorized() {
        return List.of();
    }

    @Override
    public AdminAuthorizedModel getAdminAuthorizedByFirst_name(String first_name) {
        return null;
    }

    @Override
    public AdminAuthorizedModel getAdminAuthorizedByUsername(String username) {
        String query = "SELECT * FROM adminauthorized WHERE username = ?";
        AdminAuthorizedModel model = null;
        try (Connection connection = ConexionDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                model = new AdminAuthorizedModel();
                model.setFirst_name(resultSet.getString("first_name"));
                model.setLast_name(resultSet.getString("last_name"));
                model.setUsername(resultSet.getString("username"));
                model.setPassword(resultSet.getString("password"));

            }
        }catch (SQLException e) {
            System.out.println("Error buscando administrador autorizado por username : " + e.getMessage());
        }
        return model;
    }

    @Override
    public void updateAdminAuthorized(int id) {

    }

    @Override
    public void deleteAdminAuthorized(int id) {

    }

    @Override
    public boolean adminExist(String username) {

        String query = "SELECT * FROM adminauthorized WHERE username = ?";

        try (Connection connection = ConexionDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        }catch (SQLException e) {
            System.err.println("AdminAutorizedImpl adminExist fallo al buscar administrador por username :" + e.getMessage());

        }
       return false;
    }

}
