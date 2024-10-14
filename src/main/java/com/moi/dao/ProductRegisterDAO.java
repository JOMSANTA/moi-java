package com.moi.dao;

import com.moi.model.ProductModel;
import com.moi.model.UserModel;

import java.util.Date;
import java.util.List;

public interface ProductRegisterDAO {
    void insertProduct(ProductModel model);
    ProductModel getProductById(String idProducto);
    ProductModel getProductoByProducto(String producto);
    List<ProductModel> getAllProduct();
    void  updateProduct(long id, UserModel model);
    void deleteProductById(long id);


}
