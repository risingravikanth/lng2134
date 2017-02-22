package com.lnganalysis.actions;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.entities.domain.UserAudit;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.service.UserAuditService;
import com.lnganalysis.service.impl.UserAuditServiceImpl;

public class UserAuditServlet extends HttpServlet {
	static final Logger logger=Logger.getLogger(UserAuditServlet.class);
	public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
           throws ServletException, java.io.IOException {
			String jsonUserAuditres=null;
			PrintWriter out=null;
		   try
		   {
			   logger.info("Class - UserAuditServlet - doPost");
			   out=response.getWriter();
			   HttpSession session=request.getSession();
			   User user=(User)session.getAttribute(ApplicationConstants.USER);
			   if(null==user || session.isNew())
			   {
				   jsonUserAuditres=ApplicationConstants.SESSION_EXPIRED;
			   }
			   else
			   {
				   UserAuditService userAuditService=new UserAuditServiceImpl();
				   String startDateString=request.getParameter("startDate");
				   String endDateString=request.getParameter("endDate");
				
				   Date startDate=new Date(startDateString);
				   Date endDate=new Date(endDateString);
				   
				   List<UserAudit> userAuditList=userAuditService.readAudit(startDate,endDate);
				   if(userAuditList.size()>0)
					   jsonUserAuditres=JsonResponse.createUserAuditResponse(userAuditList);
				   else
					   jsonUserAuditres=ApplicationConstants.NO_DATA;
			   }			   			
			   out.write(jsonUserAuditres);
		   }		 
		   catch(Exception e)
		   {
			   logger.error("Exception in UserAuditServlet:"+e);
			   out.write(ApplicationConstants.APP_EXCEPTION);
		   }		   		   		 				
		   
	 }
	 public void doGet(HttpServletRequest request, 
            HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}
