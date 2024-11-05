package com.moi.controller.coming;


import com.moi.dao.InventoryDAOImpl;
import com.moi.model.InventoryModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/comings")
public class comingServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<InventoryModel> inventories = new InventoryDAOImpl().getAllInventory();

        request.setAttribute("inventories", inventories);

        request.getRequestDispatcher("/WEB-INF/views/comings/coming.jsp").forward(request, response);
    }
}
