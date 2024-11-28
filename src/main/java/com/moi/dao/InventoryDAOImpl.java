package com.moi.dao;

import com.moi.model.InventoryModel;
import com.moi.model.ProductModel;

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
        String insertQuery = "INSERT INTO inventario_oficina (  producto, color, numeroExistencias, codigo, imei, fechaLimiteVenta, tipoDeProducto) VALUES(?,?,?,?,?,?,?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {


//            preparedStatement.setString(1, model.getId());
//            preparedStatement.setInt(3, model.getQuantity());
//            preparedStatement.setString(4, model.getCodigo());
//            preparedStatement.setLong(5, model.getImei());
//            preparedStatement.setString(6, model.getFechaLimiteVenta());
//            preparedStatement.setString(7, model.getTipoDeProducto());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("error insertando producto : " + e.getMessage());
        }

    }

    @Override
    public List<InventoryModel> getAllInventory() {
        List<InventoryModel> inventories = new ArrayList<>();
        String selectQuery = "SELECT i.*, p.name, p.color, p.imei FROM inventory i JOIN product p on p.id = i.product_id";


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {


            //preparedStatement.setString(1,"aqui va lo que reemplaza la x");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InventoryModel inventoryModel = new InventoryModel();
                ProductModel productModel = new ProductModel();

                inventoryModel.setId(resultSet.getLong("id"));
                inventoryModel.setQuantity(resultSet.getInt("quantity"));

                productModel.setId(resultSet.getLong("product_id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setColor(resultSet.getString("color"));
                productModel.setImei(resultSet.getLong("imei"));

                inventoryModel.setProduct(productModel);

                inventories.add(inventoryModel);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventories;
    }

    @Override
    public List<InventoryModel> getAllByFilterParamsInventory(String product, String color) {
        return List.of();
    }


    @Override
    public List<InventoryModel> getAllByFilterParamsInventory(String product, String color, String imei) {
        List<InventoryModel> inventories = new ArrayList<>();
        String query = "select i.*, p.name, p.color, p.imei from inventory i join product p  on p.id = i.product_id WHERE name like ? and color like ? and imei like ?" ;
        //String query = "SELECT * FROM inventario_oficina WHERE producto like '%"+ producto +"%'";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + product + "%");
            preparedStatement.setString(2, "%" + color + "%");
            preparedStatement.setString(3,"%" + imei + "%");

            //preparedStatement.setString(1,"aqui va lo que reemplaza la x");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InventoryModel inventoryModel = new InventoryModel();
                ProductModel productModel = new ProductModel();

                inventoryModel.setId(resultSet.getLong("id"));
                inventoryModel.setQuantity(resultSet.getInt("quantity"));

                productModel.setId(resultSet.getLong("product_id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setColor(resultSet.getString("color"));
                productModel.setImei(resultSet.getLong("imei"));

                inventoryModel.setProduct(productModel);

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
    public InventoryModel getProductByName(String producto) {
        InventoryModel product = null;
        String insertQuery = "SELECT * FROM inventario_oficina WHERE producto like '%?%'";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, producto);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    product = new InventoryModel();
                    product.setQuantity(rs.getInt("quantity"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public InventoryModel getProductByImei(long imeiProducto) {
        return null;
    }

    @Override
    public InventoryModel getProductByCodigo(String codigo) {
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

















