package com.moi.controller;

import com.moi.dao.ClientDAOImpl;
import com.moi.model.ClientModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/clientsRegister")
public class ClientsServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/clientsRegister/registerClients.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String idClient = request.getParameter("idClient");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cel = request.getParameter("cel");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");

        if (idClient != null) {
            ClientModel model = new ClientModel();
            model.setIdCliente(Long.parseLong(idClient));
            model.setNombre(nombre);
            model.setApellido(apellido);
            model.setCel(Integer.parseInt(cel));
            model.setEmail(email);
            model.setDireccion(direccion);

            ClientDAOImpl clientDAO = new ClientDAOImpl();
            clientDAO.insertClient(model);

            System.out.println("cliente agregado");

        } else {
            request.setAttribute("error al ingresar cliente", "clientMessage");

        }
        request.getRequestDispatcher("/WEB-INF/views/clientsRegister/registerClients.jsp").forward(request, response);

    }
}
