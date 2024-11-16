package com.moi.model;

import java.util.Date;

public class AccountingModel {

    private Date fecha;
    private int factura;
    private String descripcion;
    private String detalle;
    private int cantidad;
    private int ingresos;
    private int egresos;
    private int total;

    public AccountingModel() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
