package com.lnganalysis.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.service.ReportsManagementService;
import com.lnganalysis.service.TerminalManagementService;
import com.lnganalysis.service.impl.ReportsManagementServiceImpl;
import com.lnganalysis.service.impl.TerminalManagementServiceImpl;

public class ReportsManagementServlet extends HttpServlet{
	static final Logger logger=Logger.getLogger(TerminalManagementServlet.class);
	 public void doPost(HttpServletRequest request, 
           HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 PrintWriter out =null;
		 String res="";
		 try
		 {		
			logger.info("Class - ReportManagementServlet - doPost()"); 
			out = response.getWriter();														
			String action=request.getParameter("action");
			ReportsManagementService reportsService=new ReportsManagementServiceImpl();									
			HttpSession session=request.getSession();			
			User user=(User)session.getAttribute(ApplicationConstants.USER);
			if(session.isNew() || null==user)
			{
				res=ApplicationConstants.SESSION_EXPIRED;
			}
			else
			{
				if(null!=action && ("delete").equalsIgnoreCase(action))
				{								
					String title=request.getParameter("reportTitle");
					res=reportsService.deleteReport(title);
					
				}
				else if(null!=action && ("save").equals(action))
				{
					String reportData=request.getParameter("reportData");
					res=reportsService.saveReports(reportData);
				}
				else
				{
					String sector=request.getParameter("sector");
					res=reportsService.getReports(sector);
				}
				
			}
			
			out.write(res);
		 }
		 catch(Exception e)
		 {
			 logger.error("Exception in ReportManagementServlet :"+e);
			 out.write(ApplicationConstants.APP_EXCEPTION);
		 }
		 
	
	}
	 public void doGet(HttpServletRequest request, 
           HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }

}
