package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.AccountingModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {



    @Override
    public void insertAccount(AccountingModel model) {
        String Query = "INSERT INTO `moi`.`accounting` (`date`, `invoice`, `description`, `detail`, `quantity`, `income`, `expenses`, `total`) VALUES (?, ?,?,?,?,?,?,?);";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(Query)){


            preparedStatement.setString(1,model.getDate());
            preparedStatement.setInt(2,model.getInvoice());
            preparedStatement.setString(3,model.getDescription());
            preparedStatement.setString(4,model.getDetail());
            preparedStatement.setInt(5,model.getQuantity());
            preparedStatement.setInt(6,model.getIncome());
            preparedStatement.setInt(7,model.getExpenses());
            preparedStatement.setInt(8,model.getTotal());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.err.println("error insertando registro : " + e.getMessage());
        }

    }

    @Override
    public List<AccountingModel> getAllAccount() {
        List<AccountingModel> accounting = new ArrayList<>();
        String selectQuery = "SELECT * FROM moi.accounting";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                AccountingModel accountingModel = new AccountingModel();
                accountingModel.setDate(resultSet.getString("date"));
                accountingModel.setInvoice(resultSet.getInt("invoice"));
                accountingModel.setDescription(resultSet.getString("description"));
                accountingModel.setDetail(resultSet.getString("detail"));
                accountingModel.setQuantity(resultSet.getInt("quantity"));
                accountingModel.setIncome(resultSet.getInt("income"));
                accountingModel.setExpenses(resultSet.getInt("expenses"));

                accounting.add(accountingModel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounting;

    }

    @Override
    public AccountingModel getAccountByFactura(int invoice) {
        return null;
    }

    @Override
    public AccountingModel getAccountByFecha(Date date) {
        return null;
    }

    @Override
    public void updateAccount(int invoice, AccountingModel model) {

    }

    @Override
    public void deleteAccount(int invoice) {

    }
}
