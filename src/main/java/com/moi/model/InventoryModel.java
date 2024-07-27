package com.moi.model;

import java.sql.*;

public class InventoryModel {

    private String idproducto;
    private String producto;
    private String colorProducto;
    private int numeroExistencias;
    private int imeiProducto;
    private Date fechaLimiteVenta;
    private String tipoDeProducto;



    public String getIdProducto() {
        return idproducto;
    }

    public void setIdProducto(String idproducto) {
        this.idproducto = idproducto;
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

    public void setNumeroExistencias(Short numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
    }

    public int getImeiProducto() {
        return imeiProducto;
    }

    public void setImeiProducto(Long imeiProducto) {
        this.producto = producto;
    }

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




    public static void Consultadb(Connection connection){
        String query = "SELECT * FROM inventario_oficina";
        Statement stmt ;
        ResultSet rs;
        String idProducto;
        String producto;
        String colorProducto;
        int numeroExistencias;
        int imeiProducto;
        Date fechaLimiteVenta;
        String tipoDeProducto;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()){
                idProducto = rs.getString("idProducto");
                producto = rs.getString("producto");
                colorProducto = rs.getString("colorProducto");
                numeroExistencias= rs.getInt("numeroExistencias");
                imeiProducto= rs.getInt("imeiProducto");
                fechaLimiteVenta= rs.getDate("fechaLimiteVenta");
                tipoDeProducto= rs.getString("tipoDeProducto");

                System.out.println("idProducto:" +idProducto+ " , producto:" +producto+ " , colorProducto:" +colorProducto+ " , numeroExistencias:" +numeroExistencias+ " , imeiProducto:" +imeiProducto+
                        " , fechaLimiteVenta:" +fechaLimiteVenta+ " , tipoDeProducto:" +tipoDeProducto);

            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void insertProcuct(Connection connection){
        String query = "INSERT INTO user (idProducto, producto, colorProducto, numeroExistencias, imeiProducto, fechaLimiteVenta, tipoDeProducto) VALUES(?,?,?,?,?,?,?);"
    }
}
