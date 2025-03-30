package com.moi.dao;
import com.moi.model.AccountingModel;

import java.util.Date;
import java.util.List;

public interface AccountDAO {

    void insertAccount(AccountingModel model);
    List<AccountingModel> getAllAccount();
    AccountingModel getAccountByFactura(int invoice);
    AccountingModel getAccountByFecha(Date date);
    void updateAccount(int invoice, AccountingModel model);
    void deleteAccount(int invoice);

}
