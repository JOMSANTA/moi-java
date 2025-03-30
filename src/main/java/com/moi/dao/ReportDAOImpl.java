package com.moi.dao;

import com.moi.model.ReportModel;

import java.sql.*;
import java.time.LocalDate;
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
        String query = "INSERT INTO moi.report (date,sucursal,postpago,kitContado,kitCuotas,tv,otros,quantity) VALUES (?,?,?,?,?,?,?,?);";
        //   String query = "INSERT INTO moi.report (idReport, date, sucursal, postpago, kit, kitCuotas, tv, otros, quantity) VALUES (?,?,?,?,?,?,?,?,?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(query)){

            preparedStatement.setString(1,model.getDate());
            preparedStatement.setString(2,model.getSucursal());
            preparedStatement.setInt(3,model.getPostpago());
            preparedStatement.setInt(4,model.getKitContado());
            preparedStatement.setInt(5,model.getKitCuotas());
            preparedStatement.setInt(6,model.getTv());
            preparedStatement.setString(7,model.getOtros());
            preparedStatement.setInt(8,model.getQuantity());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.err.println("error insertando reporte : " + e.getMessage());
        }


    }





    @Override
    public List<ReportModel> getAllReports() {
        List<ReportModel> reports = new ArrayList<>();
        String selectQuery = "SELECT * FROM report;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ReportModel reportModel= new ReportModel();
                reportModel.setDate(resultSet.getString("date"));
                reportModel.setSucursal(resultSet.getString("sucursal"));
                reportModel.setPostpago(resultSet.getInt("postpago"));
                reportModel.setKitContado(resultSet.getInt("kitContado"));
                reportModel.setKitCuotas(resultSet.getInt("kitCuotas"));
                reportModel.setTv(resultSet.getInt("tv"));
                reportModel.setOtros(resultSet.getString("otros"));
                reportModel.setQuantity(resultSet.getInt("quantity"));

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
