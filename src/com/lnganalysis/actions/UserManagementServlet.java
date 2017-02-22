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
import com.lnganalysis.service.UserManagementService;
import com.lnganalysis.service.impl.UserManagementServiceImpl;

public class UserManagementServlet extends HttpServlet {
	static final Logger logger=Logger.getLogger(UserManagementServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 PrintWriter out =null;
		 String responseString=null;
		 try
		 {			
			logger.info("Class - UserManagermentServlet - doPost");
			out = response.getWriter();											
			String action=request.getParameter("action");
			UserManagementService userManagementService=new UserManagementServiceImpl();
			String userData=request.getParameter("userData");
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute(ApplicationConstants.USER);
			if(session.isNew() || null==user)
			{
				responseString=ApplicationConstants.SESSION_EXPIRED;
			}
			else
			{
				if(null!=action && !("").equalsIgnoreCase(action))
				{
					
					if(("update").equalsIgnoreCase(action))
					{					
						responseString=userManagementService.updateUser(userData);
					}
					else if(("save").equalsIgnoreCase(action)){
						responseString=userManagementService.saveUser(userData);
					}
					else if(("delete").equalsIgnoreCase(action))
					{
						responseString=userManagementService.deleteUser(userData);
					}
					
				}
				else
				{
					String filterValue=request.getParameter("filter");
					
					if(null!=filterValue && ("all").equalsIgnoreCase(filterValue))
					{
						List<User> usersList=userManagementService.getUsers();
						if(usersList.size()>0)
							responseString=JsonResponse.createUsersListResponse(usersList);
						else
							responseString=ApplicationConstants.NO_DATA;
					}
					else if(null!=filterValue && ("admin").equalsIgnoreCase(filterValue))
					{
						
						List<User> usersList=userManagementService.getAdminUsers();
						if(usersList.size()>0)
							responseString=JsonResponse.createUsersListResponse(usersList);
						else
							responseString=ApplicationConstants.NO_DATA;
					}
					else if(null!=filterValue && ("Non-Admin").equalsIgnoreCase(filterValue))
					{
						
						List<User> usersList=userManagementService.getNonAdminUsers();
						if(usersList.size()>0)
							responseString=JsonResponse.createUsersListResponse(usersList);
						else
							responseString=ApplicationConstants.NO_DATA;
					}
				}	
			}
					
			out.write(responseString);
		 }
		 catch(Exception e)
		 {
			 logger.error("Exception in UserManagementServlet:"+e);
			 out.write(ApplicationConstants.APP_EXCEPTION);
		 }
		 
	
	}
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}
