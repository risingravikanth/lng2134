package com.lnganalysis.actions;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.service.MailService;
import com.lnganalysis.service.impl.MailServiceImpl;

public class MailSendServlet extends HttpServlet {
	static final Logger logger=Logger.getLogger(MailSendServlet.class);
	 public void doPost(HttpServletRequest request, 
           HttpServletResponse response)
          throws ServletException, java.io.IOException {
		 	PrintWriter out =null;
		 	String mailRes=null;
		 	try
		 	{
		 		out = response.getWriter();	
		 		String email=request.getParameter("emailId");	
		 		MailService mailSend=new MailServiceImpl();
		 		mailRes=mailSend.sendMailToAdmin(email);		 		
		 		out.write(mailRes);	
		 	}
		 	catch(Exception e)
		 	{
		 		logger.error("Exception in MailSendServlet:"+e);
		 		out.write(ApplicationConstants.APP_EXCEPTION);
		 	}
		 			 			 		 		
	 }
	 public void doGet(HttpServletRequest request, 
           HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}
