package com.moi.controller.inventory;


import com.moi.dao.InventoryDAO;
import com.moi.dao.InventoryDAOImpl;
import com.moi.model.InventoryModel;
import com.moi.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/inventories")
public class InventoryServletController extends HttpServlet {

    InventoryDAO inventoryDAO = new InventoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InventoryModel> inventories= inventoryDAO.getAllInventory();
        request.setAttribute("inventories", inventories);
        request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idProducto = request.getParameter("idProducto");
        String producto = request.getParameter("producto");
        String colorProducto = request.getParameter("colorProducto");
        int numeroExistencias = Integer.parseInt(request.getParameter("numeroExistencias"));
        int imeiProducto = Integer.parseInt(request.getParameter("imeiProducto"));
        String fechaLimiteVenta = request.getParameter("fechaLimiteVenta");
        String tipoDeProducto = request.getParameter("tipoDeProducto");

      //  InventoryModel inventoryModel = new InventoryDAOImpl().insertProduct();
    }
}
