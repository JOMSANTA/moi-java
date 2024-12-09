package com.moi.model;

import java.util.Date;

public class ProductModel {

    private Long id;
    private String name;
    private String color;
    private long imei;
    private String code;
    private String coming;
    private String type;

    public ProductModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
