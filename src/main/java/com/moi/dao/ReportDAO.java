package com.moi.dao;

import com.moi.model.ReportModel;

import java.util.Date;
import java.util.List;

public interface ReportDAO {
    void insertReport(ReportModel model);
    List<ReportModel> getAllReports();
    ReportModel getReportByFecha(Date fecha);
    void updateReport(Date fecha, ReportModel model);
    void deleteAccount(Date fecha);
}
