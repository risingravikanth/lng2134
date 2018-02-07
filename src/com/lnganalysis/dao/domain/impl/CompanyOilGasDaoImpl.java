package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.CompanyOilGas;

public class CompanyOilGasDaoImpl implements DomainDao {
	private static SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(CompanyOilGasDaoImpl.class);

	@Override
	public void save(List<Object> list) throws Exception {

		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - CompanyOilGasDaoImpl - Save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				CompanyOilGas companyOilGas=(CompanyOilGas)e;
//				System.out.println("StartFrom:"+contracts.getContractStartFrom());
				session.save(companyOilGas);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CompanyOilGasDaoImpl - Method save():"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
	
		
	}

	@Override
	public void upate(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLastRecordNum() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Set<String> names) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - CompanyOilGasDaoImpl - delete(Set<String> names)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete CompanyOilGas where name=:name");
			for(String name:names)
			{
				query.setParameter("name", name);
				query.executeUpdate();
			}									
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CompanyOilGasDaoImpl - Method delete(Set<String> names):"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
	}

	@Override
	public void delete(String name) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - CompanyOilGasDaoImpl - delete()");
			Transaction tx=session.beginTransaction();			
				Query query=session.createQuery("delete CompanyOilGas where name =:name");	
				query.setParameter("name", name);
				query.executeUpdate();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CompanyOilGasDaoImpl - Method delete():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public List<String> readTerminals() throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();	
		List<String> terminals=null;
		try
		{
			logger.info("Class - CompanyOilGasDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct name from CompanyOilGas order by name asc");					
			terminals=(List<String>)query.list();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CompanyOilGasDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}

}
