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
import com.lnganalysis.service.FileUploadService;
import com.lnganalysis.service.UserAuditService;
import com.lnganalysis.service.UserManagementService;
import com.lnganalysis.service.impl.FileUploadServiceImpl;
import com.lnganalysis.service.impl.UserAuditServiceImpl;
import com.lnganalysis.service.impl.UserManagementServiceImpl;

public class LoginServlet  extends HttpServlet{
	 static Logger logger=Logger.getLogger(LoginServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
            throws ServletException, java.io.IOException {	
		 
		 logger.info("Class - LoginServlet - doPost():");
		 RequestDispatcher rq=null;
		 try
		 {
			 String email=request.getParameter("email");
			 String password=request.getParameter("password");
			 rq=request.getRequestDispatcher(JspPageConstants.LOGIN_JSP);
			 request.setAttribute("enteredEmail", email);
			 if(null==email || ("").equalsIgnoreCase(email))			 
				 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.EMAIL_REQUIRED);			 
			 else if(null==password || ("").equalsIgnoreCase(password))			 
				 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.PWD_REQUIRED);					 
			 else
			 {
				 UserManagementService userService=new UserManagementServiceImpl();
				 User user=userService.getUser(email);			
				 UserAuditService userAuditService=new UserAuditServiceImpl();
				 if(null!=user)
				 {
					
					 if(null!=user.getPassword() && password.equals(user.getPassword()))
					 {
						 HttpSession session=request.getSession();
						 session.setAttribute(ApplicationConstants.USER,user);
						 FileUploadService fus=new FileUploadServiceImpl();
						 session.setAttribute(ApplicationConstants.EXPLORATION_COUNT,fus.getExplorationCount());
						 session.setAttribute(ApplicationConstants.REFINERY_COUNT, fus.getRefineriesCount());
						 session.setAttribute(ApplicationConstants.CRUDEOIL_COUNT,fus.getCrudeOilCount());
						 session.setAttribute(ApplicationConstants.NATURALGAS_COUNT,fus.getNaturalGasCount());
						 session.setAttribute(ApplicationConstants.LNG_COUNT ,fus.getLngCount());
						 session.setAttribute(ApplicationConstants.STORAGE_COUNT,fus.getStorageCount());
						 session.setAttribute(ApplicationConstants.PIPELINE_COUNT,fus.getPipeLineCount());
						 if("N".equalsIgnoreCase(user.getPasswordReset()))
						 {
							 rq=request.getRequestDispatcher(JspPageConstants.CHNG_PWD_JSP);							 
						 }
						 else
						 {
							 													
							 userAuditService.saveAudit(email,new Date(),"login successfully", "Y","login");
							 rq=request.getRequestDispatcher(JspPageConstants.HOME_JSP);	
						 }
							 								 
					 }
					 else					 						 
						 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.LOGIN_FAIL);											 										 
				 }
				 else				 					 
					 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.USER_NOT_EXISTS);
					 				 
			 }
			
		 }		
		 catch(Exception e)
		 {
			 logger.error("Exception in LoginServlet:"+e);
			 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.APP_EXCEPTION);			 		 
		 }
		 rq.forward(request,response);	
	 }
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}	
