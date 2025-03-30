package com.moi.dao;

import com.moi.model.EmployeeAuthorizedModel;

import java.sql.*;
import java.util.List;

public class EmployeeAuthorizedDAOImpl implements EmployeeAuthorizedDAO{


    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

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
    public void insertEmployeeAutorized(EmployeeAuthorizedModel model) {
        String insertQuery ="INSERT INTO moi.user\n" +
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
    public List<EmployeeAuthorizedModel> getAllEmployeeAuthorized() {
        return List.of();
    }

    @Override
    public EmployeeAuthorizedModel getEmployeeAuthorizedByFirst_name(String first_name) {
        return null;
    }

    @Override
    public EmployeeAuthorizedModel getEmployeeAuthorizedByLast_name(String last_name) {
        return null;
    }

    @Override
    public EmployeeAuthorizedModel getEmployeeAuthorizedByUsername(String user_name) {
        return null;
    }

    @Override
    public void updateEmployeeAuthorized(int id ) {

    }

    @Override
    public void deleteEmployeeAuthorized(int id) {

    }


}
