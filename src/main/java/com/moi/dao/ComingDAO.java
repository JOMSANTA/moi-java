package com.moi.dao;

import com.moi.model.EmployeeModel;
import com.moi.model.InventoryModel;

import java.util.List;

public interface ComingDAO {

    InventoryModel getProductByComing(String coming);

    List<InventoryModel> getProductByComing();
}
