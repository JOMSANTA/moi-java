package com.moi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver" );
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver"+ e.getMessage());
            throw new RuntimeException("falla en el jdbc driver",e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
