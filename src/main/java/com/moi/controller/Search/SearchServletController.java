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
import java.util.List;

@WebServlet("/searchs")
public class SearchServletController extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/searchs/search.jsp").forward(request, response);
    }



}

