package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.ImportCountries;

public class ImportCountriesDaoImpl implements SourceDao {
	private static SessionFactory sessionFactory=DbConfiguration.getSessionFactory();	
	static final Logger logger=Logger.getLogger(ImportCountriesDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
//		List countriesList=null;
		try
		{
			logger.info("Class - ImportCountriesDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete ImportCountries where name =:sourceName");
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
			logger.error("Exception in ImportCountriesDaoImpl - Method deleteSource():"+e);
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
			logger.info("Class - ImportCountriesDaoImpl - readSource()");
			Query query=session.createQuery("from ImportCountries");
			countriesList=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ImportCountriesDaoImpl - Method readSource()"+e);
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
			logger.info("Class - ImportCountriesDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			ImportCountries country=new ImportCountries();
			country.setName(sourceName);
			session.save(country);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ImportCountriesDaoImpl - Method saveSource()"+e);
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
			logger.info("Class - ImportCountriesDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from ImportCountries where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ImportCountriesDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}
	
}
