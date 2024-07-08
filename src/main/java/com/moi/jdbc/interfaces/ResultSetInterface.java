package com.moi.jdbc.interfaces;

import java.sql.*;


public class ResultSetInterface {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/moi", "root", "password");

            Statement statement = connection.createStatement();

            // Execute an update query
            String selectQuery = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String username = resultSet.getString("username");
                System.out.println("User: " + firstName + ", Username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}