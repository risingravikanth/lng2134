package com.lnganalysis.actions;

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
import com.lnganalysis.service.UserManagementService;
import com.lnganalysis.service.impl.UserManagementServiceImpl;

public class ChangePasswordServlet  extends HttpServlet{
	static final Logger logger=Logger.getLogger(ChangePasswordServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
			throws ServletException, java.io.IOException {				
		RequestDispatcher rq = null;
		try {
			logger.info("Class- ChangePaswordServlet - doPost()");
			UserManagementService userService=new UserManagementServiceImpl();
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			String reEnterPassword = request.getParameter("reenterNewPassword");
			HttpSession session = request.getSession();			
			User user = (User) session.getAttribute(ApplicationConstants.USER);
			if(null==user || session.isNew())
			{
				request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.SESSION_EXPIRED);
				rq=request.getRequestDispatcher(JspPageConstants.LOGIN_JSP);
			}
			else
			{
				rq = request.getRequestDispatcher(JspPageConstants.CHNG_PWD_JSP);
				if(null==currentPassword || ("").equalsIgnoreCase(currentPassword))			
					request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.CURR_PWD_REQUIRED);											
				else if(null==newPassword || ("").equalsIgnoreCase(newPassword))			
					request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.NEW_PWD_REQUIRED);							
				else if(null==reEnterPassword || ("").equalsIgnoreCase(reEnterPassword))			
					request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.REENTER_PWD_REQUIRED);						
				else
				{
					if (null!=currentPassword && null!=user.getPassword() && !user.getPassword().equals(currentPassword)) 
						request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.CURR_PWD_NOT_MATCH);				
					else if(null!=newPassword && null!=reEnterPassword && !newPassword.equals(reEnterPassword))
						request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.PWDS_NOT_MATCH);					
					else 
					{
						if (null!=newPassword && null!=reEnterPassword && newPassword.equals(reEnterPassword)) {				
							user.setPassword(reEnterPassword);
							if(user.getPasswordReset().equalsIgnoreCase(ApplicationConstants.NO))
							 user.setPasswordReset(ApplicationConstants.YES);
							String responseString=userService.updateUser(user);
							if(null!=responseString && (ApplicationConstants.SUCCESS).equalsIgnoreCase(responseString))	
							{	
								rq = request.getRequestDispatcher(JspPageConstants.LOGIN_JSP);							
							}	
							else						
								request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE, ApplicationConstants.FAIL);																		
						}
											
					}
				}
			}
			
			
			
		} 	
		catch (Exception e) {
			logger.error("Exception in ChangePasswordServlet - doPost():"+e);
			request.setAttribute(ApplicationConstants.CHNG_PWD_RESPONSE,ApplicationConstants.APP_EXCEPTION);								
		}
		rq.forward(request, response);
	}
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}	
