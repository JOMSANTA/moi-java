package com.moi.dao;

import com.moi.model.InvoiceModel;



import java.util.List;

public interface InvoiceDao {

    void insertInvoice(InvoiceModel model);
    InvoiceModel getInvoiceByFactura(int factura);
    InvoiceModel getInvoiceByDocumento(int documento);
    InvoiceModel getInvoiceById(int id);
    InvoiceModel getInvoiceByCodigo(String codigoProducto);
    InvoiceModel getInvoiceByImei(int imei);
    List<InvoiceModel> getAllInvoices();


}
