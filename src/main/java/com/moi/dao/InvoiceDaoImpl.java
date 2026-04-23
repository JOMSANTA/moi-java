package com.moi.dao;

import com.moi.ConnectionDb.ConexionDb;
import com.moi.model.ClientModel;
import com.moi.model.InvoiceModel;
import com.moi.model.InvoiceDetailModel;
import java.util.Map;
import java.util.HashMap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {



    public InvoiceModel getInvoiceFull(int factura) {

        String sql = "SELECT i.id, i.date, i.name, i.document, " +
                "d.id as detailId, d.idProduct, d.product, d.color, d.code, d.quantity, d.price, " +
                "im.imei " +
                "FROM invoice i " +
                "JOIN invoice_detail d ON i.id = d.idInvoice " +
                "LEFT JOIN invoice_imei im ON d.id = im.idDetail " +
                "WHERE i.id = ?";

        InvoiceModel invoice = null;
        Map<Long, InvoiceDetailModel> detailMap = new HashMap<>();

        try (Connection con = ConexionDb.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, factura);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (invoice == null) {
                    invoice = new InvoiceModel();
                    invoice.setId(rs.getLong("id"));
                    invoice.setDate(rs.getTimestamp("date").toLocalDateTime());
                    invoice.setName(rs.getString("name"));
                    invoice.setIdClient(rs.getLong("document"));
                    invoice.setDetails(new ArrayList<>());
                }

                long detailId = rs.getLong("detailId");

                InvoiceDetailModel detail = detailMap.get(detailId);

                if (detail == null) {
                    detail = new InvoiceDetailModel();

                    detail.setId(detailId);
                    detail.setIdProduct(rs.getLong("idProduct"));
                    detail.setProduct(rs.getString("product"));
                    detail.setColor(rs.getString("color"));
                    detail.setCode(rs.getString("code"));
                    detail.setQuantity(rs.getInt("quantity"));
                    detail.setPrice(rs.getFloat("price"));

                    detail.setImeis(new ArrayList<>());

                    detailMap.put(detailId, detail);
                    invoice.getDetails().add(detail);
                }

                String imei = rs.getString("imei");
                if (imei != null) {
                    detail.getImeis().add(imei);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoice;
    }


    @Override
    public void insertInvoice(InvoiceModel model) {

    }

    public long insertFullInvoice(InvoiceModel model) {

        String insertInvoice = "INSERT INTO invoice (date, name, document, codEmployee) VALUES ( ?, ?, ?, ?)";
        String insertDetail = "INSERT INTO invoice_detail (idInvoice, idProduct, product, color, code, quantity, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertImei = "INSERT INTO invoice_imei (idDetail, imei) VALUES (?, ?)";

        Connection connection = null;
        long idInvoice = 0;

        try {
            connection = ConexionDb.getConnection();
            connection.setAutoCommit(false); //TRANSACTION

            // 1. INSERT INVOICE
            PreparedStatement psInvoice = connection.prepareStatement(insertInvoice, Statement.RETURN_GENERATED_KEYS);

            psInvoice.setTimestamp(1, Timestamp.valueOf(model.getDate()));
            psInvoice.setString(2, model.getName());
            psInvoice.setLong(3, model.getIdClient()); // documento cliente
            psInvoice.setInt(4, model.getCodEmployee());

            psInvoice.executeUpdate();

            ResultSet rs = psInvoice.getGeneratedKeys();


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
                psDetail.setString(3, detail.getProduct());
                psDetail.setString(4, detail.getColor());
                psDetail.setString(5, detail.getCode());
                psDetail.setInt(6, detail.getQuantity());
                psDetail.setFloat(7, detail.getPrice());

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
        return idInvoice;
    }




    @Override
    public InvoiceModel getInvoiceByFactura(int invoice) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByDocumento(int document) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceById(int id) {
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByCodigo(String code) {
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

                invoiceModel.setId(resultSet.getLong("id"));
                invoiceModel.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                invoiceModel.setName(resultSet.getString("name"));
                invoiceModel.setIdClient(resultSet.getLong("document"));
                invoiceModel.setCodEmployee(resultSet.getInt("codEmployee"));

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

    @Override
    public long getLastInvoiceNumber() {
        return 0;
    }

}