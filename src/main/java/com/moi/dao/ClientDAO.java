package com.moi.dao;

import com.moi.model.ClientModel;

import java.util.List;

public interface ClientDAO {


   void  insertClient(ClientModel model);
   ClientModel getClientByIdClient(int IdClient);

    List<ClientModel> buscarClientes(String valor);
}
