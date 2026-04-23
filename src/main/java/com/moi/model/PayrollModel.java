package com.moi.model;

import java.util.Date;

public class PayrollModel {

    private int id;
    private String date;
    private int code;
    private String name;
    private int basico;
    private int prepago;
    private int postpago;
    private String detalle;
    private int subtotal;
    private int otros;
    private int total;


    public PayrollModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int codigo) {
        this.code = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public int getBasico() {
        return basico;
    }

    public void setBasico(int basico) {
        this.basico = basico;
    }

    public int getPrepago() {
        return prepago;
    }

    public void setPrepago(int prepago) {
        this.prepago = prepago;
    }

    public int getPostpago() {
        return postpago;
    }

    public void setPostpago(int postpago) {
        this.postpago = postpago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}