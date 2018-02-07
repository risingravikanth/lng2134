package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.SmallScaleLngSource;

public class SmallScaleLngSourceDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(SmallScaleLngSourceDaoImpl.class);

	@Override
	public void deleteSource(String sourceName) throws Exception {		

		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - SmallScaleLngSourceDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete SmallScaleLngSource where name =:sourceName");
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
			logger.error("Exception in SmallScaleLngSourceDaoImpl - Method deleteSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
	

	}

	@Override
	public List<Object> readSource() throws Exception {
		// TODO Auto-generated method stub
				Session session=sessionFactory.openSession();
				List smallScaleSourceList=null;
				try
				{
					logger.info("Class - SmallScaleLngSourceDaoImpl - readSource()");
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("from SmallScaleLngSource");
					smallScaleSourceList=query.list();
//					Criteria criteria=session.createCriteria(LngSource.class);
//					lngSourceList=criteria.list();			
					tx.commit();
				}
				catch(Exception e)
				{
					logger.error("Exception in SmallScaleLngSourceDaoImpl - Method readSource()"+e);
					throw e;
				}
				finally
				{
					session.close();
				}	
				
				return smallScaleSourceList;
	}

	@Override
	public void saveSource(String sourceName) throws Exception {
		// TODO Auto-generated method stub
				Session session=sessionFactory.openSession();		
				try
				{
					logger.info("Class - SmallScaleLngSourceDaoImpl - saveSource()");
					Transaction tx=session.beginTransaction();
					SmallScaleLngSource smallScaleLngSource=new SmallScaleLngSource();
					smallScaleLngSource.setName(sourceName);
					session.save(smallScaleLngSource);
					tx.commit();
				}
				catch(Exception e)
				{
					logger.error("Exception in SmallScaleLngSourceDaoImpl - Method saveSource()"+e);
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
					logger.info("Class - SmallScaleLngSourceDaoImpl - findSource()");
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("from SmallScaleLngSource where name=:sourceName");
					query.setParameter("sourceName", sourceName);
					result=query.list();
					tx.commit();
				}
				catch(Exception e)
				{
					logger.error("Exception in SmallScaleLngSourceDaoImpl - Method findSource()"+e);
					throw e;
				}
				finally
				{
					session.close();
				}	
				return result;
	}

}
