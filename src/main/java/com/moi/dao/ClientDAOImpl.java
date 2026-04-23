package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.ClientModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {


    @Override
    public void insertClient(ClientModel model) {

        String checkQuery = "SELECT idClient FROM client WHERE idClient = ?";

        String insertQuery ="INSERT INTO client\n" +
                "(idClient, name, lastname, cel, email, address)\n"+
                "VALUES(?,?,?,?,?,?);";



        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

//si existe
        try  (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setLong(1, model.getIdClient());

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                throw new SQLException("El cliente ya existe con ese documento");
            }

        }
//insertar
            preparedStatement.setLong(1,model.getIdClient());
            preparedStatement.setString(2,model.getName());
            preparedStatement.setString(3, model.getLastname());
            preparedStatement.setString(4,model.getCel());
            preparedStatement.setString(5, model.getEmail());
            preparedStatement.setString(6, model.getAddress());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Cliente insertado correctamente");
            }


        } catch (SQLException e) {
            System.err.println("clientDAOImpl fallo para insertar cliente: " + e.getMessage());
            throw new RuntimeException("Error al insertar cliente: " + e.getMessage());

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
                clientModel.setLastname(resultSet.getString("lastname"));
                clientModel.setCel(resultSet.getString("cel"));
                clientModel.setEmail(resultSet.getString("email"));
                clientModel.setAddress(resultSet.getString("address"));


            }
        }catch (SQLException e) {
            System.out.println("erro al buscar client por numero de documento");
        }

        return clientModel;

    }

    @Override
    public List<ClientModel> buscarClientes(String valor) {
        List<ClientModel> clientes = new ArrayList<>();
        String sql = "SELECT idClient, name, lastname, cel, email, address FROM client " +
                "WHERE name LIKE ? OR idClient LIKE ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ClientModel client = new ClientModel();
                    client.setIdClient(rs.getInt("idClient"));
                    client.setName(rs.getString("name"));
                    client.setLastname(rs.getString("lastname"));
                    client.setCel(rs.getString("cel"));
                    client.setEmail(rs.getString("email"));
                    client.setAddress(rs.getString("address"));
                    clientes.add(client);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar clientes: " + e.getMessage());
        }

        return clientes;
    }


}