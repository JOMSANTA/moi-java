package com.moi.dao;

import com.moi.model.AdminAuthorizedModel;

import java.sql.*;
import java.util.List;

public class AdminAuthorizedDAOImpl implements AdminAuthorizedDAO{


    private static final String JDBC_URL = System.getenv("MYSQL_JDBC_URL");
    private static final String JDBC_USER =System.getenv("MYSQL_JDBC_USER");
    private static final String JDBC_PASSWORD = System.getenv("MYSQL_JDBC_PASSWORD");

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
    public void insertAdminAuthorized(AdminAuthorizedModel model) {
        String insertQuery="INSERT INTO moi.adminauthorized\n" +
                "(first_name, last_name, username, password)\n"+
                "VALUES(?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFirst_name());
            preparedStatement.setString(2, model.getLast_name());
            preparedStatement.setString(3, model.getUsername());
            preparedStatement.setString(4, model.getPassword());



            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            System.err.println("employeAuthorizedDAOImpl fallo para insertar empleado: " + e.getMessage());

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
    public void updateAdminAuthorized(int id) {

    }

    @Override
    public void deleteAdminAuthorized(int id) {

    }
}
