package com.moi.model;

import java.sql.*;

public class InventoryModel {

    private String id;
    private String producto;
    private String color;
    private int numeroExistencias;
    private int codigo;
    private long imei;
    private Date fechaLimiteVenta;
    private String tipoDeProducto;

    public InventoryModel() {
    }


    public String getId() {return id;}

    public void setId(String id) { this.id= id;}

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getColor() {return color;}

    public void setColor(String color) { this.color = color; }

    public short getNumeroExistencias() { return (short) numeroExistencias;
    }

    public void setNumeroExistencias(short numeroExistencias) {
        this.numeroExistencias =  numeroExistencias;
    }
    public int getCodigo(){return codigo;}

    public void setCodigo(int codigo){this.codigo= codigo;}

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) { this.imei = imei; }

    public Date getFechaLimiteVentas() {
        return fechaLimiteVenta;
    }

    public void setFechaLimiteVenta(Date fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    public String setTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }




}
