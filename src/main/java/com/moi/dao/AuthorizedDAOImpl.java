package com.moi.dao;

import com.moi.model.AuthorizedModel;

import java.sql.*;
import java.util.List;

public class AuthorizedDAOImpl implements  AuthorizedDAO{

        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASSWORD = "rootpassword";

        static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e){
                System.err.println("falla en el jbdc driver");
            }
        }
    private Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    @Override
    public void insertUser(AuthorizedModel model) {
            String insertQuery = "INSERT INTO usuarios_autorizados(first_name, last_name, username, password) VALUES (?,?,?,?);";
            try (Connection connection = getConnection();
                 PreparedStatement prepareStatement = connection.prepareStatement(insertQuery)){
                prepareStatement.setString(1, model.getFirst_name());
                prepareStatement.setString(2, model.getLast_name());
                prepareStatement.setString(3, model.getUsername());
                prepareStatement.setString(4, model.getPassword());
                prepareStatement.executeQuery();




            }catch (SQLException e){
                System.err.println("AuthorizedDAOImpl fallo en insertar:"+ e.getMessage());
            }

    }

    @Override
    public AuthorizedModel getUserById(int id) {
        return null;
    }

    @Override
    public List<AuthorizedModel> getAllUser() {
        return List.of();
    }

    @Override
    public void updateUser(int id, AuthorizedModel model) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
