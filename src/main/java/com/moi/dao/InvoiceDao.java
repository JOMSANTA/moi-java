package com.moi.dao;

import com.moi.model.ClientModel;
import com.moi.model.InvoiceModel;



import java.util.List;

public interface InvoiceDao {

    void insertInvoice(InvoiceModel model);
    public long insertFullInvoice(InvoiceModel model);
    InvoiceModel getInvoiceFull(int factura);
    InvoiceModel getInvoiceByFactura(int factura);
    InvoiceModel getInvoiceByDocumento(int documento);
    InvoiceModel getInvoiceById(int id);
    InvoiceModel getInvoiceByCodigo(String codigoProducto);
    InvoiceModel getInvoiceByImei(int imei);
    List<InvoiceModel> getAllInvoices();
    ClientModel getClientById(long idClient);

    long getLastInvoiceNumber();
}
