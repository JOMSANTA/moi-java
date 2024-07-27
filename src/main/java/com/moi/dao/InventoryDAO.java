package com.moi.dao;

import com.moi.model.InventoryModel;

import java.util.List;

public interface InventoryDAO {

    void insertProduct (InventoryModel model);
    List<InventoryModel> getAllInventory();
    InventoryModel getProductById(String idProducto);
    InventoryModel geProductByName(String producto);
    InventoryModel getProductByImei(int imeiProducto);
    InventoryModel getProductByColor(String colorProducto);
    void  updateProduct (String idProducto, InventoryModel model);
    void  deleteProduct (String idProducto);

}
