package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.PayrollModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAOImpl  implements PayrollDAO{

    @Override
    public void insertPay(PayrollModel model) {
    String query = "INSERT INTO moi.payroll (date,code,name,basico,prepago,postpago,detalle,otros,subtotal,total) VALUES (?,?,?,?,?,?,?,?,?,?);";


    try (Connection connection = ConexionDb.getConnection();
         PreparedStatement preparedStatement= connection.prepareStatement(query)){


        preparedStatement.setString(1,model.getDate());
        preparedStatement.setInt(2,model.getCode());
        preparedStatement.setString(3,model.getName());
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

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                PayrollModel payrollModel = new PayrollModel();
                payrollModel.setDate(resultSet.getString("date"));
                payrollModel.setCode(resultSet.getInt("code"));
                payrollModel.setName(resultSet.getString("name"));
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
    public PayrollModel getPayByCodigo(int code) {
        return null;
    }

    @Override
    public PayrollModel getPayByDocumento(int document) {
        return null;
    }

    @Override
    public PayrollModel getPayByNombre(String name) {
        return null;
    }

    @Override
    public void updatePay(int document, PayrollModel model) {

    }

    @Override
    public void deletePay(int document) {

    }
}
