package com.moi.model;

import java.util.List;

public class InvoiceModel {


    private String fecha;//PREGUNTAR POR ESTO

    private long idClient;
    private String nombre;
    private int factura;
    private int codEmpleado;
    private String producto;
    private String idProduct;
    private String imei;
    private int cantidad;
    private float valorUnitario;
    private float subTotal;
    private int iva;
    private float total;

    private List<InvoiceDetailModel> details;

    public List<InvoiceDetailModel> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailModel> details) {
        this.details = details;
    }

    public InvoiceModel(){

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long documento) {
        this.idClient = documento;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
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


}
