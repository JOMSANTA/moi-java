package com.moi.controller.inventory;

import com.moi.dao.InventoryDAOImpl;
import com.moi.dao.ReportDAOImpl;
import com.moi.model.InventoryModel;
import com.moi.model.ReportModel;
import com.moi.model.SearchModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/inventories")

public class InventoryServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<InventoryModel> inventories = new InventoryDAOImpl().getAllInventory();
        request.setAttribute("inventories", inventories);

        request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name= request.getParameter("name");
        String color= request.getParameter("color");
        String imei= request.getParameter("imei");
        String code= request.getParameter("code");
        String coming= request.getParameter("coming");
        String quantity= request.getParameter("quantity");
        String type= request.getParameter("type");

        if (name != null) {
            InventoryModel model = new InventoryModel();
            model.setName(name);
            model.setColor(color);
            model.setImei(Long.parseLong(imei));
            model.setCode(code);
            model.setComing(coming);
            model.setQuantity(Integer.parseInt(quantity));
            model.setType(type);

            InventoryDAOImpl inventoryDAO = new InventoryDAOImpl();
            inventoryDAO.InsertProduct(model);

            System.out.println("producto agregado");
        } else {
            request.setAttribute("error al ingresar producto", "inventoryMessage");

        }


        response.sendRedirect(request.getContextPath()+"/inventories");
    }


  /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            // Acción de eliminar
            String idProduct = request.getParameter("idProduct");
            if (idProduct != null && !idProduct.isEmpty()) {
                try {
                    // Eliminar producto
                    new InventoryDAOImpl().deleteInventory(Integer.parseInt(idProduct));
                    System.out.println("Producto eliminado correctamente.");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Acción de insertar
            String name = request.getParameter("name");
            String color = request.getParameter("color");
            String imei = request.getParameter("imei");
            String code = request.getParameter("code");
            String coming = request.getParameter("coming");
            String quantity = request.getParameter("quantity");
            String type = request.getParameter("type");

            if (name != null && !name.isEmpty()) {
                try {
                    // Crear y guardar el nuevo producto
                    InventoryModel model = new InventoryModel();
                    model.setName(name);
                    model.setColor(color);
                    model.setImei(Long.parseLong(imei));
                    model.setCode(code);
                    model.setComing(coming);
                    model.setQuantity(Integer.parseInt(quantity));
                    model.setType(type);

                    InventoryDAOImpl inventoryDAO = new InventoryDAOImpl();
                    inventoryDAO.InsertProduct(model);
                    System.out.println("Producto agregado correctamente.");
                } catch (Exception e) {
                    // En caso de error, mostrar mensaje
                    request.setAttribute("errorMessage", "Hubo un error al ingresar el producto.");
                    e.printStackTrace();
                }
            } else {
                // En caso de que no haya un nombre, muestra un error
                request.setAttribute("errorMessage", "El nombre del producto es obligatorio.");
            }
        }

        // Redirige a la página de inventarios después de la acción
        List<InventoryModel> inventories = new InventoryDAOImpl().getAllInventory();
        request.setAttribute("inventories", inventories);
        request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp").forward(request, response);
    }

*/


}
