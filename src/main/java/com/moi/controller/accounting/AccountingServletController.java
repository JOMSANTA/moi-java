package com.moi.controller.accounting;

import com.moi.dao.AccountDAOImpl;
import com.moi.model.AccountingModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/accounting")
public class AccountingServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<AccountingModel> accounting = new AccountDAOImpl().getAllAccount();
        request.setAttribute("accounting", accounting);

        request.getRequestDispatcher("/WEB-INF/views/accounting/account.jsp").forward(request,response);
    }
}
