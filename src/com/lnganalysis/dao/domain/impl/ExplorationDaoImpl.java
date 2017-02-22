package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.Lng;
import com.lnganalysis.entities.source.ImportCountries;

public class ExplorationDaoImpl implements DomainDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(ExplorationDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - ExplorationDaoImpl - Save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				Exploration exploration=(Exploration)e;
				session.save(exploration);				
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ExplorationDaoImpl - Method save():"+e);
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
	public int getLastRecordNum()throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		Integer count=0;
		try
		{
			logger.info("Class - ExplorationDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(Exploration.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ExplorationDaoImpl - Method getLastRecordNum():"+e);
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
//			logger.info("Class - ExplorationDaoImpl - upate()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(Exploration.class);
//				Exploration exploration=(Exploration)e;
//				c.add(Restrictions.eq("recordId", exploration.getRecordId()));
//				Exploration updateExploration=(Exploration)c.uniqueResult();
//				updateExploration.setBlockNo(exploration.getBlockNo());
//				updateExploration.setRegion(exploration.getRegion());
//				updateExploration.setCountry(exploration.getCountry());
//				updateExploration.setOnShoreOrOffShore(exploration.getOnShoreOrOffShore());
//				updateExploration.setBasin(exploration.getBasin());
//				updateExploration.setStatus(exploration.getStatus());
//				updateExploration.setStartDate(exploration.getStartDate());
//				updateExploration.setOperator(exploration.getOperator());
//				updateExploration.setEquityParterns(exploration.getEquityParterns());
//				updateExploration.setSourceEquity(exploration.getSourceEquity());
//				updateExploration.setArea(exploration.getArea());
//				updateExploration.setLicenseEnddate(exploration.getLicenseEnddate());
//				updateExploration.setWellsDrilled(exploration.getWellsDrilled());
//				updateExploration.setTwoDSeismicCompleted(exploration.getTwoDSeismicCompleted());
//				updateExploration.setThreeDSeismic(exploration.getThreeDSeismic());
//				updateExploration.setMoreInfo(exploration.getMoreInfo());
//				updateExploration.setNotes(exploration.getNotes());
//				updateExploration.setSource(exploration.getSource());
//				updateExploration.setLicenseNo(exploration.getLicenseNo());
//				session.update(updateExploration);
//			}
//			tx.commit();
//		}
//		catch(Exception e)
//		{
//			logger.error("Exception in ExplorationDaoImpl - Method update():"+e);
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
		// TODO Auto-generated method stub		 
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - ExplorationDaoImpl - delete()");
			Transaction tx=session.beginTransaction();
			for(String name:names)
			{
				
				Criteria criteria=session.createCriteria(Exploration.class);
				criteria.add(Restrictions.eq("blockNo", name));
				List list=criteria.list();
				for(int j=0;j<list.size();j++)
				{
					Exploration exploration=(Exploration)list.get(j);
					session.delete(exploration);
				}
			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ExplorationDaoImpl - Method delete():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
	}

	
	
}
