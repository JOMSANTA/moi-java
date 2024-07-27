package com.moi.dao;

import com.moi.model.InventoryModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO{

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "rootpassword";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }

    }
    private Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }




    @Override
    public void insertProduct(InventoryModel model) {
        String insertQuery = "INSERT INTO inventario_oficina (idProducto, producto, colorProducto, numeroExistencias, imeiProducto, fechaLimiteVenta, tipoDeProducto) VALUES(?,?,?,?,?,?,?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getIdProducto());
            preparedStatement.setString(2, model.getProducto());
            preparedStatement.setString(3, model.getColorProducto());
            preparedStatement.setInt(4, model.getNumeroExistencias());
            preparedStatement.setInt(5, model.getImeiProducto());
            preparedStatement.setDate(6, model.getFechaLimiteVentas());
            preparedStatement.setString(7, model.setTipoDeProducto());
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.err.println("error insertando producto : " + e.getMessage());
        }

    }

    @Override
    public List<InventoryModel> getAllInventory() {
        return List.of();
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
