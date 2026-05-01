package com.moi.model;
import java.util.List;
import java.util.ArrayList;

public class SearchModel {

    private String name;
    private String color;
    private List<String> imeis;
    private String code;
    private String coming;
    private int quantity;
    private String type;

    public SearchModel() {
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

    public List<String> getImeis() {
        return imeis;
    }

    public void setImeis(List<String> imeis) {
        this.imeis = imeis;
    }
}
