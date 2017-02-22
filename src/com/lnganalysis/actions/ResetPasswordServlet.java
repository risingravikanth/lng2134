package com.lnganalysis.actions;

import java.io.PrintWriter;

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
import com.lnganalysis.service.MailService;
import com.lnganalysis.service.UserManagementService;
import com.lnganalysis.service.impl.MailServiceImpl;
import com.lnganalysis.service.impl.UserManagementServiceImpl;

public class ResetPasswordServlet extends HttpServlet{
	static final Logger logger=Logger.getLogger(ResetPasswordServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 PrintWriter out =null;		 
		 String email=null;
		 String resetpwd=null;
		 
		 RequestDispatcher rd=null;
		 try
		 {
			 logger.info("Class - ResetPasswordServlet - doPost");
			 HttpSession session=request.getSession();
			 User user=(User)session.getAttribute(ApplicationConstants.USER);
			 if(session.isNew() || null==user)
			 {
				 request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.SESSION_EXPIRED);
				 rd=request.getRequestDispatcher(JspPageConstants.LOGIN_JSP);
			 }
			 else
			 {
				 email=request.getParameter("email");
				 resetpwd=request.getParameter("resetpassword");
				 UserManagementService userService=new UserManagementServiceImpl();
				 rd=request.getRequestDispatcher(JspPageConstants.RESET_PWD_JSP);
				 if(null!=email && resetpwd!=null && !("").equalsIgnoreCase(email) && !("").equalsIgnoreCase(resetpwd))
				 {

					String pwdresetRes=userService.resetPassword(email, resetpwd);
					if(null!=pwdresetRes && (ApplicationConstants.SUCCESS).equalsIgnoreCase(pwdresetRes))
						request.setAttribute(ApplicationConstants.RESET_PWD_RES,ApplicationConstants.SUCCESS);
					else
						request.setAttribute(ApplicationConstants.RESET_PWD_RES,ApplicationConstants.FAIL);
					 MailService mailService=new MailServiceImpl();
					 mailService.sendMailToUser(email, resetpwd); //This is required for sending mail to user
					 				 				
				 }
				 else if(null== email || ("").equalsIgnoreCase(email))			 
					 request.setAttribute(ApplicationConstants.RESET_PWD_RES,ApplicationConstants.EMAIL_REQUIRED);				 				 			
				 else if(null==resetpwd || ("").equals(resetpwd))			 
					 request.setAttribute(ApplicationConstants.RESET_PWD_RES,ApplicationConstants.PWD_REQUIRED);			
			 }
			 
			 
			 rd.forward(request,response);
		}		
		catch (Exception e) {
			logger.error("Exception in ResetPasswordServlet:"+e);
			request.setAttribute(ApplicationConstants.RESET_PWD_RES,ApplicationConstants.APP_EXCEPTION);
			
		}
		 rd.forward(request,response);
	}
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }


}
