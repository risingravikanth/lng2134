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
import com.lnganalysis.entities.domain.NaturalGas;

public class NaturalGasDaoImpl implements DomainDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(NaturalGasDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - NaturalGasDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				NaturalGas naturalGas=(NaturalGas)e;
				session.save(naturalGas);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in NaturalGasDaoImpl - Method save():"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
		
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
			logger.info("Class - NaturalGasDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(NaturalGas.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.info("Exception in NaturalGasDaoImpl - Method getLastRecordNum():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
		return count;
	}

	@Override
	public void upate(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
//		Session session=null;
//		Criteria c=null;
//		try
//		{
//			logger.info("Class - NaturalGasDaoImpl - update()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(NaturalGas.class);
//				NaturalGas naturalGas=(NaturalGas)e;
//				c.add(Restrictions.eq("recordId", naturalGas.getRecordId()));
//				NaturalGas updateNaturalGas=(NaturalGas)c.uniqueResult();
//				updateNaturalGas.setField(naturalGas.getField());
//				updateNaturalGas.setRegion(naturalGas.getRegion());
//				updateNaturalGas.setCountry(naturalGas.getCountry());
//				updateNaturalGas.setLocation(naturalGas.getLocation());
//				updateNaturalGas.setBasin(naturalGas.getBasin());
//				updateNaturalGas.setStatus(naturalGas.getStatus());
//				updateNaturalGas.setOnshoreOrOffshore(naturalGas.getOnshoreOrOffshore());
//				updateNaturalGas.setProductionStartDate(naturalGas.getProductionStartDate());
//				updateNaturalGas.setCurrentOperator(naturalGas.getCurrentOperator());
//				updateNaturalGas.setCurrentOwners(naturalGas.getCurrentOwners());
//				updateNaturalGas.setCurrentOwnership(naturalGas.getCurrentOwnership());
//				updateNaturalGas.setHistoricOperator(naturalGas.getHistoricOperator());
//				updateNaturalGas.setHistoricOwners(naturalGas.getHistoricOwners());
//				updateNaturalGas.setHistoricOwnership(naturalGas.getHistoricOwnership());
//				updateNaturalGas.setHistoricEquityYear(naturalGas.getHistoricEquityYear());
//				updateNaturalGas.setSourceEquity(naturalGas.getSourceEquity());
//				updateNaturalGas.setYear2005(naturalGas.getYear2005());
//				updateNaturalGas.setYear2006(naturalGas.getYear2006());
//				updateNaturalGas.setYear2007(naturalGas.getYear2007());
//				updateNaturalGas.setYear2008(naturalGas.getYear2008());
//				updateNaturalGas.setYear2009(naturalGas.getYear2009());
//				updateNaturalGas.setYear2010(naturalGas.getYear2010());
//				updateNaturalGas.setYear2011(naturalGas.getYear2011());
//				updateNaturalGas.setYear2012(naturalGas.getYear2012());
//				updateNaturalGas.setYear2013(naturalGas.getYear2013());
//				updateNaturalGas.setYear2014(naturalGas.getYear2014());
//				updateNaturalGas.setNotes(naturalGas.getNotes());
//				session.update(updateNaturalGas);
//			}
//			tx.commit();
//		}
//		catch(Exception e)
//		{
//			logger.error("Exception in NaturalGasDaoImpl - Method update():"+e);
//			throw e;
//		}
//		finally
//		{			
//			session.close();			
//		}
	}

	@Override
	public void delete(Set<String> names) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - NaturalGasDaoImpl - delete(Set<String>)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete NaturalGas where field=:name");
			for(String name:names)
			{
				query.setParameter("name", name);
				query.executeUpdate();
			}
//			for(String name:names)
//			{
//				
//				Criteria criteria=session.createCriteria(NaturalGas.class);
//				criteria.add(Restrictions.eq("field", name));
//				List list=criteria.list();
//				for(int j=0;j<list.size();j++)
//				{
//					NaturalGas naturalGas=(NaturalGas)list.get(j);
//					session.delete(naturalGas);
//				}
//			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in NaturalGasDaoImpl - Method delete(Set<String>):"+e);
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
			logger.info("Class - NaturalGasDaoImpl - delete(name)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete NaturalGas where field=:name");			
			query.setParameter("name", name);
			query.executeUpdate();			
																	
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in NaturalGasDaoImpl - Method delete(name):"+e);
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
			logger.info("Class - NaturalGasDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct field from NaturalGas");					
			terminals=(List<String>)query.list();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in NaturalGasDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}

	

}
