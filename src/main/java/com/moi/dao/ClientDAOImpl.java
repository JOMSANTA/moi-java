package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.ClientModel;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO {


    @Override
    public void insertClient(ClientModel model) {

        String insertQuery ="INSERT INTO moi.client\n" +
                "(idClient, nombre, apellido, cel, email, direccion)\n"+
                "VALUES(?,?,?,?,?,?);";

        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
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