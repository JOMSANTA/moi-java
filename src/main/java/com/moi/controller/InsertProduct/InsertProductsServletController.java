package com.moi.controller.InsertProduct;

import com.moi.dao.InsertProductDAOImpl;
import com.moi.dao.InventoryDAOImpl;
import com.moi.model.InventoryModel;
import com.moi.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/insertProducts")
public class InsertProductsServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<InventoryModel> inventories =new InventoryDAOImpl().getAllInventory();
        request.setAttribute("inventories", inventories);


        request.getRequestDispatcher("/WEB-INF/views/insertProducts/insertProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String product = request.getParameter("producto");
        String color = request.getParameter("color");
      //  String quantity = request.getParameter("numeroExistencias");
        String code = request.getParameter("codigo");
        String imei = request.getParameter("imei");
        String coming =  request.getParameter("fechaLimiteVenta");
        String type = request.getParameter("tipoDeProducto");

        if (product != null && color != null){ // validar parametros reqqueridos
            ProductModel model= new ProductModel();model.setName(product);
           model.setColor(color);
      //     model.setQuantity(quantity != null ? Integer.parseInt(quantity) :0);
           model.setCode(code);
           model.setImei(imei != null && !imei.trim().isEmpty() ? Long.parseLong(imei) : 0l);
           model.setComing(coming);
           model.setType(type);

            InsertProductDAOImpl productRegDAO = new InsertProductDAOImpl();
            productRegDAO.insertProduct(model);

            System.out.println("producto insertado");

        }else {
            request.setAttribute("error","Falló insertar el producto");
        }

        response.sendRedirect(request.getContextPath()+"/insertProducts");


    }
}