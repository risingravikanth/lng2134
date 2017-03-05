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
import com.lnganalysis.entities.domain.Lng;

public class LngDaoImpl implements DomainDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(LngDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - LngDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{				
				Lng lng=(Lng)e;
				session.save(lng);				
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngDaoImpl - Method save():"+e);
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
			logger.info("Class - LngDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(Lng.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngDaoImpl - Method getLastRecordNum():"+e);
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
//			logger.info("Class - LngDaoImpl - update()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(Lng.class);
//				Lng lng=(Lng)e;
//				c.add(Restrictions.eq("recordId", lng.getRecordId()));
//				Lng updateLng=(Lng)c.uniqueResult();
//				updateLng.setName(lng.getName());
//				updateLng.setCountry(lng.getCountry());
//				updateLng.setArea(lng.getArea());
//				updateLng.setRegion(lng.getRegion());
//				updateLng.setType(lng.getType());
//				updateLng.setStatus(lng.getStatus());
//				updateLng.setFeedDetails(lng.getFeedDetails());
//				updateLng.setFidDetails(lng.getFidDetails());
//				updateLng.setConstructionStatusDetails(lng.getConstructionStatusDetails());
//				updateLng.setSources(lng.getSources());
//				updateLng.setOtherStatusDetails(lng.getOtherStatusDetails());
//				updateLng.setStatusDate(lng.getStatusDate());
//				updateLng.setStatusSource(lng.getStatusSource());
//				updateLng.setOnshoreOrOffshore(lng.getOnshoreOrOffshore());
//				updateLng.setExpectedStartYear(lng.getExpectedStartYear());
//				updateLng.setScheduledStartYear(lng.getScheduledStartYear());
//				updateLng.setDelayOrInitialStartYear(lng.getDelayOrInitialStartYear());
//				updateLng.setDelayDetails(lng.getDelayDetails());
//				updateLng.setTechnologyDetails(lng.getTechnologyDetails());
//				updateLng.setNumberOfTrainsOrNumberOfVaporizers(lng.getNumberOfTrainsOrNumberOfVaporizers());
//				updateLng.setCapacity(lng.getCapacity());
//				updateLng.setCapacityYear(lng.getCapacityYear());
//				updateLng.setExpansionDetail(lng.getExpansionDetail());
//				updateLng.setSource(lng.getSource());
//				updateLng.setAdditionalProducts(lng.getAdditionalProducts());
//				updateLng.setAdditionalProductsProduction(lng.getAdditionalProductsProduction());
//				updateLng.setAdditionalProductsProductionUnit(lng.getAdditionalProductsProductionUnit());
//				updateLng.setNumberOfStorageTanks(lng.getNumberOfStorageTanks());
//				updateLng.setTotalLngStorageCapacity(lng.getTotalLngStorageCapacity());
//				updateLng.setSourcesOther(lng.getSourcesOther());
//				updateLng.setOperator(lng.getOperator());
//				updateLng.setEquityPartners(lng.getEquityPartners());
//				updateLng.setEquityStakes(lng.getEquityStakes());
//				updateLng.setEquityNotes(lng.getEquityNotes());
//				updateLng.setHistoricOperator(lng.getHistoricOperator());
//				updateLng.setHistoricEquityPartner(lng.getHistoricEquityPartner());
//				updateLng.setHistoricEquityStake(lng.getHistoricEquityStake());
//				updateLng.setHistoricEquityYear(lng.getHistoricEquityYear());
//				updateLng.setEquitySources(lng.getEquitySources());
//				updateLng.setFeedOrInputType(lng.getFeedOrInputType());
//				updateLng.setFeedOrInputName(lng.getFeedOrInputName());
//				updateLng.setFeedOrInputDetails(lng.getFeedOrInputDetails());
//				updateLng.setDisttributionOrOutputType(lng.getDisttributionOrOutputType());
//				updateLng.setDisttributionOrOutputName(lng.getDisttributionOrOutputName());
//				updateLng.setDisttributionOrOutputDetails(lng.getDisttributionOrOutputDetails());
//				updateLng.setJettyInfo_m3(lng.getJettyInfo_m3());
//				updateLng.setCapex(lng.getCapex());
//				updateLng.setCapexYear(lng.getCapexYear());
//				updateLng.setCapexDetails(lng.getCapexDetails());
//				updateLng.setSources1(lng.getSources1());
//				updateLng.setConstructionStart(lng.getConstructionStart());
//				updateLng.setConstructionEnd(lng.getConstructionEnd());
//				updateLng.setConstructionCompanyName(lng.getConstructionCompanyName());
//				updateLng.setConstructionContractDetails(lng.getConstructionContractDetails());
//				updateLng.setOtherContractsDetails(lng.getOtherContractsDetails());
//				updateLng.setLngTerminalOtherNames(lng.getLngTerminalOtherNames());
//				updateLng.setRelatedCompanies(lng.getRelatedCompanies());
//				updateLng.setRelatedCompanyDetails(lng.getRelatedCompanyDetails());
//				updateLng.setSources2(lng.getSources2());
//				updateLng.setMoreInfo(lng.getMoreInfo());
//				updateLng.setUnits(lng.getUnits());
//				session.update(updateLng);
//				
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
					logger.info("Class - LngDaoImpl - delete(Set(<String>)");
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("delete Lng where name=:name");
					for(String name:names)
					{
						query.setParameter("name",name);
						query.executeUpdate();
					}
//					for(String name:names)
//					{
//						
//						Criteria criteria=session.createCriteria(Lng.class);
//						criteria.add(Restrictions.eq("name", name));
//						List list=criteria.list();
//						for(int j=0;j<list.size();j++)
//						{
//							Lng lng=(Lng)list.get(j);
//							session.delete(lng);
//						}
//					}
																
					tx.commit();
				}
				catch(Exception e)
				{
					logger.error("Exception in LngDaoImpl - Method delete(Set(<String>):"+e);
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
			logger.info("Class - LngDaoImpl - delete(String)");
			Transaction tx=session.beginTransaction();			
				Query query=session.createQuery("delete Lng where name =:name");
//				criteria.add(Restrictions.eq("contractIndicator", name));
//				List list=criteria.list();				
				query.setParameter("name", name);
				query.executeUpdate();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngDaoImpl - Method delete(String):"+e);
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
			logger.info("Class - LngDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct name from Lng");			
			terminals=(List<String>)query.list();							
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in LngDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}

}
