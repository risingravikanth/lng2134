package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.Countries;

public class CountriesDaoImpl implements SourceDao {

	private static SessionFactory sessionFactory=DbConfiguration.getSessionFactory();	
	static final Logger logger=Logger.getLogger(CountriesDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
//		List countriesList=null;
		try
		{
			logger.info("Class - CountriesDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Countries where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(Countries.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			Countries country=(Countries)criteria.uniqueResult();				
//			session.delete(country);
						
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CountriesDaoImpl - Method deleteSource():"+e);
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
		Transaction tx=session.beginTransaction();
		List countriesList=null;
		try
		{
			logger.info("Class - CountriesDaoImpl - readSource()");
			Query query=session.createQuery("from Countries");
			countriesList=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CountriesDaoImpl - Method readSource()"+e);
			throw e;
		}
		finally
		{
			
			session.close();
			
		}
		return countriesList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - CountriesDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			Countries country=new Countries();
			country.setName(sourceName);
			session.save(country);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CountriesDaoImpl - Method saveSource()"+e);
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
			logger.info("Class - CountriesDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Countries where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CountriesDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}


}
