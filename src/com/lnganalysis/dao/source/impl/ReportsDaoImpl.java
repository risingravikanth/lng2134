package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.Report;

public class ReportsDaoImpl implements SourceDao {
	private static SessionFactory sessionFactory=DbConfiguration.getSessionFactory();	
	static final Logger logger=Logger.getLogger(ReportsDaoImpl.class);
	@Override
	public void deleteSource(String reportTitle) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - ReportsDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Report where reportTitle =:title");
			query.setParameter("title", reportTitle);
			query.executeUpdate();	
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportDaoImpl - Method deleteSource():"+e);
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
		Transaction tx=session.beginTransaction();
		List reportsList=null;
		try
		{
			logger.info("Class - ReportsDaoImpl - readSource()");
			Query query=session.createQuery("from Report");
			reportsList=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportsDaoImpl - Method readSource()"+e);
			throw e;
		}
		finally
		{
			
			session.close();
			
		}
		return reportsList;
	}
	public List<Report> readSource(String sector) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List reportsList=null;
		Query query=null;
		try
		{
			logger.info("Class - ReportsDaoImpl - readSource()");
			if(!sector.equalsIgnoreCase("all"))
			{	
				query=session.createQuery("from Report where sector=:sector");
				query.setParameter("sector",sector);
			}
			else
				query=session.createQuery("from Report");
				reportsList=(List<Report>)query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportsDaoImpl - Method readSource()"+e);
			throw e;
		}
		finally
		{			
			session.close();		
		}
		return reportsList;
	}

	@Override
	public void saveSource(String name) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List findSource(String reportTitle) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();	
		List result=null;
		try
		{
			logger.info("Class - ReportsDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Report where reportTitle=:title");
			query.setParameter("title", reportTitle);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportsDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}
	public void saveSource(Report report) throws Exception {
		// TODO Auto-generated method stub
		Session session=null;				 
		try
		{
			logger.info("Class - ReportsDaoImpl - saveUser()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(report);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ReportsDaoImpl - Method saveUser():"+e);
			throw e;
		}
		finally
		{					
			session.close();					
		}
		
	}
}
