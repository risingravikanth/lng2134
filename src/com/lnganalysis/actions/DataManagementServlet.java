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
import com.lnganalysis.service.DataManagementService;
import com.lnganalysis.service.impl.DataManagementServiceImpl;

public class DataManagementServlet extends HttpServlet{
	 static final Logger logger=Logger.getLogger(DataManagementServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 PrintWriter out =null;
		 String sourceResponse="";
		 try
		 {		
			logger.info("Class - DataManagementServlet - doPost()"); 
			out = response.getWriter();														
			String action=request.getParameter("action");
			DataManagementService dataManagementService=new DataManagementServiceImpl();
			String sourceName=request.getParameter("sourceName");
			String sourceType=request.getParameter("sourceType");
			HttpSession session=request.getSession();			
			User user=(User)session.getAttribute(ApplicationConstants.USER);
			if(session.isNew() || null==user)
			{
				sourceResponse=ApplicationConstants.SESSION_EXPIRED;
			}
			else
			{
				if(null!=action && ("delete").equalsIgnoreCase(action))
				{								
					sourceResponse=dataManagementService.deleteSourceData(sourceType, sourceName);
					
				}
				else if(null!=action && ("save").equalsIgnoreCase(action))
				{			
					sourceResponse=dataManagementService.saveSourceData(sourceType, sourceName);				
				}
				else
				{
					sourceType=request.getParameter("sourceList");
					List<Object> sourceList=dataManagementService.readSourceData(sourceType);
					if(sourceList.size()>0)
					 sourceResponse=JsonResponse.createSourceListResponse(sourceList);
					else
					 sourceResponse=ApplicationConstants.NO_DATA;	
				}
				
			}
			
			out.write(sourceResponse);
		 }
		 catch(Exception e)
		 {
			 logger.error("Exception in DataManagementServlet :"+e);
			 out.write(ApplicationConstants.APP_EXCEPTION);
		 }
		 
	
	}
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }

}
