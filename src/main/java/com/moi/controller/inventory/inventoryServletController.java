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

        List<InventoryModel> inventories = null;

        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String imei = request.getParameter("imei");


        if (name != null || color != null) {
            name = name != null ? name : "";
            color = color != null ? color : "";
            imei = imei != null ? imei : "";
            // Buscar por nombre de producto
            inventories = new InventoryDAOImpl().getAllByFilterParamsInventory(name, color, imei);
        } else {
            // Traer toda la lista
            inventories = new InventoryDAOImpl().getAllInventory();
        }

        request.setAttribute("inventories", inventories);

        request.getRequestDispatcher("/WEB-INF/views/inventories/inventory.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//getInventoryByName //tomar params

        String producto = request.getParameter("producto");
        String color = request.getParameter("color");
        String numeroExistencias = request.getParameter("numeroExistencias");
        String codigo = request.getParameter("codigo");
        String imei = request.getParameter("imei");
        String fechaLimiteVenta = request.getParameter("fechaLimiteVenta");
        String tipoDeProducto = request.getParameter("tipoDeProducto");

        if (producto != null && color != null) { // validar parametros reqqueridos
            InventoryModel model = new InventoryModel();

//            model.setProducto(producto);
//            model.setColor(color);
//            model.setNumeroExistencias(numeroExistencias != null ? Integer.parseInt(numeroExistencias) : 0);
//            model.setCodigo(codigo);
//            model.setImei(imei != null ? Integer.parseInt(imei) : 0);
//            model.setFechaLimiteVenta(fechaLimiteVenta);
//            model.setTipoDeProducto(tipoDeProducto);

            InventoryDAOImpl inventoryDAO = new InventoryDAOImpl();
            inventoryDAO.insertProduct(model);

            System.out.println("producto insertado");

        } else {
            request.setAttribute("error ", " falla al insertar producto");
        }

        response.sendRedirect(request.getContextPath() + "/productsRegister");

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("productId");

        if (productId != null) {
            // ir a borrar de la base de datos
            System.out.println("Eliminando producto con id: " + productId);
        } else {
            // Enviar Mensaje de error
            System.err.println("Debe enviar un ID del producto para eliminar");
        }

        doGet(request, response);

    }
}