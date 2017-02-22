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
import com.lnganalysis.entities.source.PipeLineSource;
import com.lnganalysis.entities.source.RefinerySource;

public class RefinerySourceDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(RefinerySourceDaoImpl.class);

	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - RefinerySourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete RefinerySource where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(RefinerySource.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			RefinerySource refinerySource=(RefinerySource)criteria.uniqueResult();
//			session.delete(refinerySource);					
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefinerySourceDaoImpl - Method deleteSource():"+e);
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
		List refinerySourceList=null;
		try
		{
			logger.info("Class - RefinerySourceDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from RefinerySource");
			refinerySourceList=query.list();
//			Criteria criteria=session.createCriteria(RefinerySource.class);
//			refinerySourceList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefinerySourceDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return refinerySourceList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - RefinerySourceDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			RefinerySource refinerySource=new RefinerySource();
			refinerySource.setName(sourceName);
			session.save(refinerySource);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefinerySourceDaoImpl  - Method saveSource():"+e);
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
			logger.info("Class - RefinerySourceDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from RefinerySource where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefinerySourceDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
