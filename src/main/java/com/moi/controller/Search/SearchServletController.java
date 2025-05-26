package com.moi.controller.Search;


import com.moi.dao.InventoryDAO;
import com.moi.dao.InventoryDAOImpl;
import com.moi.dao.SearchDAOImpl;
import com.moi.model.InventoryModel;
import com.moi.model.SearchModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchs")
public class SearchServletController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SearchModel> searchs = new SearchDAOImpl().getAllSearch();





        request.setAttribute("searchs", searchs);

        request.getRequestDispatcher("/WEB-INF/views/searchs/search.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String imeis = request.getParameter("imeis");
        String code = request.getParameter("code");

        // Aquí llamas al DAO para obtener los productos que coinciden con los criterios de búsqueda
        List<SearchModel> searchs = new SearchDAOImpl().searchProducts(name, color, imeis, code);

        // Si no se encuentran resultados, inicializa una lista vacía
        if (searchs == null || searchs.isEmpty()) {
            searchs = new ArrayList<>();
        }

        // Pasa los resultados al JSP
        request.setAttribute("searchs", searchs);

        request.getRequestDispatcher("/WEB-INF/views/searchs/search.jsp").forward(request, response);
    }

}

