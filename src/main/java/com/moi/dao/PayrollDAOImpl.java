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

    }

    @Override
    public List<PayrollModel> getAllPayrolls() {

        List<PayrollModel> payrolls = new ArrayList<>();
        String selectQuery = "SELECT * FROM nominas;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                PayrollModel payrollModel = new PayrollModel();
                payrollModel.setDocumento(resultSet.getInt("documento"));
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
