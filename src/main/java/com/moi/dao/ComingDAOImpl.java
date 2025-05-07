package com.moi.dao;

import com.moi.model.InventoryModel;
import com.moi.ConnectionDb.ConexionDb;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComingDAOImpl implements ComingDAO{


    @Override
    public InventoryModel getProductByComing(String coming) {
        return null;
    }

    @Override
    public  List<InventoryModel> getProductByComing() {

        List<InventoryModel> productList = new ArrayList<>();
        String stringQuery = "SELECT * FROM invent ORDER BY coming DESC";

        try (
        Connection connection = ConexionDb.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(stringQuery);
        ResultSet resultSet = preparedStatement.executeQuery()
        ){

        while (resultSet.next()) {
            InventoryModel product = new InventoryModel();
            product.setIdProduct(resultSet.getInt("idProduct"));
            product.setName(resultSet.getString("name"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setComing(resultSet.getString("coming"));


            productList.add(product);
        }


            }catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL");
            e.printStackTrace(); // Es recomendable imprimir la traza para depurar
        }
        System.out.println("Producto Lista: " + productList.size());

        return productList;
    }
}
