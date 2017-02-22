package com.lnganalysis.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.lnganalysis.dao.domain.UserAuditDao;
import com.lnganalysis.dao.domain.UserDao;
import com.lnganalysis.dao.domain.impl.UserAuditDaoImpl;
import com.lnganalysis.dao.domain.impl.UserDaoImpl;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.entities.domain.UserAudit;
import com.lnganalysis.service.UserAuditService;

public class UserAuditServiceImpl implements UserAuditService {
	static final Logger logger=Logger.getLogger(UserAuditServiceImpl.class);
	@Override
	public void saveAudit(String emailId, Date currentDate, String comments,String actionFlag,String action){
		// TODO Auto-generated method stub
		UserAuditDao userAuditDao=null;
		UserDao userDao=null;
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateString=dateFormat.format(currentDate);
			Date formatDate=new Date(dateString);
			userAuditDao=new UserAuditDaoImpl();
//			userDao=new UserDaoImpl();
//			User user=userDao.getUser(emailId);
			UserAudit userAudit=new UserAudit();
			userAudit.setComments(comments);
			userAudit.setCreatedDate(currentDate);
			userAudit.setComments(comments);
			userAudit.setActionFlag(actionFlag);
			userAudit.setCreatedBy(emailId);
			userAudit.setAction(action);
//			userAudit.setUser(user);
			userAuditDao.saveUserAudit(userAudit);
			
		}
		catch(Exception e)
		{
			logger.error("Exception in UserAuditServiceImpl - Method saveAudit():"+e);			
		}
	}

	@Override
	public List<UserAudit> readAudit(Date startDate,Date endDate) {
		// TODO Auto-generated method stub
		UserAuditDao userAuditDao=null;
		List<UserAudit> userAuditList=null;
		try
		{
			userAuditDao=new UserAuditDaoImpl();					
			userAuditList=userAuditDao.readUserAudit(startDate,endDate);
			
		}
		catch(Exception e)
		{
			logger.error("Exception in UserAuditServiceImpl - Method readAudit():"+e);		
		}
		return userAuditList;
	}

}
