package com.moi.model;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceModel {

    private long id;
    private LocalDateTime date;

    private long idClient;
    private String name; // nombre del cliente
    private int invoice;
    private int codEmployee;

    private float subTotal;
    private int iva;
    private float total;

    // Lista de detalles (productos)
    private List<InvoiceDetailModel> details;

    public InvoiceModel() {}

    // GETTERS Y SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public int getCodEmployee() {
        return codEmployee;
    }

    public void setCodEmployee(int codEmployee) {
        this.codEmployee = codEmployee;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<InvoiceDetailModel> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailModel> details) {
        this.details = details;
    }
}