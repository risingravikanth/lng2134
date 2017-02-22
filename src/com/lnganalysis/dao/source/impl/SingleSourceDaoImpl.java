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
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.entities.source.Region;
import com.lnganalysis.entities.source.SingleSource;

public class SingleSourceDaoImpl implements SourceDao
{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();	
	static final Logger logger=Logger.getLogger(SingleSourceDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - SingleSourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete SingleSource where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(SingleSource.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			SingleSource singleSource=(SingleSource)criteria.uniqueResult();				
//			session.delete(singleSource);
				
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SingleSourceDaoImpl - Method deleteSource:"+e);
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
		List sourceList=null;
		try
		{
			logger.info("Class - SingleSourceDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from SingleSource");
			sourceList=query.list();
//			Criteria criteria=session.createCriteria(SingleSource.class);
//			sourceList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SingleSourceDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return sourceList;
	}

	@Override
	public void  saveSource(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - SingleSourceDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			SingleSource singleSource=new SingleSource();
			singleSource.setName(name);
			session.save(singleSource);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SingleSourceDaoImpl - Method saveSource():"+e);
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
			logger.info("Class - SingleSourceDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from SingleSource where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SingleSourceDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}
		

}
