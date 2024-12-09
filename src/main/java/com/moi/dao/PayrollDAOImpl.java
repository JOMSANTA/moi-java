package com.moi.dao;

import com.moi.model.PayrollModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAOImpl  implements PayrollDAO{

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
    public void insertPay(PayrollModel model) {
    String query = "INSERT INTO moi.payroll (date,codigo,nombre,basico,prepago,postpago,detalle,otros,subTotal,total) VALUES (?,?,?,?,?,?,?,?,?,?);";


    try (Connection connection = getConnection();
         PreparedStatement preparedStatement= connection.prepareStatement(query)){


        preparedStatement.setString(1,model.getDate());
        preparedStatement.setInt(2,model.getCodigo());
        preparedStatement.setString(3,model.getNombre());
        preparedStatement.setInt(4,model.getBasico());
        preparedStatement.setInt(5,model.getPrepago());
        preparedStatement.setInt(6,model.getPostpago());
        preparedStatement.setString(7,model.getDetalle());
        preparedStatement.setInt(8,model.getOtros());
        preparedStatement.setInt(9,model.getSubtotal());
        preparedStatement.setInt(10,model.getTotal());

        preparedStatement.executeUpdate();

    }catch (SQLException e){
        System.err.println("error insertando pago : " + e.getMessage());
    }


    }

    @Override
    public List<PayrollModel> getAllPayrolls() {

        List<PayrollModel> payrolls = new ArrayList<>();
        String selectQuery = "SELECT * FROM payroll;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                PayrollModel payrollModel = new PayrollModel();
                payrollModel.setDate(resultSet.getString("date"));
                payrollModel.setCodigo(resultSet.getInt("codigo"));
                payrollModel.setNombre(resultSet.getString("nombre"));
                payrollModel.setBasico(resultSet.getInt("basico"));
                payrollModel.setPrepago(resultSet.getInt("prepago"));
                payrollModel.setPostpago(resultSet.getInt("postpago"));
                payrollModel.setOtros(resultSet.getInt("otros"));
                payrollModel.setSubtotal(resultSet.getInt("subtotal"));
                payrollModel.setTotal(resultSet.getInt("total"));

                payrolls.add(payrollModel);


            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return payrolls;
    }

    @Override
    public PayrollModel getPayByCodigo(int codigo) {
        return null;
    }

    @Override
    public PayrollModel getPayByDocumento(int documento) {
        return null;
    }

    @Override
    public PayrollModel getPayByNombre(String nombre) {
        return null;
    }

    @Override
    public void updatePay(int documento, PayrollModel model) {

    }

    @Override
    public void deletePay(int documento) {

    }
}
