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
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.NaturalGas;
import com.lnganalysis.entities.domain.PipeLine;
import com.lnganalysis.entities.domain.Storage;

public class PipelineDaoImpl implements DomainDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
    static final Logger logger=Logger.getLogger(PipelineDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - PipelineDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				PipeLine pipeline=(PipeLine)e;
				session.save(pipeline);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in PipelineDaoImpl - Method save():"+e);
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
			logger.info("Class - PipelineDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(PipeLine.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
			
		}
		catch(Exception e)
		{
			logger.error("Exception in PipeLineDaoImpl - Method getLastRecordNum():"+e);
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
//			logger.info("Class - PipelineDaoImpl - update()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(PipeLine.class);
//				PipeLine pipeLine=(PipeLine)e;
//				c.add(Restrictions.eq("recordId", pipeLine.getRecordId()));
//				PipeLine updatePipeLine=(PipeLine)c.uniqueResult();
//				updatePipeLine.setPipeline(pipeLine.getPipeline());
//				updatePipeLine.setSubPipelines(pipeLine.getSubPipelines());
//				updatePipeLine.setStatus(pipeLine.getStatus());
//				updatePipeLine.setCommodity(pipeLine.getCommodity());
//				updatePipeLine.setStartPoint(pipeLine.getStartPoint());
//				updatePipeLine.setEndPoint(pipeLine.getEndPoint());
//				updatePipeLine.setCountry(pipeLine.getCountry());
//				updatePipeLine.setRegion(pipeLine.getRegion());
//				updatePipeLine.setStartCountry(pipeLine.getStartCountry());
//				updatePipeLine.setStartRegion(pipeLine.getStartRegion());				
//				updatePipeLine.setEndCountry(pipeLine.getEndCountry());				
//				updatePipeLine.setEndRegion(pipeLine.getEndRegion());				
//				updatePipeLine.setRoute(pipeLine.getRoute());
//				updatePipeLine.setPipelineType(pipeLine.getPipelineType());
//				updatePipeLine.setOnshoreOrOffshore(pipeLine.getOnshoreOrOffshore());
//				updatePipeLine.setStartDate(pipeLine.getStartDate());
//				updatePipeLine.setCommodityDetails(pipeLine.getCommodityDetails());
//				updatePipeLine.setBasicDetailsSource(pipeLine.getBasicDetailsSource());
//				updatePipeLine.setBasicDetailNotes(pipeLine.getBasicDetailNotes());
//				updatePipeLine.setOperator(pipeLine.getOperator());
//				updatePipeLine.setEquityPartners(pipeLine.getEquityPartners());
//				updatePipeLine.setEquityStakes(pipeLine.getEquityStakes());
//				updatePipeLine.setCompanySource(pipeLine.getCompanySource());
//				updatePipeLine.setCompanyNotes(pipeLine.getCompanyNotes());
//				updatePipeLine.setLength(pipeLine.getLength());
//				updatePipeLine.setDiameter(pipeLine.getDiameter());
//				updatePipeLine.setCapacity(pipeLine.getCapacity());
//				updatePipeLine.setCapex(pipeLine.getCapex());
//				updatePipeLine.setParameterSource(pipeLine.getParameterSource());
//				updatePipeLine.setParameterNotes(pipeLine.getParameterNotes());
//				session.update(updatePipeLine);
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
		Session session=sessionFactory.openSession();								
		try
		{
			logger.info("Class - pipeLineDaoImpl - delete(Set<String>)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete PipeLine where pipeline=:name");
			for(String name:names)
			{
				query.setParameter("name",name);
				query.executeUpdate();
			}
//			for(String name:names)
//			{
//				
//				Criteria criteria=session.createCriteria(PipeLine.class);
//				criteria.add(Restrictions.eq("pipeline", name));
//				List list=criteria.list();
//				for(int j=0;j<list.size();j++)
//				{
//					PipeLine pipeLine=(PipeLine)list.get(j);
//					session.delete(pipeLine);
//				}
//			}													
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in pipeLineDaoImpl - Method delete(Set<String>):"+e);
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
			logger.info("Class - pipeLineDaoImpl - delete(name)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete PipeLine where pipeline=:name");			
			query.setParameter("name",name);
			query.executeUpdate();													
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in pipeLineDaoImpl - Method delete(name):"+e);
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
			logger.info("Class - pipeLineDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct pipeline from PipeLine");					
			terminals=(List<String>)query.list();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in pipeLineDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}


}
