package com.moi.dao;

import com.moi.model.InventoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO{

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
    public void InsertProduct(InventoryModel model) {
        String query = "INSERT INTO moi.invent (name,color,imei,code,coming,quantity,type) VALUES (?,?,?,?,?,?,?);";


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(query)){


            preparedStatement.setString(1,model.getName());
            preparedStatement.setString(2,model.getColor());
            preparedStatement.setLong(3,model.getImei());
            preparedStatement.setString(4,model.getCode());
            preparedStatement.setString(5,model.getComing());
            preparedStatement.setInt(6,model.getQuantity());
            preparedStatement.setString(7,model.getType());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.err.println("error insertando producto : " + e.getMessage());
        }




    }

    @Override
    public List<InventoryModel> getAllInventory() {
        List<InventoryModel> inventories = new ArrayList<>();
        String selectQuery = "SELECT * FROM invent;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                InventoryModel inventoryModel = new InventoryModel();
                inventoryModel.setName(resultSet.getString("name"));
                inventoryModel.setColor(resultSet.getString("color"));
                inventoryModel.setImei(resultSet.getLong("imei"));
                inventoryModel.setCode(resultSet.getString("code"));
                inventoryModel.setComing(resultSet.getString("coming"));
                inventoryModel.setQuantity(resultSet.getInt("quantity"));
                inventoryModel.setType(resultSet.getString("type"));

                inventories.add(inventoryModel);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventories;

    }

    @Override
    public InventoryModel getProductByName(String name) {
        InventoryModel inventoryModel= null;
        String selectQuery = "SELECT * FROM invent WHERE name = ?;";


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                inventoryModel = new InventoryModel();
                inventoryModel.setName(resultSet.getString("name"));
                inventoryModel.setColor(resultSet.getString("color"));
                inventoryModel.setImei(resultSet.getLong("imei"));
                inventoryModel.setCode(resultSet.getString("code"));
                inventoryModel.setComing(resultSet.getString("coming"));
                inventoryModel.setQuantity(resultSet.getInt("quantity"));
                inventoryModel.setType(resultSet.getString("type"));

            }
        }catch (SQLException e){
            System.out.println("Error al obtener producto por nombre : "+ e.getMessage());
        }
            return inventoryModel;
    }

    @Override
    public InventoryModel getProductByCode(String code) {
        return null;
    }

    @Override
    public InventoryModel getProductByImei(Long imei) {
        return null;
    }

    @Override
    public void deleteInventory(int id) {
        String query = "DELETE FROM invent WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el producto con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
    }


    public List<InventoryModel> getAllInventories() {
        return List.of();
    }
}
