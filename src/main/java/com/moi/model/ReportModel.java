package com.moi.model;

import java.util.Date;

public class ReportModel {
    private long idReport;
    private String date;
    private String sucursal;
    private int postpago;
    private int kitContado;
    private int kitCuotas;
    private int tv;
    private String otros;
    private int quantity;

    public ReportModel() {}

    public long getIdReport() {
        return idReport;
    }

    public void setIdReport(long idReport) {
        this.idReport = idReport;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getPostpago() {
        return postpago;
    }

    public void setPostpago(int postpago) {
        this.postpago = postpago;
    }

    public int getKitContado() {
        return kitContado;
    }

    public void setKitContado(int kitContado) {
        this.kitContado = kitContado;
    }

    public int getKitCuotas() {
        return kitCuotas;
    }

    public void setKitCuotas(int kitCuotas) {
        this.kitCuotas = kitCuotas;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
