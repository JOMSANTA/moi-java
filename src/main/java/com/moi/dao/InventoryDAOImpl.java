package com.moi.dao;

import com.moi.model.InventoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {

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
    public void insertProduct(InventoryModel model) {
        String insertQuery = "INSERT INTO inventario_oficina (idProducto, producto, colorProducto, numeroExistencias, imeiProducto, fechaLimiteVenta, tipoDeProducto) VALUES(?,?,?,?,?,?,?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getId());
            preparedStatement.setString(2, model.getProducto());
            preparedStatement.setString(3, model.getColor());
            preparedStatement.setInt(4, model.getNumeroExistencias());
            preparedStatement.setInt(4, model.getCodigo());
            preparedStatement.setLong(5, model.getImei());
            preparedStatement.setDate(6, model.getFechaLimiteVentas());
            preparedStatement.setString(7, model.setTipoDeProducto());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("error insertando producto : " + e.getMessage());
        }

    }

    @Override
    public List<InventoryModel> getAllInventory() {
        List<InventoryModel> inventories = new ArrayList<>();
        String selectQuery = "SELECT * FROM inventario_oficina;";


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InventoryModel inventoryModel = new InventoryModel();
                inventoryModel.setId(resultSet.getString("id"));
                inventoryModel.setProducto(resultSet.getString("producto"));
                inventoryModel.setColor(resultSet.getString("Color"));
                inventoryModel.setNumeroExistencias((short) resultSet.getInt("numeroExistencias"));
                inventoryModel.setImei((long) resultSet.getInt("imei"));
                inventoryModel.setCodigo((int)resultSet.getInt("codigo"));
                inventoryModel.setFechaLimiteVenta(resultSet.getDate("fechaLimiteVenta"));
                inventoryModel.setTipoDeProducto(resultSet.getString("tipoDeProducto"));


                // Resto de atributos


                inventories.add(inventoryModel);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventories;
    }

    @Override
    public InventoryModel getProductById(String idProducto) {
        return null;
    }

    @Override
    public InventoryModel geProductByName(String producto) {
        return null;
    }

    @Override
    public InventoryModel getProductByImei(int imeiProducto) {
        return null;
    }

    @Override
    public InventoryModel getProductByCodigo(int codigo) {
        return null;
    }

    @Override
    public InventoryModel getProductByColor(String colorProducto) {
        return null;
    }

    @Override
    public void updateProduct(String idProducto, InventoryModel model) {

    }

    @Override
    public void deleteProduct(String idProducto) {

    }

}





