package com.moi.jdbc.interfaces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementInterface {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/moi", "root", "rootpassword");

            // Stored procedure
            String callProcedure = "{CALL GetUserInformation(?, ?, ?)}";

            CallableStatement callableStatement = connection.prepareCall(callProcedure);

            // Set input parameters
            int userID = 1;
            callableStatement.setInt(1, userID);

            // Register output parameters
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR); // fullName
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); // job

            // Execute the stored procedure
            callableStatement.execute();

            // Retrieve output values
            String fullName = callableStatement.getString(2);
            String job = callableStatement.getString(3);

            System.out.println("Full Name: " + fullName);
            System.out.println("Job Title: " + job);

            System.out.println("Stored procedure executed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}