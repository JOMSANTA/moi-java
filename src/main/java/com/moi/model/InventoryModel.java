package com.moi.model;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class InventoryModel {

    private long idProduct;
    private String name;
    private String color;
   // private long imei;
    private String code;
    private String coming;
    private int quantity;
    private String type;



    public InventoryModel() {
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

/*    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }
*/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComing() {
        return coming;
    }

    public void setComing(String coming) {
        this.coming = coming;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
   
    }
    private List<String> imeis;

    public void setImeis(List<String> imeis){
        this.imeis = imeis;
    }
    public  List<String> getImeis() {
        return  imeis;
    }

   
}