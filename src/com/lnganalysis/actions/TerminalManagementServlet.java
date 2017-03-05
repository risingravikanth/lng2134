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
import com.lnganalysis.service.TerminalManagementService;
import com.lnganalysis.service.impl.DataManagementServiceImpl;
import com.lnganalysis.service.impl.TerminalManagementServiceImpl;

public class TerminalManagementServlet extends HttpServlet{
	static final Logger logger=Logger.getLogger(TerminalManagementServlet.class);
	 public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 PrintWriter out =null;
		 String sourceResponse="";
		 try
		 {		
			logger.info("Class - TerminalManagementServlet - doPost()"); 
			out = response.getWriter();														
			String action=request.getParameter("action");
			TerminalManagementService terminalManagementService=new TerminalManagementServiceImpl();
			String domainName=request.getParameter("domainName");
			String domainType=request.getParameter("domainType");
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
					sourceResponse=terminalManagementService.deleteData(domainType, domainName);
					
				}
				else
				{
					domainType=request.getParameter("sourceList");
					List<String> terminalsList=terminalManagementService.readData(domainType);
					if(terminalsList.size()>0)
						sourceResponse=JsonResponse.createTerminalsResponse(terminalsList);
					else
						sourceResponse=ApplicationConstants.NO_DATA;	
				}
				
			}
			
			out.write(sourceResponse);
		 }
		 catch(Exception e)
		 {
			 logger.error("Exception in TerminalManagementServlet :"+e);
			 out.write(ApplicationConstants.APP_EXCEPTION);
		 }
		 
	
	}
	 public void doGet(HttpServletRequest request, 
            HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }


}
