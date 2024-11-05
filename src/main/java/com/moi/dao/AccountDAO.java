package com.moi.dao;
import com.moi.model.AccountingModel;

import java.util.Date;
import java.util.List;

public interface AccountDAO {

    void insertAccount(AccountingModel model);
    List<AccountingModel> getAllAccount();
    AccountingModel getAccountByFactura(int factura);
    AccountingModel getAccountByFecha(Date fecha);
    void updateAccount(int factura, AccountingModel model);
    void deleteAccount(int factura);

}
