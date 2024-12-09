package com.moi.dao;

import com.moi.model.InventoryModel;

import java.util.List;

public interface InventoryDAO {

    void insertProduct (InventoryModel model);
    List<InventoryModel> getAllInventory();
    List<InventoryModel> getAllByFilterParamsInventory(String product, String color);

    List<InventoryModel> getAllByFilterParamsInventory(String product, String color, String imei);

    List<InventoryModel> getAllByFilterParamsInventory(String product, String color, String imei, String code);

    InventoryModel getProductById(String idProducto);
    InventoryModel getProductByName(String producto);
    InventoryModel getProductByImei(long imeiProducto);
    InventoryModel getProductByCode(String code);
    InventoryModel getProductByColor(String colorProducto);
    void  updateProduct (String idProducto, InventoryModel model);
    void  deleteProduct (String idProducto);

}
