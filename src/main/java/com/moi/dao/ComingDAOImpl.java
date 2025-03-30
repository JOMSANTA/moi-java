package com.moi.dao;

import com.moi.model.InventoryModel;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComingDAOImpl implements ComingDAO{

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
    public InventoryModel getProductByComing(String coming) {
        return null;
    }

    @Override
    public  List<InventoryModel> getProductByComing() {

        List<InventoryModel> productList = new ArrayList<>();
        String stringQuery = " SELECT * FROM invent ORDER BY coming DESC";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(stringQuery);

        ResultSet resultSet = preparedStatement.executeQuery()){

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
