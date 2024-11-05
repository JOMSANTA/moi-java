package com.moi.controller.inventory;

import com.moi.dao.InventoryDAOImpl;
import com.moi.model.InventoryModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/inventories")
public class inventoryServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<InventoryModel> inventories = new InventoryDAOImpl().getAllInventory();

        request.setAttribute("inventories", inventories);

       request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
