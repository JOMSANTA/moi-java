package com.moi.model;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeModel {
  private int documento;
  private String nombres;
  private  String apellidos;
  private int codigo;
  private long celular;
  private String correo;
  private  String cargo;
  private LocalDate fechaNacimiento;
  private String sucursal;

    public EmployeeModel() {
    }

    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
            this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodigo(){
       return codigo;

    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaNacimiento() {
        return (LocalDate) fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
