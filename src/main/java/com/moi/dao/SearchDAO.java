package com.moi.dao;

import com.moi.model.InventoryModel;
import com.moi.model.SearchModel;

import java.util.List;

public interface SearchDAO {


    SearchModel getProductByName(String producto);
    SearchModel getProductByImei(long imeiProducto);
    SearchModel getProductByCodigo(String codigo);
    SearchModel getProductByColor(String colorProducto);

    List<SearchModel> searchProducts(String producto, String color, String imei, String codigo);
}
