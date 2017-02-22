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
import com.lnganalysis.entities.source.Region;
import com.lnganalysis.entities.source.SingleSource;

public class RegionDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(RegionDaoImpl.class);
	
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - RegionDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Region where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(Region.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			Region region=(Region)criteria.uniqueResult();				
//			session.delete(region);
				
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RegionDaoImpl - Method deleteSource:"+e);
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
		List regionList=null;
		try
		{
			logger.info("Class - RegionDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Region");
			regionList=query.list();
//			Criteria criteria=session.createCriteria(Region.class);
//			regionList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RegionDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return regionList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - RegionDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			Region region=new Region();
			region.setName(sourceName);
			session.save(region);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RegionDaoImpl - Method saveSource():"+e);
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
			logger.info("Class - RegionDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Region where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RegionDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
