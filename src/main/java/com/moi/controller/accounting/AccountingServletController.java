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

        request.getRequestDispatcher("/WEB-INF/views/accounting/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String date = request.getParameter("date");
        String description = request.getParameter("description");
        String detail = request.getParameter("detail");
        String quantity = request.getParameter("quantity");
        String income = request.getParameter("income");
        String expenses = request.getParameter("expenses");
        String total = request.getParameter("total");

        if (date != null && !date.trim().isEmpty() &&
            detail != null && !detail.trim().isEmpty())  {
            AccountingModel model = new AccountingModel();

            model.setDate(date);
            model.setDescription(description != null ? description : "");
            model.setDetail(detail);
            model.setQuantity(parseIntegerOrNull(quantity));
            model.setIncome(parseIntegerOrNull(income));
            model.setExpenses(parseIntegerOrNull(expenses));
            model.setTotal(parseIntegerOrNull(total));

            AccountDAOImpl accountDAO = new AccountDAOImpl();
            accountDAO.insertAccount(model);

            System.out.println("registro agregado");


        } else {
            request.setAttribute("error al ingresar registro", "loginMessage");
        }
        response.sendRedirect(request.getContextPath() + "/accounting");
    }

    private Integer parseIntegerOrNull(String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
}
}