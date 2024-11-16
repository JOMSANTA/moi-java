package com.moi.dao;

import com.moi.model.ReportModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDAOImpl implements ReportDAO{

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
    public void insertReport(ReportModel model) {

    }

    @Override
    public List<ReportModel> getAllReports() {
        List<ReportModel> reports = new ArrayList<>();
        String selectQuery = "SELECT * FROM reportes;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ReportModel reportModel= new ReportModel();
                reportModel.setFecha(resultSet.getDate("fecha"));
                reportModel.setCodEmpleado(resultSet.getInt("codEmpleado"));
                reportModel.setDescripcion(resultSet.getString("descripcion"));
                reportModel.setPostpago(resultSet.getInt("postpago"));
                reportModel.setPrepago(resultSet.getInt("prepago"));
                reportModel.setTv(resultSet.getInt("tv"));
                reportModel.setOtros(resultSet.getInt("otros"));

                reports.add(reportModel);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return reports;
    }

    @Override
    public ReportModel getReportByFecha(Date fecha) {
        return null;
    }

    @Override
    public void updateReport(Date fecha, ReportModel model) {

    }

    @Override
    public void deleteAccount(Date fecha) {

    }
}
