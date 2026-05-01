
package com.moi.controller.clients;


import com.moi.dao.ClientDAOImpl;
import com.moi.model.ClientModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")

public class RegisterClientsServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/clients/registerClients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String idClient = request.getParameter("idClient");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String cel = request.getParameter("cel");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");

        String errorMessage = null;

        if (isNullOrEmpty(idClient) || isNullOrEmpty(name) || isNullOrEmpty(lastName) ||
                isNullOrEmpty(cel) || isNullOrEmpty(email) || isNullOrEmpty(adress)){
            errorMessage= "Todos los campos son obligatorios. ";
        }  else if (!cel.matches("\\d{10}")) {
            errorMessage = "Verifica el numero celular.";
        }
        if (errorMessage != null){
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/WEB-INF/views/clients/registerClients.jsp").forward(request, response);
            return;
        }


            ClientModel model = new ClientModel();
            model.setIdClient(Long.parseLong(idClient));
            model.setName(name);
            model.setLastName(lastName);
            model.setCel(Integer.parseInt(cel));
            model.setEmail(email);
            model.setAdress(adress);

            ClientDAOImpl clientDAO = new ClientDAOImpl();
            clientDAO.insertClient(model);

            request.setAttribute("successMessage", "Cliente registrado correctamente");
            request.getRequestDispatcher("/WEB-INF/views/clients/registerClients.jsp").forward(request, response);


        }
        private boolean isNullOrEmpty(String str){
        return str == null || str.trim().isEmpty();
        }

}

