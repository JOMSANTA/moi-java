package com.moi.dao;

import com.moi.model.InvoiceModel;
import com.moi.model.UserModel;

import java.awt.*;
import java.util.List;

public interface InvoiceDao {

    void insertInvoice(InvoiceModel model);
    UserModel getInvoiceByFactura(int factura);
    UserModel getInvoiceByDocumento(int documento);
    UserModel getInvoiceById(int id);
    UserModel getInvoiceByCodigo(String codigoProducto);
    UserModel getInvoiceByImei(int imei);
    List<InvoiceModel> getAllInvoices();


}
