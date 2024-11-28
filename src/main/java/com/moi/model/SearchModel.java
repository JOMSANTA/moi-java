package com.moi.model;

public class SearchModel {

    private String producto;
    private String color;
    private int numeroExistencias;
    private String codigo;
    private long imei;
    private String fechaLimiteVenta;
    private String tipoDeProducto;

    public SearchModel() {
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroExistencias() {
        return numeroExistencias;
    }

    public void setNumeroExistencias(int numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getFechaLimiteVenta() {
        return fechaLimiteVenta;
    }

    public void setFechaLimiteVenta(String fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }
}
