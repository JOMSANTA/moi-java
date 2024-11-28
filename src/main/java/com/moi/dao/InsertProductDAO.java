package com.moi.dao;

import com.moi.model.ProductModel;
import com.moi.model.UserModel;

import java.util.List;

public interface InsertProductDAO {
    void insertProduct(ProductModel model);
    ProductModel getProductById(String idProducto);
    ProductModel getProductoByProducto(String producto);
    ProductModel getProductByImei(long imei);
    List<ProductModel> getAllProduct();
    void  updateProduct(long id, UserModel model);
    void deleteProductById(long id);


}
