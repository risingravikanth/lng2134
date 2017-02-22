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
import com.lnganalysis.entities.source.StorageSource;

public class StorageSourceDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(StorageSourceDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - StorageSourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete StorageSource where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(StorageSource.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			StorageSource storageSource=(StorageSource)criteria.uniqueResult();
//			session.delete(storageSource);		
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageSourceDaoImpl - Method deleteSource():"+e);
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
		List storageSourceList=null;
		try
		{
			logger.info("Class - StorageSourceDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from StorageSource");
			storageSourceList=query.list();
//			Criteria criteria=session.createCriteria(StorageSource.class);
//			storageSourceList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageSourceDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return storageSourceList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - StorageSourceDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();			
			StorageSource storageSource=new StorageSource();
			storageSource.setName(sourceName);			
			session.save(storageSource);		
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageSourceDaoImpl - Method saveSource():"+e);
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
			logger.info("Class - StorageSourceDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from StorageSource where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageSourceDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
