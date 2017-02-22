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
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.service.HistoryService;
import com.lnganalysis.service.impl.HistoryServiceImpl;

public class HistoryServlet extends HttpServlet {
	 static final Logger logger=Logger.getLogger(HistoryServlet.class);
	 public void doPost(HttpServletRequest request, 
             HttpServletResponse response)
			throws ServletException, java.io.IOException {		 
		 PrintWriter out =null;
		 String historyRes=null;
		 try
		 {	
			 logger.info("Class - HistoryServlet - doPost()");
			 out = response.getWriter();		
			 HttpSession session=request.getSession();
			 User user=(User)session.getAttribute(ApplicationConstants.USER);
			 String startDateString=request.getParameter("startDate");
			 String endDateString=request.getParameter("endDate");
		
			 Date startDate=new Date(startDateString);
			 Date endDate=new Date(endDateString);
			 
			 if(session.isNew() || null==user)
			 {
				 historyRes=ApplicationConstants.SESSION_EXPIRED;
			 }
			 else
			 {
				 HistoryService historyService=new HistoryServiceImpl();
					
				 if(null!=user && ("Y").equalsIgnoreCase(user.getAdmin()))
				 {
					 List<History> historyList=historyService.readHistoryForDateRange(startDate, endDate);
					 logger.info("Class - HistoryServlet - historyList:"+historyList);
					 if(historyList.size()>0)
						 historyRes=JsonResponse.createHistoryResponse(historyList);
					 else
						 historyRes=ApplicationConstants.NO_DATA;
				 }
				 else
				 {
					 List<History> loginUserHistoryList=historyService.readUserHistoryForDateRange(user,startDate,endDate);
					 logger.info("Class - HistoryServlet - loginUserHistoryList:"+loginUserHistoryList);
					 if(loginUserHistoryList.size()>0)
						 historyRes=JsonResponse.createHistoryResponse(loginUserHistoryList);
					 else
						 historyRes=ApplicationConstants.NO_DATA;							
				 }
			 }
		
			 out.write(historyRes);
		}
		catch (Exception e) {
			logger.error("Exception in HistoryServlet:"+e);
			out.write(ApplicationConstants.APP_EXCEPTION);
		}
		 
	}
	 public void doGet(HttpServletRequest request, 
             HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}
