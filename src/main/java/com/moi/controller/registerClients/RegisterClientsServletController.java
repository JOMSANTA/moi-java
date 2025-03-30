package com.moi.controller.registerClients;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clientsRegister")

public class RegisterClientsServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/clientsRegister/registerClients.jsp").forward(request, response);
    }
 /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idClient = req.getParameter("idClient");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String cel = req.getParameter("cel");
        String email = req.getParameter("email");
        String direccion = req.getParameter("direccion");

       if (idClient != null){

            ClientModel model = new ClientModel();
            model.setIdCliente(Long.parseLong(idClient));
            model.setNombre(nombre);
            model.setApellido(apellido);
            model.setCel(Integer.parseInt(cel));
            model.setEmail(email);
            model.setDireccion(direccion);

            ClientDAOImpl clientDAO= new ClientDAOImpl();
            clientDAO.insertClient(model);

            System.out.println("cliente agregado exitosamente");
        }else {
            req.setAttribute("error al ingresar cliente", "loginMessage");

        }
        resp.sendRedirect(req.getContextPath()+"/clientsRegister");

    }
}
*/
    }