package com.moi.jdbc.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInterface {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "rootpassword";



    public  static  void  main(String[] args) {
        try {
            Connection connection = DriverManager
                    .getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String insertQuery = "INSERT INTO user(first_name, last_name, username, password) VALUES(?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement((insertQuery));

            preparedStatement.setString(1, "jomar");
            preparedStatement.setString(2, "santander");
            preparedStatement.setString(3, "santa");
            preparedStatement.setString(4, "1234");
            preparedStatement.executeUpdate();

            System.out.println("Record inserted successufully");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
