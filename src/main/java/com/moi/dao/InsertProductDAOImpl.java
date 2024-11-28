package com.moi.dao;

import com.moi.model.ProductModel;
import com.moi.model.UserModel;

import java.sql.*;
import java.util.List;

public class InsertProductDAOImpl implements InsertProductDAO {

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
    public void insertProduct(ProductModel model) {
        String insertQuery = "INSERT INTO moi.inventario_oficina\n" +
        "( producto, color, numeroExistencias, codigo,imei, fechaLimiteVenta, tipoDeProducto)\n" +
       "VALUES(?,?,?,?,?,?,?);";
            ResultSet rs= null;


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {


//            preparedStatement.setString(1, model.getProducto());
//            preparedStatement.setString(2, model.getColor());
//            preparedStatement.setInt(3, model.getNumeroExistencias());
//            preparedStatement.setString(4,model.getCodigo());
//            preparedStatement.setLong(5, model.getImei());
//            preparedStatement.setString(6, model.getFechaLimiteVenta());
//            preparedStatement.setString(7, model.getTipoDeProducto());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("ProductRegDAOImpl fallo para insertar producto :"+ e.getMessage());
        }

    }

    @Override
    public ProductModel getProductById(String idProducto) {
        return null;
    }

    @Override
    public ProductModel getProductoByProducto(String producto) {
        return null;
    }

    @Override
    public ProductModel getProductByImei(long imei) {
        return null;
    }

    @Override
    public List<ProductModel> getAllProduct() {
        return List.of();
    }

    @Override
    public void updateProduct(long id, UserModel model) {

    }

    @Override
    public void deleteProductById(long id) {

    }
}
