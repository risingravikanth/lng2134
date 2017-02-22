package com.lnganalysis.actions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.JspPageConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.UserManagementService;
import com.lnganalysis.service.impl.UserManagementServiceImpl;

public class ViewPageServlet extends HttpServlet{
	static final Logger logger=Logger.getLogger(ViewPageServlet.class);
	 public void doPost(HttpServletRequest request, 
           HttpServletResponse response)
          throws ServletException, java.io.IOException {
		  RequestDispatcher rq=null;
		  try
		  {			 
			 logger.info("Class - ViewPageServlet - doPost");
			 String page=request.getParameter("page");
			 if(null!=page && ("home").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.HOME_JSP);
			 else if(null!=page && ("changepwd").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.CHNG_PWD_JSP);
			 else if(null!=page && ("history").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.HISTORY_JSP);
			 else if(null!=page && ("usermngmt").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.USER_MNGMT_JSP);
			 else if(null!=page && ("datamngmt").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.DATA_MNGMT_JSP);
			 else if(null!=page && ("resetpwd").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.RESET_PWD_JSP);
			 else if(null!=page && ("useraudit").equalsIgnoreCase(page))
				 rq=request.getRequestDispatcher(JspPageConstants.USER_AUDIT_JSP);
			 else if(null!=page && ("profile").equalsIgnoreCase(page))
			 {
				 HttpSession session=request.getSession();
				 User user=(User)session.getAttribute("user");
				 UserManagementService userService=new UserManagementServiceImpl();
				 if(user==null)
					 rq=request.getRequestDispatcher("logout");
				 User updateUser=userService.getUser(user.getEmail());	
				 session.setAttribute("user",updateUser);
				 rq=request.getRequestDispatcher(JspPageConstants.PROFILE_JSP);
			 }	 
			 			 
		  }		
		  catch(Exception e)
		  {
			  logger.error("Exception in LogoutActionServlet:"+e);			  			  
		  }
		  rq.forward(request,response);			   		   		  	
	 }
	 public void doGet(HttpServletRequest request, 
           HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }



}
