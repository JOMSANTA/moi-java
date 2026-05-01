package com.moi.user.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.user.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {


    @Override
    public void insertUser(UserModel model) {
        String insertQuery = "INSERT INTO _user (first_name, last_name, username, password) VALUES(?,?,?,?);";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFirstName());
            preparedStatement.setString(2, model.getLastName());
            preparedStatement.setString(3, model.getUsername());
            preparedStatement.setString(4, model.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("UserDAOImpl fallo para insertar usuario: " + e.getMessage());

        }
        ;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel userModel = null;
        String selectQuery = "SELECT * FROM _user WHERE username = ?";
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(resultSet.getLong("id"));
                userModel.setFirstName(resultSet.getString("first_name"));
                userModel.setLastName(resultSet.getString("last_name"));
                userModel.setUsername(resultSet.getString("username"));
                userModel.setPassword(resultSet.getString("password"));
                userModel.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            System.err.println("UserDAOImpl failed to select user by username and password: " + e.getMessage());
        }
        return userModel;
    }

    @Override
    public boolean userExist(String username) {

        String query = "SELECT * FROM _user WHERE username = ?";
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("UserDaoImpl userExist Usuario ya existe " + e.getMessage());
        }

        return false;
    }


}
