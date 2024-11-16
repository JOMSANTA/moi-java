package com.moi.model;

import java.util.Date;

public class ReportModel {
    private Date fecha;
    private int codEmpleado;
    private String descripcion;
    private int postpago;
    private int prepago;
    private int tv;
    private int otros;

    public ReportModel() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }
}
