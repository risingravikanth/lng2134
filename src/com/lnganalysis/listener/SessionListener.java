package com.lnganalysis.listener;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.UserAuditService;
import com.lnganalysis.service.impl.UserAuditServiceImpl;

public class SessionListener implements HttpSessionListener{
	static final Logger logger=Logger.getLogger(SessionListener.class);
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session=arg0.getSession();
		User user=(User)session.getAttribute(ApplicationConstants.USER);
		UserAuditService userAuditService=new UserAuditServiceImpl();
		if(null!=user){
			userAuditService.saveAudit(user.getEmail(), new Date(),"logout due to session expired", "Y","logout");
			logger.info("Class - SessionListener - SessionDestroyed"+user.getEmail());
		}
		
//		session.invalidate();
	}

}
