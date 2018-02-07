package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.Lng;
import com.lnganalysis.entities.domain.SmallScaleLng;

public class SmallScaleLngDaoImpl implements DomainDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(SmallScaleLngDaoImpl.class);

	@Override
	public void save(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - SmallScaleLngDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{				
				SmallScaleLng ssl=(SmallScaleLng)e;
				session.save(ssl);				
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SmallScaleLngDaoImpl - Method save():"+e);
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
		Session session=null;
		Integer count=0;
		try
		{
			logger.info("Class - SmallScaleLngDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(SmallScaleLng.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SmallScaleLngDaoImpl - Method getLastRecordNum():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
		return count;
	}

	@Override
	public void delete(Set<String> names) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - SmallScaleLngDaoImpl - delete(Set(<String>)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete SmallScaleLng where terminalName=:name");
			for(String name:names)
			{
				query.setParameter("name",name);
				query.executeUpdate();
			}																
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SmallScaleLngDaoImpl - Method delete(Set(<String>):"+e);
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
			logger.info("Class - SmallScaleLngDaoImpl - delete(String)");
			Transaction tx=session.beginTransaction();			
				Query query=session.createQuery("delete SmallScaleLng where terminalName =:name");
//				criteria.add(Restrictions.eq("contractIndicator", name));
//				List list=criteria.list();				
				query.setParameter("name", name);
				query.executeUpdate();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SmallScaleLngDaoImpl - Method delete(String):"+e);
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
			logger.info("Class - SmallScaleLngDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct terminalName from SmallScaleLng");			
			terminals=(List<String>)query.list();							
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SmallScaleLngDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}

}
