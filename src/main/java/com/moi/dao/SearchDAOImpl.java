package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.InventoryModel;
import com.moi.model.SearchModel;
import java.util.Map;
import java.util.LinkedHashMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDAOImpl implements SearchDAO {

    @Override
    public List<SearchModel> getAllSearch() {

        Map<Long, SearchModel> map = new LinkedHashMap<>();

        String query =
                "SELECT p.idProduct, p.name, p.color, p.code, p.coming, p.type, " +
                        "i.quantity, im.imei " +
                        "FROM product p " +
                        "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                        "LEFT JOIN imeis im ON p.idProduct = im.idProduct ";


        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("idProduct");

                SearchModel search = map.get(id);
                if (search == null) {

                    search = new SearchModel();
                    search.setName(resultSet.getString("name"));
                    search.setColor(resultSet.getString("color"));
                    search.setCode(resultSet.getString("code"));
                    search.setComing(resultSet.getString("coming"));
                    search.setQuantity(resultSet.getInt("quantity"));
                    search.setType(resultSet.getString("type"));
                    search.setImeis(new ArrayList<>());


                    map.put(id, search);
                }

                String imeiValue = resultSet.getString("imei");
                if (imeiValue != null) {
                    search.getImeis().add(imeiValue);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error getting products: " + e.getMessage());
        }

        return new ArrayList<>(map.values());


    }

    @Override
    public List<SearchModel> getProductByName(String name) {
        Map<Long, SearchModel> map = new LinkedHashMap<>();

        String query =

                "SELECT p.idProduct, p.name, p.color, p.code, p.coming, p.type, " +
                        "i.quantity, im.imei " +
                        "FROM product p " +
                        "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                        "LEFT JOIN imeis im ON p.idProduct = im.idProduct " +
                        "WHERE p.name LIKE ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("idProduct");

                SearchModel search = map.get(id);

                if (search == null) {

                    search = new SearchModel();

                    search.setName(resultSet.getString("name"));
                    search.setColor(resultSet.getString("color"));
                    search.setCode(resultSet.getString("code"));
                    search.setComing(resultSet.getString("coming"));
                    search.setQuantity(resultSet.getInt("quantity"));
                    search.setType(resultSet.getString("type"));
                    search.setImeis(new ArrayList<>());

                    map.put(id, search);

                }

                String imeiValue = resultSet.getString("imei");
                if (imeiValue != null) {
                    search.getImeis().add(imeiValue);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error getting products by name: " + e.getMessage());


        }
        return new ArrayList<>(map.values());
    }

    @Override
    public SearchModel getProductByImei(long imeiProducto) {

        SearchModel search = null;

        String query =
                "SELECT p.idProduct, p.name, p.color, p.code, p.coming, p.type, " +
                        "i.quantity, im.imei " +
                        "FROM product p " +
                        "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                        "LEFT JOIN imeis im ON p.idProduct = im.idProduct " +
                        "WHERE im.imei = ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, imeiProducto);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                search = new SearchModel();
                search.setName(rs.getString("name"));
                search.setColor(rs.getString("color"));
                search.setCode(rs.getString("code"));
                search.setComing(rs.getString("coming"));
                search.setQuantity(rs.getInt("quantity"));
                search.setType(rs.getString("type"));

                search.setImeis(new ArrayList<>());
            }
            // agregar TODOS los imeis del producto
            while (rs.next()) {
                String imei = rs.getString("imei");
                if (imei != null) {
                    search.getImeis().add(imei);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error getting product by imei: " + e.getMessage());
        }

        return search;
    }

    @Override
    public SearchModel getProductByCodigo(String codigo) {
        return null;
    }

    @Override
    public SearchModel getProductByColor(String colorProducto) {
        return null;
    }

    @Override
    public void insertProduct(SearchModel model) {

    }

    @Override
    public List<SearchModel> searchProducts(String producto, String color, String imei, String codigo) {

        //  MAP AQUÍ
        Map<Long, SearchModel> map = new LinkedHashMap<>();

        // Inicia la consulta
        String query =
                "SELECT p.idProduct, p.name, p.color, p.code, p.coming, p.type, " +
                        "i.quantity, im.imei " +
                        "FROM product p " +
                        "LEFT JOIN inventory i ON p.idProduct = i.idProduct " +
                        "LEFT JOIN imeis im ON p.idProduct = im.idProduct " +
                        "WHERE 1=1";
        // "1=1" es una condición siempre verdadera para facilitar la adición dinámica de filtros

        // Agrega filtros si los parámetros no son nulos o vacíos
        if (producto != null && !producto.isEmpty()) {
            query += " AND p.name LIKE ?";
        }
        if (color != null && !color.isEmpty()) {
            query += " AND p.color LIKE ?";
        }
        if (imei != null && !imei.isEmpty()) {
            query += " AND p.idProduct IN (SELECT idProduct FROM imeis WHERE imei LIKE ?)";
        }
        if (codigo != null && !codigo.isEmpty()) {
            query += " AND p.code LIKE ?";
        }

        // Conexión a la base de datos
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            int paramIndex = 1;

            // Establece los valores de los parámetros dinámicamente
            if (producto != null && !producto.isEmpty()) {
                statement.setString(paramIndex++, "%" + producto + "%");
            }
            if (color != null && !color.isEmpty()) {
                statement.setString(paramIndex++, "%" + color + "%");
            }
            if (imei != null && !imei.isEmpty()) {
                statement.setString(paramIndex++, "%" + imei + "%");
            }
            if (codigo != null && !codigo.isEmpty()) {
                statement.setString(paramIndex++, "%" + codigo + "%");
            }

            // Ejecuta la consulta
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("idProduct");

                SearchModel search = map.get(id);
                if (search == null) {
                    search = new SearchModel();
                    search.setName(resultSet.getString("name"));
                    search.setColor(resultSet.getString("color"));
                    search.setCode(resultSet.getString("code"));
                    search.setComing(resultSet.getString("coming"));
                    search.setQuantity(resultSet.getInt("quantity"));
                    search.setType(resultSet.getString("type"));
                    search.setImeis(new ArrayList<>());

                    map.put(id, search);
                }
                String imeiValue = resultSet.getString("imei");
                if (imeiValue != null && !search.getImeis().contains(imeiValue)) {
                    search.getImeis().add(imeiValue);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los productos: " + e.getMessage());
        }

        return new ArrayList<>(map.values());
    }
}


