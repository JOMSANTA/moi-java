package com.moi.model;

import java.util.Date;

public class ComingModel {

private String coming;
private int imei;
private String name;
private Date expirationDate;

    public ComingModel() {
    }

    public String getComing() {
        return coming;
    }

    public void setComing(String coming) {
        this.coming = coming;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpired() {
        Date currentDate = new Date(); // Obtiene la fecha actual
        return expirationDate.before(currentDate); // Devuelve true si la fecha de expiración ya pasó
    }
}
