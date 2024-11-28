package com.moi.controller.InsertProduct;

import com.moi.dao.InsertProductDAOImpl;
import com.moi.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertProducts")
public class InsertProductsServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/insertProducts/insertProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String producto = request.getParameter("producto");
        String color = request.getParameter("color");
        String numeroExistencias = request.getParameter("numeroExistencias");
        String codigo = request.getParameter("codigo");
        String imei = request.getParameter("imei");
        String fechaLimiteVenta =  request.getParameter("fechaLimiteVenta");
        String tipoDeProducto = request.getParameter("tipoDeProducto");

        if (producto != null && color != null){ // validar parametros reqqueridos
            ProductModel model= new ProductModel();

//            model.setProducto(producto);
//            model.setColor(color);
//            model.setNumeroExistencias(numeroExistencias != null ? Integer.parseInt(numeroExistencias) :0);
//            model.setCodigo(codigo);
//            model.setImei(imei != null && !imei.trim().isEmpty() ? Long.parseLong(imei) : 0l);
//            model.setFechaLimiteVenta(fechaLimiteVenta);
//            model.setTipoDeProducto(tipoDeProducto);

            InsertProductDAOImpl productRegDAO = new InsertProductDAOImpl();
            productRegDAO.insertProduct(model);

            System.out.println("producto insertado");

        }else {
            request.setAttribute("error","Falló insertar el producto");
        }

        response.sendRedirect(request.getContextPath()+"/insertProducts");


    }
}