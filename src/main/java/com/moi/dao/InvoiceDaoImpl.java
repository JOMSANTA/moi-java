package com.moi.dao;

import com.moi.model.EmployeeModel;
import com.moi.model.InvoiceModel;
import com.moi.model.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceDaoImpl implements InvoiceDao {

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

        String insertQuery = "INSERT INTO moi.invoice \n" +
                "(fecha, nombre,documento, codEmpleado, producto, codigoProducto, imei, cantidad, valorUnitario, subTotal, iva, total)\n" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        ResultSet rs = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, model.getFecha());
            preparedStatement.setString(2, model.getNombre());
            preparedStatement.setLong(3, model.getDocumento());
            preparedStatement.setInt(4, model.getCodEmpleado());
            preparedStatement.setString(5, model.getProducto());
            preparedStatement.setString(6, model.getCodigoProducto());
            preparedStatement.setLong(7, model.getImei());
            preparedStatement.setInt(8, model.getCantidad());
            preparedStatement.setFloat(9, model.getValorUnitario());
            preparedStatement.setFloat(10, model.getSubTotal());
            preparedStatement.setInt(11, model.getIva());
            preparedStatement.setFloat(12, model.getTotal());



            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("error al insertar factura" + e.getMessage());
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
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InvoiceModel invoiceModel = new InvoiceModel();
                invoiceModel.setFecha(resultSet.getString("fecha"));
                invoiceModel.setNombre(resultSet.getString("nombre"));
                invoiceModel.setDocumento(resultSet.getLong("documento"));
                invoiceModel.setCodEmpleado(resultSet.getInt("codEmpleado"));
                invoiceModel.setProducto(resultSet.getString("producto"));
                invoiceModel.setCodigoProducto(resultSet.getString("codigoProducto"));
                invoiceModel.setImei(resultSet.getLong("imei"));
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
}