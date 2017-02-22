package com.lnganalysis.dao.domain.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.HistoryDao;
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;

public class HistoryDaoImpl implements HistoryDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(HistoryDaoImpl.class);

	@Override
	public void saveHistory(History history)throws Exception {
		// TODO Auto-generated method stub
		 
		Session session=null;	 
		try
		{
			logger.info("Class - HistoryDaoImpl - saveHistory()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();	
			session.save(history);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryDaoImpl - Method saveHistory():"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
	}

	@Override
	public List<History> readUserHistoryForDateRange(User user,Date startDate,Date endDate)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;		
		List<History> historyList=null;
		try
		{
			logger.info("Class - HistoryDaoImpl - readUserHistoryForDateRange()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria criteria=session.createCriteria(History.class);
			criteria.add(Restrictions.eq("user",user));
			criteria.add(Restrictions.ge("createdDate", startDate));
			criteria.add(Restrictions.lt("createdDate",endDate));
			historyList=new ArrayList<History>();			
			historyList=criteria.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryDaoImpl - Method readUserHistoryForDateRange() :"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
		return historyList;

	}

	@Override
	public List<History> readHistoryForDateRange(Date startDate, Date endDate)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;		 	
		List<History> historyList=null;
		try
		{
			logger.info("Class - HistoryDaoImpl - readHistoryForDateRange()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria criteria=session.createCriteria(History.class);
			criteria.add(Restrictions.ge("createdDate", startDate));
			criteria.add(Restrictions.lt("createdDate",endDate));
			historyList=new ArrayList<History>();			
			historyList=criteria.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryDaoImpl - Method readHistoryForDateRange():"+e);
			throw e;
		}
		finally
		{
			
			session.close();
			
		}
		return historyList;
		
	}

	@Override
	public void deleteHistory(History history)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;		 
		try
		{
			logger.info("Class - HistoryDaoImpl - deleteHistory()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.delete(history);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryDaoImpl - Method deleteHistory():"+e);
			throw e;
		}
		finally
		{			
			session.close();
		}
	}
	
	@Override
	public List<History> readUserHistory(User user)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;		
		List<History> historyList=null;
		try
		{
			logger.info("Class - HistoryDaoImpl - readUserHistory()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria criteria=session.createCriteria(History.class); 
			criteria.add(Restrictions.eq("user",user));					
			historyList=criteria.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryDaoImpl - Method readUserHistory:"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
		return historyList;
	}
	

}
