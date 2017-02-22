package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.SingleSource;
import com.lnganalysis.entities.source.Status;

public class StatusDaoImpl implements SourceDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger =Logger.getLogger(StatusDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List statusList=null;
		try
		{
			logger.info("Class - StatusDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Status where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(Status.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			Status status=(Status)criteria.uniqueResult();
//			session.delete(status);
			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StatusDaoImpl - Method deleteSource():"+e); 
			throw e;
			
		}
		finally
		{
			session.close();
		}	
		
		
	}

	@Override
	public List<Object> readSource()throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List statusList=null;
		try
		{
			logger.info("Class - StatusDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Status");
			statusList=query.list();
//			Criteria criteria=session.createCriteria(Status.class);
//			statusList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StatusDaoImpl - Method readSource():"+e); 
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return statusList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		try
		{
			logger.info("Class - StatusDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			Status status=new Status();
			status.setName(sourceName);
			session.save(status);		
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StatusDaoImpl - Method saveSource():"+e); 
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		
	}

	@Override
	public List findSource(String sourceName) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();	
		List result=null;
		try
		{
			logger.info("Class - StatusDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Status where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StatusDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
