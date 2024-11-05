package com.moi.model;

import java.util.Date;

public class PayrollModel {

    private int documento;
    private int codigo;
    private String nombre;
    private int basico;
    private int prepago;
    private int postpago;
    private int otros;
    private int subtotal;
    private int total;


    public PayrollModel() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public int getPostpago() {
        return postpago;
    }

    public void setPostpago(int postpago) {
        this.postpago = postpago;
    }

    public int getPrepago() {
        return prepago;
    }

    public void setPrepago(int prepago) {
        this.prepago = prepago;
    }

    public int getBasico() {
        return basico;
    }

    public void setBasico(int basico) {
        this.basico = basico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
}
