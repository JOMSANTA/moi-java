package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.ClientModel;
import com.moi.model.InvoiceModel;
import com.moi.model.InvoiceDetailModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {


    @Override
    public void insertInvoice(InvoiceModel model) {

        String insertQuery = "INSERT INTO moi.invoice \n" +
                "(fecha, nombre, documento, codEmpleado, factura)\n" +
                " VALUES(?,?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFecha());
            preparedStatement.setString(2, model.getNombre());
            preparedStatement.setLong(3, model.getIdClient());
            preparedStatement.setInt(4, model.getCodEmpleado());
            preparedStatement.setInt(5, model.getFactura());


            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("error al insertar factura" + e.getMessage());
        }
    }

    public void insertFullInvoice(InvoiceModel model) {

        String insertInvoice = "INSERT INTO invoice (fecha, nombre, documento, codEmpleado, factura) VALUES (?, ?, ?, ?, ?)";
        String insertDetail = "INSERT INTO invoice_detail (idInvoice, idProduct, quantity, price) VALUES (?, ?, ?, ?)";
        String insertImei = "INSERT INTO invoice_imei (idDetail, imei) VALUES (?, ?)";

        Connection connection = null;

        try {
            connection = ConexionDb.getConnection();
            connection.setAutoCommit(false); //TRANSACTION

            // 1. INSERT INVOICE
            PreparedStatement psInvoice = connection.prepareStatement(insertInvoice, Statement.RETURN_GENERATED_KEYS);

            psInvoice.setString(1, model.getFecha());
            psInvoice.setString(2, model.getNombre());
            psInvoice.setLong(3, model.getIdClient()); // documento cliente
            psInvoice.setInt(4, model.getCodEmpleado());
            psInvoice.setInt(5, model.getFactura());

            psInvoice.executeUpdate();

            ResultSet rs = psInvoice.getGeneratedKeys();
            long idInvoice = 0;

            if (rs.next()) {
                idInvoice = rs.getLong(1);
            }

            if (model.getDetails() == null || model.getDetails().isEmpty()) {
                throw new Exception("La factura no tiene detalles");
            }

            // 2. INSERT DETAILS
            for (InvoiceDetailModel detail : model.getDetails()) {

                PreparedStatement psDetail = connection.prepareStatement(insertDetail, Statement.RETURN_GENERATED_KEYS);

                psDetail.setLong(1, idInvoice);
                psDetail.setLong(2, detail.getIdProduct());
                psDetail.setInt(3, detail.getQuantity());
                psDetail.setFloat(4, detail.getPrice());

                psDetail.executeUpdate();

                ResultSet rsDetail = psDetail.getGeneratedKeys();
                long idDetail = 0;

                if (rsDetail.next()) {
                    idDetail = rsDetail.getLong(1);
                }
// 3. INSERT IMEIS
                if (detail.getImeis() != null) {
                    for (String imei : detail.getImeis()) {
                        PreparedStatement psImei = connection.prepareStatement(insertImei);
                        psImei.setLong(1, idDetail);
                        psImei.setString(2, imei);
                        psImei.executeUpdate();
                    }
                }



            }

            connection.commit(); //TODO OK

        } catch (Exception e) {

            try {
                if (connection != null) {
                    connection.rollback(); // SI FALLA
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.err.println("Error al insertar factura: " + e.getMessage());

        } finally {

            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public InvoiceModel getInvoiceByFactura(int factura) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByDocumento(int documento) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceById(int id) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByCodigo(String codigoProducto) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByImei(int imei) {
        return null;
    }

    @Override
    public List<InvoiceModel> getAllInvoices() {

        List<InvoiceModel> invoices = new ArrayList<>();
        String selectQuery = "SELECT * FROM invoice;";

        try
                (Connection connection = ConexionDb.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InvoiceModel invoiceModel = new InvoiceModel();
                invoiceModel.setFecha(resultSet.getString("fecha"));
                invoiceModel.setNombre(resultSet.getString("nombre"));
                invoiceModel.setIdClient(resultSet.getLong("idClient"));
                invoiceModel.setCodEmpleado(resultSet.getInt("codEmpleado"));
                invoiceModel.setProducto(resultSet.getString("product"));
                invoiceModel.setIdProduct(resultSet.getString("idProducto"));
                invoiceModel.setImei(resultSet.getString("imei"));
                invoiceModel.setCantidad(resultSet.getInt("cantidad"));
                invoiceModel.setValorUnitario(resultSet.getFloat("valorUnitario"));
                invoiceModel.setSubTotal(resultSet.getFloat("subTotal"));
                invoiceModel.setIva(resultSet.getInt("iva"));
                invoiceModel.setTotal(resultSet.getFloat("total"));


                invoices.add(invoiceModel);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return invoices;
    }

    @Override
    public ClientModel getClientById(long idClient) {
        ClientModel clientModel = null;
        String query = "SELECT * FROM client WHERE idClient = ?";

        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                clientModel = new ClientModel();
                clientModel.setIdClient(resultSet.getLong("idClient"));
                clientModel.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientModel;
    }

}