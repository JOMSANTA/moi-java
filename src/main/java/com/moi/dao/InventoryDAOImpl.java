package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.InventoryModel;

import java.sql.*;
import java.util.*;

public class InventoryDAOImpl implements InventoryDAO {

    @Override
    public void InsertProduct(InventoryModel model) {
        String queryProduct = "INSERT INTO product (name, color, code, coming, type) VALUES (?,?,?,?,?)";
        String queryInventory = "INSERT INTO inventory (quantity, idProduct) VALUES (?,?)";
        String queryImei = "INSERT INTO imeis (imei, idProduct) VALUES (?,?)";

        try (Connection connection = ConexionDb.getConnection()) {
            connection.setAutoCommit(false);//inicia envio

            try (PreparedStatement preparedStatementProduct = connection.prepareStatement(queryProduct, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement preparedStatementInventory = connection.prepareStatement(queryInventory);
                 PreparedStatement preparedStatementImei = connection.prepareStatement(queryImei)) {
                // insert invent

                preparedStatementProduct.setString(1, model.getName());
                preparedStatementProduct.setString(2, model.getColor());
                //    preparedStatement.setLong(3, model.getImei());
                preparedStatementProduct.setString(3, model.getCode());
                preparedStatementProduct.setString(4, model.getComing());
                preparedStatementProduct.setString(5, model.getType());

                preparedStatementProduct.executeUpdate();
                //pedir id
                ResultSet generateKeys = preparedStatementProduct.getGeneratedKeys();
                if (generateKeys.next()) {
                    int idProducto = generateKeys.getInt(1);

                    //insert en inventory

                    preparedStatementInventory.setInt(1, model.getQuantity());
                    preparedStatementInventory.setInt(2, idProducto);
                    preparedStatementInventory.executeUpdate();

                    //insert imeis
                    if (model.getImeis() != null && !model.getImeis().isEmpty()) {
                        for (String imei : model.getImeis()) {
                            preparedStatementImei.setString(1, imei);
                            preparedStatementImei.setInt(2, idProducto);
                            preparedStatementImei.addBatch();
                        }
                        preparedStatementImei.executeBatch();
                    }
                    connection.commit();
                } else {
                    connection.rollback();//no hay id
                    throw new SQLException("No se obtuvo id para el producto");
                }
            } catch (SQLException ex) {
                connection.rollback();//deshacer
                System.err.println("error insertando producto (rollback): " + ex.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("error conexion o commit : " + e.getMessage());
        }


    }

    @Override
    public List<InventoryModel> getAllInventory() {
        Map<Long, InventoryModel> inventoryMap = new LinkedHashMap<>();
        String Query =
                "SELECT p.idProduct, p.name, p.color, p.code, p.coming, p.type, " +
                "i.quantity, im.imei " +
                "FROM product p " +
                "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                "LEFT JOIN imeis im ON p.idProduct = im.idProduct " +
                "ORDER BY p.name ASC ";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long idProduct = resultSet.getLong("idProduct");
                InventoryModel inventoryModel = inventoryMap.get(idProduct);

                if (inventoryModel == null) {
                    inventoryModel = new InventoryModel();

                    inventoryModel.setIdProduct(idProduct);
                    inventoryModel.setName(resultSet.getString("name"));
                    inventoryModel.setColor(resultSet.getString("color"));
                    // inventoryModel.setImei(resultSet.getLong("imei"));
                    inventoryModel.setCode(resultSet.getString("code"));
                    inventoryModel.setComing(resultSet.getString("coming"));
                    inventoryModel.setQuantity(resultSet.getInt("quantity"));
                    inventoryModel.setType(resultSet.getString("type"));
                    inventoryModel.setImeis(new ArrayList<>());

                    inventoryMap.put(idProduct, inventoryModel);
                }
                String imei = resultSet.getString("imei");
                if (imei != null) {
                    inventoryModel.getImeis().add(imei);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener inventario: " + e.getMessage());

        }

        return new ArrayList<>(inventoryMap.values());

    }



    @Override
    public InventoryModel getProductByName(String name) {
        InventoryModel inventoryModel = null;
        String selectQuery =
                "SELECT p.*, i.quantity FROM product p " +
                "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                "WHERE p.name = ?";


        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                inventoryModel = new InventoryModel();
                Long idProduct = resultSet.getLong("idProduct");
                inventoryModel.setIdProduct(idProduct);
                inventoryModel.setName(resultSet.getString("name"));
                inventoryModel.setColor(resultSet.getString("color"));
            //    inventoryModel.setImei(resultSet.getLong("imei"));
                inventoryModel.setCode(resultSet.getString("code"));
                inventoryModel.setComing(resultSet.getString("coming"));
                inventoryModel.setQuantity(resultSet.getInt("quantity"));
                inventoryModel.setType(resultSet.getString("type"));

                List<String> imeis = getImeiByProductoId(idProduct);
                inventoryModel.setImeis(imeis);

            }
        } catch (SQLException e) {
            System.out.println("Error al obtener producto por nombre : " + e.getMessage());
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
    public void deleteInventory(int idProducto) {
        String query = "DELETE FROM inventory WHERE idProducto = ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idProducto);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el producto con el ID: " + idProducto);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
    }



    private List<String> getImeiByProductoId(Long productId) {
        List<String> imeis = new ArrayList<>();
        String query = "SELECT imei FROM imeis WHERE idProducto = ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                imeis.add(resultSet.getString("imei"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener imeis" + e.getMessage());
        }
        return imeis;
    }
}
