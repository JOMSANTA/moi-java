package com.moi.model;

public class InventModel {

    private long idInvent;
    private int quantity;
    private int idProduct;

    public InventModel() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getIdInventoty() {
        return idInvent;
    }

    public void setIdInventoty(long idInventoty) {
        this.idInvent = idInventoty;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
