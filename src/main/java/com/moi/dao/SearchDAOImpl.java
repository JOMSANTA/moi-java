package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.InventoryModel;
import com.moi.model.SearchModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDAOImpl implements SearchDAO {

    @Override
    public List<SearchModel> getAllSearch() {

        List<SearchModel> searchs = new ArrayList<>();
        String query = "SELECT * FROM inventory";


        try(Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                SearchModel search = new SearchModel();
                search.setName(resultSet.getString("name"));
                search.setColor(resultSet.getString("color"));
                search.setImei(resultSet.getLong("imei"));
                search.setCode(resultSet.getString("code"));
                search.setComing(resultSet.getString("coming"));
                search.setQuantity(resultSet.getInt("quantity"));
                search.setType(resultSet.getString("type"));

                searchs.add(search);
            }

        } catch (SQLException e) {
            System.err.println("Error getting products: " + e.getMessage());
        }

        return searchs;
    }

    @Override
    public SearchModel getProductByName(String name) {
        List<SearchModel> searchs = new ArrayList<>();

        String query = "SELECT * FROM inventory WHERE name LIKE ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SearchModel search = new SearchModel();
                search.setName(resultSet.getString("name"));
                search.setColor(resultSet.getString("color"));
                search.setImei(resultSet.getLong("imei"));
                search.setCode(resultSet.getString("code"));
                search.setComing(resultSet.getString("coming"));
                search.setQuantity(resultSet.getInt("quantity"));
                search.setType(resultSet.getString("type"));

                searchs.add(search);
            }

        } catch (SQLException e) {
            System.err.println("Error getting products by name: " + e.getMessage());


        }
        return (SearchModel) searchs;
    }

    @Override
    public SearchModel getProductByImei(long imeiProducto) {
        return null;
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
        List<SearchModel> searchs = new ArrayList<>();

        // Inicia la consulta
        String query = "SELECT * FROM inventory WHERE 1=1";
        // "1=1" es una condición siempre verdadera para facilitar la adición dinámica de filtros

        // Agrega filtros si los parámetros no son nulos o vacíos
        if (producto != null && !producto.isEmpty()) {
            query += " AND name LIKE ?";
        }
        if (color != null && !color.isEmpty()) {
            query += " AND color LIKE ?";
        }
        if (imei != null && !imei.isEmpty()) {
            query += " AND imei = ?";
        }
        if (codigo != null && !codigo.isEmpty()) {
            query += " AND code LIKE ?";
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
                statement.setLong(paramIndex++, Long.parseLong(imei));
            }
            if (codigo != null && !codigo.isEmpty()) {
                statement.setString(paramIndex++, "%" + codigo + "%");
            }

            // Ejecuta la consulta
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SearchModel search = new SearchModel();
                search.setName(resultSet.getString("name"));
                search.setColor(resultSet.getString("color"));
                search.setImei(resultSet.getLong("imei"));
                search.setCode(resultSet.getString("code"));
                search.setComing(resultSet.getString("coming"));
                search.setQuantity(resultSet.getInt("quantity"));
                search.setType(resultSet.getString("type"));
                searchs.add(search);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los productos: " + e.getMessage());
        }

        return searchs;
    }

  }

