package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.ClientModel;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO {


    @Override
    public void insertClient(ClientModel model) {

        String checkQuery = "SELECT idCliente FROM client WHERE idCliente = ?";

        String insertQuery ="INSERT INTO moi.client\n" +
                "(idCliente, nombre, apellido, cel, email, direccion)\n"+
                "VALUES(?,?,?,?,?,?);";



        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

//si existe
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setLong(1, model.getIdClient());

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                throw new SQLException("El cliente ya existe con ese documento");
            }


//insertar
            preparedStatement.setLong(1,model.getIdClient());
            preparedStatement.setString(2,model.getName());
            preparedStatement.setString(3, model.getLastName());
            preparedStatement.setInt(4,model.getCel());
            preparedStatement.setString(5, model.getEmail());
            preparedStatement.setString(6, model.getAdress());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Cliente insertado correctamente");
            }


        } catch (SQLException e) {
            System.err.println("clientDAOImpl fallo para insertar cliente: " + e.getMessage());

        }


    }

    @Override
    public ClientModel getClientByIdClient(int idClient) {



        String query = " SELECT * FROM client WHERE idClient =?;";
        ClientModel clientModel = null;

        try(Connection connection = ConexionDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1,idClient);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                clientModel = new ClientModel();
                clientModel.setIdClient(resultSet.getInt("idClient"));
                clientModel.setName(resultSet.getString("name"));
                clientModel.setLastName(resultSet.getString("lastName"));
                clientModel.setCel(resultSet.getInt("cel"));
                clientModel.setEmail(resultSet.getString("email"));
                clientModel.setAdress(resultSet.getString("adress"));


            }
        }catch (SQLException e) {
            System.out.println("erro al buscar client por numero de documento");
        }

        return clientModel;

    }


}