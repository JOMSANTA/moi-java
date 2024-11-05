package com.moi.dao;

import com.moi.model.InvoiceModel;
import com.moi.model.UserModel;

import java.sql.*;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao{

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }


    @Override
    public void insertInvoice(InvoiceModel model) {
        //InvoiceModel invoices = new InvoiceModel();
        String insertQuery = "INSERT INTO moi.factura (`fecha`, `idCliente`, `nombreCliente`, `codEmpleado`, `idProducto`, `nombreProducto`, `imeiProducto`, `valorUnitario`, `cantidadProductos`, `subTotal`, `iva`, `total`) VALUES ('?', '?','?', '?','?', '?','?', '?','?', '?','?', '?',);";



        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){



           preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.out.println("error al insertar factura"+ e.getMessage());
        }
    }

    @Override
    public UserModel getInvoiceByFactura(int factura) {
        return null;
    }

    @Override
    public UserModel getInvoiceByDocumento(int documento) {
        return null;
    }

    @Override
    public UserModel getInvoiceById(int id) {
        return null;
    }

    @Override
    public UserModel getInvoiceByCodigo(String codigoProducto) {
        return null;
    }

    @Override
    public UserModel getInvoiceByImei(int imei) {
        return null;
    }

    @Override
    public List<InvoiceModel> getAllInvoices() {
        return List.of();
    }
}
