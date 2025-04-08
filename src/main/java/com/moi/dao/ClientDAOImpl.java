package com.moi.dao;

import com.moi.model.ClientModel;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO {


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
    public void insertClient(ClientModel model) {

        String insertQuery ="INSERT INTO moi.client\n" +
                "(idClient, nombre, apellido, cel, email, direccion)\n"+
                "VALUES(?,?,?,?,?,?);";

        ResultSet rs = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setLong(1,model.getIdCliente());
            preparedStatement.setString(2,model.getNombre());
            preparedStatement.setString(3, model.getApellido());
            preparedStatement.setInt(4,model.getCel());
            preparedStatement.setString(5, model.getEmail());
            preparedStatement.setString(6, model.getDireccion());

            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            System.err.println("clientDAOImpl fallo para insertar cliente: " + e.getMessage());

        }
    }





}