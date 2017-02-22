package com.lnganalysis.actions;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.constants.JspPageConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.UserAuditService;
import com.lnganalysis.service.impl.UserAuditServiceImpl;

public class LogoutServlet extends HttpServlet {
	 static final Logger logger=Logger.getLogger(LogoutServlet.class);
	 public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
           throws ServletException, java.io.IOException {
		  RequestDispatcher rq=null;
		  
		  try
		  {
			  logger.info("Class - LogoutServlet - doPost");
			  UserAuditService userAuditService=new UserAuditServiceImpl();
			  HttpSession session=request.getSession();
			  User user=(User)session.getAttribute(ApplicationConstants.USER);
			  rq=request.getRequestDispatcher(JspPageConstants.LOGIN_JSP);
			  String email="";
			   if(null!=user)
			   {
				   email=user.getEmail();				   
				   session.removeAttribute(ApplicationConstants.USER);
				   userAuditService.saveAudit(email, new Date(),"logout successfully", "Y","logout");
				   				   
			   }
			   else if(null==user)
			   {
				   request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.SESSION_EXPIRED);
			   }
		  }		
		  catch(Exception e)
		  {
			  logger.error("Exception in LogoutServlet:"+e);			  			  
		  }
		  rq.forward(request,response);			   		   		  	
	 }
	 public void doGet(HttpServletRequest request, 
            HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }

}
