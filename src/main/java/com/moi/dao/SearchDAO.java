package com.moi.dao;
import com.moi.model.SearchModel;

import java.util.List;

public interface SearchDAO {

    List<SearchModel> getAllSearch();
    List<SearchModel> getProductByName(String name);
    SearchModel getProductByImei(long imeiProducto);
    SearchModel getProductByCodigo(String codigo);
    SearchModel getProductByColor(String colorProducto);
    void  insertProduct (SearchModel model);
    List<SearchModel> searchProducts(String producto, String color, String imei, String codigo);


}
