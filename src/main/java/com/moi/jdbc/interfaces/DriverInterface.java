package com.moi.jdbc.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriverInterface {

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/moi", "root", "rootpassword");
                 //   .getConnection("jdbc:mysql://localhost:3306/fbank", "root", "rootpassword");
            System.out.println("Connected to the database!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}