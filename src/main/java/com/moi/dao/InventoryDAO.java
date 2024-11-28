package com.moi.dao;

import com.moi.model.InventoryModel;

import java.util.List;

public interface InventoryDAO {

    void insertProduct (InventoryModel model);
    List<InventoryModel> getAllInventory();
    List<InventoryModel> getAllByFilterParamsInventory(String product, String color);

    List<InventoryModel> getAllByFilterParamsInventory(String product, String color, String imei);

    InventoryModel getProductById(String idProducto);
    InventoryModel getProductByName(String producto);
    InventoryModel getProductByImei(long imeiProducto);
    InventoryModel getProductByCodigo(String codigo);
    InventoryModel getProductByColor(String colorProducto);
    void  updateProduct (String idProducto, InventoryModel model);
    void  deleteProduct (String idProducto);

}
