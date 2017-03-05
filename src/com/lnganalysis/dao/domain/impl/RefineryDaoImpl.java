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
import com.lnganalysis.entities.domain.Refinery;

public class RefineryDaoImpl implements DomainDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(RefineryDaoImpl.class);

	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - RefineryDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				Refinery refinery=(Refinery)e;				
				session.save(refinery);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in  RefineryDaoImpl - Method save():"+e);
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
			logger.info("Class - RefineryDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(Refinery.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefineryDaoImpl - Method getLastRecordNum():"+e);
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
//			logger.info("Class - RefineryDaoImpl - update()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(Refinery.class);
//				Refinery refinery=(Refinery)e;
//				c.add(Restrictions.eq("recordId", refinery.getRecordId()));
//				Refinery updateRefinery=(Refinery)c.uniqueResult();
//				updateRefinery.setName(refinery.getName());
//				updateRefinery.setLocation(refinery.getLocation());
//				updateRefinery.setCountry(refinery.getCountry());
//				updateRefinery.setRegion(refinery.getRegion());
//				updateRefinery.setStatus(refinery.getStatus());
//				updateRefinery.setCapacityYear(refinery.getCapacityYear());
//				updateRefinery.setStatusDetails(refinery.getStatusDetails());
//				updateRefinery.setStatusDate(refinery.getStatusDate());
//				updateRefinery.setStatusSource(refinery.getStatusSource());
//				updateRefinery.setMoreInfo(refinery.getMoreInfo());
//				updateRefinery.setType(refinery.getType());
//				updateRefinery.setStartYear(refinery.getStartYear());
//				updateRefinery.setDecomissionedYear(refinery.getDecomissionedYear());
//				updateRefinery.setAssetOrStartSource(refinery.getAssetOrStartSource());
//				updateRefinery.setCurrentOperator(refinery.getCurrentOperator());
//				updateRefinery.setCurrentEquityPartners(refinery.getCurrentEquityPartners());
//				updateRefinery.setCurrentEquityStakes(refinery.getCurrentEquityStakes());
//				updateRefinery.setEquityDetails(refinery.getEquityDetails());
//				updateRefinery.setHistoricOperator(refinery.getHistoricOperator());
//				updateRefinery.setHistoricEquityPartners(refinery.getHistoricEquityPartners());
//				updateRefinery.setHistoricEquityStakes(refinery.getHistoricEquityStakes());
//				updateRefinery.setHistoricEquityYear(refinery.getHistoricEquityYear());
//				updateRefinery.setEquitySource(refinery.getEquitySource());
//				updateRefinery.setRefiningCapacity(refinery.getRefiningCapacity());
//				updateRefinery.setVduCapacity(refinery.getVduCapacity());
//				updateRefinery.setCokingCapacity(refinery.getCokingCapacity());
//				updateRefinery.setFcc(refinery.getFcc());
//				updateRefinery.setHydroCrackingCapacity(refinery.getHydroCrackingCapacity());
//				updateRefinery.setSourceCapacities(refinery.getSourceCapacities());
//				updateRefinery.setCrudeStorageUnitOrTanksNo(refinery.getCrudeStorageUnitOrTanksNo());
//				updateRefinery.setCrudeStorageCapacity(refinery.getCrudeStorageCapacity());
//				updateRefinery.setNelsonComplexityIndex(refinery.getNelsonComplexityIndex());
//				updateRefinery.setCrudeThroughput(refinery.getCrudeThroughput());
//				updateRefinery.setCrudeType(refinery.getCrudeType());
//				updateRefinery.setApi(refinery.getApi());
//				updateRefinery.setSulphur(refinery.getSulphur());
//				updateRefinery.setSourceInput(refinery.getSourceInput());
//				updateRefinery.setVisbreakingCapacity(refinery.getVisbreakingCapacity());
//				updateRefinery.setReformerCapacity(refinery.getReformerCapacity());
//				updateRefinery.setHydrotreatingCapacity(refinery.getHydrotreatingCapacity());
//				updateRefinery.setAlkylationCapacity(refinery.getAlkylationCapacity());
//				updateRefinery.setAlkylationCapacityUnit(refinery.getAlkylationCapacityUnit());
//				updateRefinery.setAromaticsCapacity(refinery.getAromaticsCapacity());
//				updateRefinery.setAromaticsCapacityUnit(refinery.getAromaticsCapacityUnit());
//				updateRefinery.setIsomerizationCapacity(refinery.getIsomerizationCapacity());
//				updateRefinery.setPolymerizationCapacity(refinery.getPolymerizationCapacity());
//				updateRefinery.setPolymerizationCapacityUnit(refinery.getPolymerizationCapacityUnit());
//				updateRefinery.setLubesCapacity(refinery.getLubesCapacity());
//				updateRefinery.setLubesCapacityUnit(refinery.getLubesCapacityUnit());
//				updateRefinery.setOxygenatesCapacity(refinery.getOxygenatesCapacity());
//				updateRefinery.setOxygenatesCapacityUnit(refinery.getOxygenatesCapacityUnit());
//				updateRefinery.setCokeCapacity(refinery.getCokeCapacity());
//				updateRefinery.setCokeCapacityUnit(refinery.getCokeCapacityUnit());
//				updateRefinery.setSulphurCapacity(refinery.getSulphurCapacity());
//				updateRefinery.setSulphurCapacityUnit(refinery.getSulphurCapacityUnit());
//				updateRefinery.setHydrogenCapacity(refinery.getHydrogenCapacity());
//				updateRefinery.setHydrogenCapacityUnit(refinery.getHydrogenCapacityUnit());
//				updateRefinery.setAsphaltCapacity(refinery.getAsphaltCapacity());
//				updateRefinery.setAsphaltCapacityUnit(refinery.getAsphaltCapacityUnit());
//				updateRefinery.setOthersCapacity(refinery.getOthersCapacity());
//				updateRefinery.setRefineryProducts(refinery.getRefineryProducts());
//				updateRefinery.setSourceProducts(refinery.getSourceProducts());
//				updateRefinery.setRefineryUtilization(refinery.getRefineryUtilization());
//				updateRefinery.setGrm(refinery.getGrm());
//				updateRefinery.setCapex(refinery.getCapex());
//				updateRefinery.setCapexYear(refinery.getCapexYear());
//				updateRefinery.setCapexDetails(refinery.getCapexDetails());
//				updateRefinery.setSourceCapex(refinery.getSourceCapex());
//				updateRefinery.setConstructionCompanyName(refinery.getConstructionCompanyName());
//				updateRefinery.setConstructionContractDetails(refinery.getConstructionContractDetails());
//				updateRefinery.setRefineryOtherNames(refinery.getRefineryOtherNames());
//				updateRefinery.setOtherSources(refinery.getOtherSources());
//				updateRefinery.setContact(refinery.getContact());
//				updateRefinery.setGasolinePetrol(refinery.getGasolinePetrol());
//				updateRefinery.setLpg(refinery.getLpg());
//				updateRefinery.setKerosine(refinery.getKerosine());
//				updateRefinery.setJetFuel(refinery.getJetFuel());
//				updateRefinery.setDiesel(refinery.getDiesel());
//				updateRefinery.setPropylene(refinery.getPropylene());
//				updateRefinery.setLightNaphtha(refinery.getLightNaphtha());
//				updateRefinery.setHeavyNaphtha(refinery.getHeavyNaphtha());
//				updateRefinery.setKerojet(refinery.getKerojet());
//				updateRefinery.setBenzeneSaturationUnit(refinery.getBenzeneSaturationUnit());
//				updateRefinery.setProductsSources(refinery.getProductsSources());
//				session.update(updateRefinery);
//			}
//			tx.commit();
//		}
//		catch(Exception e)
//		{
//			logger.error("Exception in RefineryDaoImpl - Method update():"+e);
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
			logger.info("Class - RefineryDaoImpl - delete(Set<String>)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Refinery where name=:name");
			for(String name:names)
			{
				query.setParameter("name",name);
				query.executeUpdate();
			}
//			for(String name:names)
//			{
//				
//				Criteria criteria=session.createCriteria(Refinery.class);
//				criteria.add(Restrictions.eq("name", name));
//				List list=criteria.list();
//				for(int j=0;j<list.size();j++)
//				{
//					Refinery refinery=(Refinery)list.get(j);
//					session.delete(refinery);
//				}
//			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefineryDaoImpl - Method delete(Set<String>):"+e);
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
			logger.info("Class - RefineryDaoImpl - delete(name)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Refinery where name=:name");
			query.setParameter("name",name);
			query.executeUpdate();
			
//			for(String name:names)
//			{
//				
//				Criteria criteria=session.createCriteria(Refinery.class);
//				criteria.add(Restrictions.eq("name", name));
//				List list=criteria.list();
//				for(int j=0;j<list.size();j++)
//				{
//					Refinery refinery=(Refinery)list.get(j);
//					session.delete(refinery);
//				}
//			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefineryDaoImpl - Method delete(name):"+e);
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
			logger.info("Class - RefineryDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct name from Refinery");					
			terminals=(List<String>)query.list();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in RefineryDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}
}
