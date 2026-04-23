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
        String Query = "INSERT INTO `moi`.`accounting` (`date`,`description`, `detail`, `quantity`, `income`, `expenses`, `total`) VALUES (?,?,?,?,?,?,?);";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(Query)){


            preparedStatement.setString(1,model.getDate());
            preparedStatement.setString(2,model.getDescription());
            preparedStatement.setString(3,model.getDetail());
            preparedStatement.setObject(4,model.getQuantity());
            preparedStatement.setObject(5,model.getIncome());
            preparedStatement.setObject(6,model.getExpenses());
            preparedStatement.setObject(7,model.getTotal());

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
                Integer quantity = resultSet.getObject("quantity", Integer.class);
                accountingModel.setQuantity(quantity);
                Integer income = resultSet.getObject("income",Integer.class);
                accountingModel.setIncome(income);
                Integer expenses = resultSet.getObject("expenses",Integer.class);
                accountingModel.setExpenses(expenses);
                Integer total = resultSet.getObject("total",Integer.class);
                accountingModel.setTotal(total);

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
