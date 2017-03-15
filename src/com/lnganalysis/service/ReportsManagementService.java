package com.lnganalysis.service;

public interface ReportsManagementService {
	public String getReports(String sector);
	public String saveReports(String reportData);
	public String deleteReport(String reportName);
}
