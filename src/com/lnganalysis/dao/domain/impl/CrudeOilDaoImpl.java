package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.CrudeOil;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.Refinery;

public class CrudeOilDaoImpl implements DomainDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(CrudeOilDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - CrudeOilDaoImpl - Save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				CrudeOil crudeOil=(CrudeOil)e;
				session.save(crudeOil);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CrudeOilDaoImpl - Method save():"+e);
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
			logger.info("Class - CrudeOilDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(CrudeOil.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CrudeOilDaoImpl - Method getLastRecordNum():"+e);
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
//			logger.info("Class - CrudeOilDaoImpl - upate()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(CrudeOil.class);
//				CrudeOil crudeOil=(CrudeOil)e;
//				c.add(Restrictions.eq("recordId", crudeOil.getRecordId()));
//				CrudeOil updateCrudeOil=(CrudeOil)c.uniqueResult();
//				updateCrudeOil.setField(crudeOil.getField());
//				updateCrudeOil.setRegion(crudeOil.getRegion());
//				updateCrudeOil.setCountry(crudeOil.getCountry());
//				updateCrudeOil.setLocation(crudeOil.getLocation());
//				updateCrudeOil.setBasin(crudeOil.getBasin());
//				updateCrudeOil.setStatus(crudeOil.getStatus());
//				updateCrudeOil.setOnshoreOrOffshore(crudeOil.getOnshoreOrOffshore());
//				updateCrudeOil.setProductionStartDate(crudeOil.getProductionStartDate());
//				updateCrudeOil.setCurrentOperator(crudeOil.getCurrentOperator());
//				updateCrudeOil.setCurrentOwners(crudeOil.getCurrentOwners());
//				updateCrudeOil.setCurrentOwnership(crudeOil.getCurrentOwnership());
//				updateCrudeOil.setHistoricOperator(crudeOil.getHistoricOperator());
//				updateCrudeOil.setHistoricOwners(crudeOil.getHistoricOwners());
//				updateCrudeOil.setHistoricOwnership(crudeOil.getHistoricOwnership());
//				updateCrudeOil.setHistoricEquityYear(crudeOil.getHistoricEquityYear());
//				updateCrudeOil.setSourceEquity(crudeOil.getSourceEquity());
//				updateCrudeOil.setYear2005(crudeOil.getYear2005());
//				updateCrudeOil.setYear2006(crudeOil.getYear2006());
//				updateCrudeOil.setYear2007(crudeOil.getYear2007());
//				updateCrudeOil.setYear2008(crudeOil.getYear2008());
//				updateCrudeOil.setYear2009(crudeOil.getYear2009());
//				updateCrudeOil.setYear2010(crudeOil.getYear2010());
//				updateCrudeOil.setYear2011(crudeOil.getYear2011());
//				updateCrudeOil.setYear2012(crudeOil.getYear2012());
//				updateCrudeOil.setYear2013(crudeOil.getYear2013());
//				updateCrudeOil.setYear2014(crudeOil.getYear2014());
//				updateCrudeOil.setNotes(crudeOil.getNotes());
//				session.update(updateCrudeOil);
//			}
//			tx.commit();
//		}
//		catch(Exception e)
//		{
//			logger.error("Exception in CrudeOilDaoImpl - Method update():"+e);
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
			logger.info("Class - CrudeOilDaoImpl - delete()");
			Transaction tx=session.beginTransaction();
			for(String name:names)
			{
				
				Criteria criteria=session.createCriteria(CrudeOil.class);
				criteria.add(Restrictions.eq("field", name));
				List list=criteria.list();
				for(int j=0;j<list.size();j++)
				{
					CrudeOil crudeOil=(CrudeOil)list.get(j);
					session.delete(crudeOil);
				}
			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in CrudeOilDaoImpl - Method delete():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
	}

	
	
}	
