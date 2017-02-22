package com.lnganalysis.dao.domain.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.UserAuditDao;
import com.lnganalysis.entities.domain.UserAudit;

public class UserAuditDaoImpl implements UserAuditDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(UserAuditDaoImpl.class);
	@Override
	public void saveUserAudit(UserAudit userAudit)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;		 
		try
		{
			logger.info("Class - UserAuditDaoImpl - saveUserAudit()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(userAudit);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserAuditDaoImpl - Method saveUserAudit():"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
	}

	@Override
	public List<UserAudit> readUserAudit(Date startDate,Date endDate)throws Exception {
		// TODO Auto-generated method stub
		List<UserAudit> userAudit=null;		
		Session session=null;
		try
		{
			logger.info("Class - UserAuditDaoImpl - readUserAudit()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria criteria=session.createCriteria(UserAudit.class);	
			criteria.add(Restrictions.ge("createdDate", startDate));
			criteria.add(Restrictions.lt("createdDate",endDate));
			userAudit=criteria.list();		
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserAuditDaoImpl - Method readUserAudit():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
		return userAudit;
	}
	
}
