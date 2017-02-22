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
import com.lnganalysis.entities.source.LngSource;
import com.lnganalysis.entities.source.PipeLineSource;

public class PipeLineSourceDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(PipeLineSourceDaoImpl.class);

	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - PipeLineSourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete PipeLineSource where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(PipeLineSource.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			PipeLineSource pipeLineSource=(PipeLineSource)criteria.uniqueResult();
//			session.delete(pipeLineSource);					
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in PipeLineSourceDaoImpl - Method deleteSource():"+e);
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
		List pipeLineSourceList=null;
		try
		{
			logger.info("Class - PipeLineSourceDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from PipeLineSource");
			pipeLineSourceList=query.list();
//			Criteria criteria=session.createCriteria(PipeLineSource.class);
//			pipeLineSourceList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in PipeLineSourceDaoImpl - Method readSource"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return pipeLineSourceList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - PipeLineSourceDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			PipeLineSource pipeLineSource=new PipeLineSource();
			pipeLineSource.setName(sourceName);
			session.save(pipeLineSource);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in PipeLineSourceDaoImpl  - Method saveSource()"+e);
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
			logger.info("Class - PipeLineSourceDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from PipeLineSource where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in PipeLineSourceDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
