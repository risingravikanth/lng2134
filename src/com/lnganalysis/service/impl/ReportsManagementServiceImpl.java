package com.lnganalysis.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.constants.UserConstants;
import com.lnganalysis.dao.domain.UserDao;
import com.lnganalysis.dao.domain.impl.UserDaoImpl;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.dao.source.impl.ReportsDaoImpl;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.entities.source.Report;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.service.ReportsManagementService;

public class ReportsManagementServiceImpl implements ReportsManagementService {
	static final Logger logger=Logger.getLogger(ReportsManagementServiceImpl.class);
	@Override
	public String getReports(String sector) {
		// TODO Auto-generated method stub
		ReportsDaoImpl reportsDao=null;
		List<Report> reportList=null;
		String res="";
		JsonResponse jsonRes=new JsonResponse();
		try
		{
			reportsDao=new ReportsDaoImpl();
			reportList=reportsDao.readSource(sector);
			if(reportList.size()>0)
				res=jsonRes.createReportsListResponse(reportList);
			else
				res=ApplicationConstants.NO_DATA;
		}
		catch(Exception e)
		{		
			logger.error("Exception in ReportsManagementServiceImpl - Method getReports():"+e);
		}		
		return res;
	}

	@Override
	public String saveReports(String reportData) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			
			ReportsDaoImpl reportsDao=new ReportsDaoImpl();
			JSONObject jsonReportObject=getJsonObject(reportData);
			
			String title=(String)jsonReportObject.get("reportTitle");
			List reportList=reportsDao.findSource(title);
			if(null!=reportList && reportList.size()>0)
				response=ApplicationConstants.RECORD_ALREADY_EXISTS;
			else
			{
				String sector=(String)jsonReportObject.get("sector");
				String region=(String)jsonReportObject.get("region");
				String country=(String)jsonReportObject.get("country");
				Report report=new Report();
				report.setReportTitle(title);
				report.setSector(sector);
				report.setRegion(region);
				report.setCountry(country);
				reportsDao.saveSource(report);
				response=ApplicationConstants.SUCCESS;
			}
			
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportsManagementServiceImpl - Method saveReports():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
	}
	public JSONObject getJsonObject(String reportData)throws Exception{
		JSONParser parser=new JSONParser();
		JSONObject jsonUserObject=(JSONObject)parser.parse(reportData);
		return jsonUserObject;
	}
	@Override
	public String deleteReport(String reportTitle) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			SourceDao sourceDao=new ReportsDaoImpl();
			sourceDao.deleteSource(reportTitle);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in DataManagementServiceImpl - Method deleteSourceData():"+e);
			response=ApplicationConstants.FAIL;
		}
		
		return response;
	}

}
