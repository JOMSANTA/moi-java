package com.moi.dao;

import com.moi.model.InventModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class InventDaoImpl implements InventDao{

    @Override
    public List<InventModel> getAllInvent() {

        return List.of();
    }

    @Override
    public InventModel getInventById(int id) {
        return null;
    }
}
