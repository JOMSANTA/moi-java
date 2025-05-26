package com.moi.controller.inventory;


import com.moi.dao.InventoryDAO;
import com.moi.dao.InventoryDAOImpl;
import com.moi.model.InventoryModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
      try {//datos del formulario
          String name = request.getParameter("name");
          String color = request.getParameter("color");
          String coming = request.getParameter("coming");
          String type = request.getParameter("type");
          String code = request.getParameter("code");

          // Validar que no este vacio
          String qtyStr = request.getParameter("quantity");
          int quantity = 0;
          if (qtyStr != null && !qtyStr.isEmpty()) {
              quantity = Integer.parseInt(qtyStr);
          } else {
              request.setAttribute("error", "La cantidad es requerida y debe ser un numero valido.");
              request.setAttribute("inventories", inventoryDAO.getAllInventory());
              request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request, response);
              return;  // Detener ejecución si hay error
          }

          //filtrar imei
          String[] imeis = request.getParameterValues("imeiProducto");
          List<String> imeiList = new ArrayList<>();
          if (imeis != null) {
              for (String i : imeis) {
                  if (i != null && !i.trim().isEmpty()) {
                      imeiList.add(i.trim());
                  }
              }
          }

          //modelo
          InventoryModel inventoryModel = new InventoryModel();
          inventoryModel.setName(name);
          inventoryModel.setColor(color);
          inventoryModel.setComing(coming);
          inventoryModel.setType(type);
          inventoryModel.setQuantity(quantity);
          inventoryModel.setCode(code);
          inventoryModel.setImeis(imeiList);

          //insertar y redirigir

          inventoryDAO.InsertProduct(inventoryModel);
          request.getSession().setAttribute("success", "Producto insertado correctamente.");
          response.sendRedirect("inventories");

      }catch (NumberFormatException e) {
          request.setAttribute("error", "formato numerico incorrecto: " + e.getMessage());
          request.setAttribute("inventories", inventoryDAO.getAllInventory());
          request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request, response);
      }catch (Exception e) {
          request.setAttribute("error", "Error al insertar el producto: " + e.getMessage());
          request.setAttribute("inventories", inventoryDAO.getAllInventory());
          request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request, response);
      }
    }
}
