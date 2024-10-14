package com.moi.model;

import java.util.Date;

public class ProductModel {

    private String idProducto;
    private String producto;
    private String colorProducto;
    private int numeroExistencias;
    private int imeiProducto;
    private Date fechaLimiteVenta;
    private String tipoDeProducto;

    public ProductModel() {
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProduccto) {
        this.idProducto = idProduccto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(String colorProducto) {
        this.colorProducto = colorProducto;
    }


    public int getNumeroExistencias() {
        return numeroExistencias;
    }

    public void setNumeroExistencias(int numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
    }

    public java.sql.Date getFechaLimiteVenta() {
        return (java.sql.Date) fechaLimiteVenta;
    }

    public void setFechaLimiteVenta(Date fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    public int getImeiProducto() {
        return imeiProducto;
    }

    public void setImeiProducto(int imeiProducto) {
        this.imeiProducto = imeiProducto;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }
}
