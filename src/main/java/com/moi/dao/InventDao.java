package com.moi.dao;

import com.moi.model.InventModel;
import com.moi.model.InventoryModel;
import com.moi.model.InvoiceModel;

import java.util.List;

public interface InventDao {

    List<InventModel> getAllInvent();
    InventModel getInventById(int id);
}
