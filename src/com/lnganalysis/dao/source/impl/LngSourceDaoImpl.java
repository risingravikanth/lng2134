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
import com.lnganalysis.entities.source.ImportCountries;
import com.lnganalysis.entities.source.LngSource;
import com.lnganalysis.entities.source.StorageSource;

public class LngSourceDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(LngSourceDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - LngSourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete LngSource where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Transaction tx=session.beginTransaction();
//			Criteria criteria=session.createCriteria(LngSource.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			LngSource lngSource=(LngSource)criteria.uniqueResult();
//
//				session.delete(lngSource);
			
			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngSourceDaoImpl - Method deleteSource():"+e);
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
		List lngSourceList=null;
		try
		{
			logger.info("Class - LngSourceDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from LngSource");
			lngSourceList=query.list();
//			Criteria criteria=session.createCriteria(LngSource.class);
//			lngSourceList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngSourceDaoImpl - Method readSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return lngSourceList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - LngSourceDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			LngSource lngSource=new LngSource();
			lngSource.setName(sourceName);
			session.save(lngSource);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngSourceDaoImpl - Method saveSource()"+e);
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
			logger.info("Class - LngSourceDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from LngSource where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngSourceDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}
	

}
