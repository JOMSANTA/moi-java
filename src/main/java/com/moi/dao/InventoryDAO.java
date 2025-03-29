package com.moi.dao;

import com.moi.model.EmployeeModel;
import com.moi.model.InventoryModel;

import java.util.List;

public interface InventoryDAO {

 void InsertProduct(InventoryModel model);

 List<InventoryModel> getAllInventory();

 InventoryModel getProductByName(String name);

 InventoryModel getProductByCode(String code);

 InventoryModel getProductByImei(Long imei);


 void deleteInventory(int id);
}


