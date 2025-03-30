package com.moi.dao;

import com.moi.model.PayrollModel;

import java.util.List;

public interface PayrollDAO {

    void insertPay (PayrollModel model);
    List<PayrollModel> getAllPayrolls();
    PayrollModel getPayByCodigo(int codigo);
    PayrollModel getPayByDocumento(int documento);
    PayrollModel getPayByNombre(String nombre);
    void updatePay(int documento, PayrollModel model);
    void deletePay(int documento);

}
