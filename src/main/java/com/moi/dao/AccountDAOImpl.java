package com.moi.dao;

import com.moi.model.AccountingModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

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
    public void insertAccount(AccountingModel model) {

    }

    @Override
    public List<AccountingModel> getAllAccount() {
        List<AccountingModel> accounting = new ArrayList<>();
        String selectQuery = "SELECT * FROM contabilidad;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                AccountingModel accountingModel = new AccountingModel();
                accountingModel.setFecha(resultSet.getDate("fecha"));
                accountingModel.setFactura(resultSet.getInt("factura"));
                accountingModel.setDescripcion(resultSet.getString("descripcion"));
                accountingModel.setDetalle(resultSet.getString("detalle"));
                accountingModel.setCantidad(resultSet.getInt("cantidad"));
                accountingModel.setValorUnitario(resultSet.getInt("valorUnitario"));
                accountingModel.setValorTotal(resultSet.getInt("valorTotal"));

                accounting.add(accountingModel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounting;

    }

    @Override
    public AccountingModel getAccountByFactura(int factura) {
        return null;
    }

    @Override
    public AccountingModel getAccountByFecha(Date fecha) {
        return null;
    }

    @Override
    public void updateAccount(int factura, AccountingModel model) {

    }

    @Override
    public void deleteAccount(int factura) {

    }
}
