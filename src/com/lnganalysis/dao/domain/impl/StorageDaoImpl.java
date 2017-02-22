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
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.NaturalGas;
import com.lnganalysis.entities.domain.Storage;

public class StorageDaoImpl implements DomainDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
    static final Logger logger=Logger.getLogger(StorageDaoImpl.class);
	@Override
	public void save(List<Object> list)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - StroagedDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				Storage storage=(Storage)e;
				session.save(storage);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageDaoImpl - Method save():"+e);
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
			logger.info("Class - StorageDaoImpl - getLastRecordNum()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Criteria c=session.createCriteria(Storage.class);
			c.setProjection(Projections.max("id"));
			count=(Integer)c.uniqueResult();
			if(count==null)
				count=0;
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageDaoImpl - Method getLastRecordNum():"+e);
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
//		// TODO Auto-generated method stub
//		Session session=null;
//		Criteria c=null;
//		try
//		{
//			logger.info("Class - StorageDaoImpl - update()");
//			session=sessionFactory.openSession();			
//			Transaction tx=session.beginTransaction();
//			for(Object e : list)
//			{							
//				c=session.createCriteria(Storage.class);
//				Storage storage=(Storage)e;
//				c.add(Restrictions.eq("recordId", storage.getRecordId()));
//				Storage updateStorage=(Storage)c.uniqueResult();
//				updateStorage.setTankFarm(storage.getTankFarm());
//				updateStorage.setRegion(storage.getRegion());
//				updateStorage.setCountry(storage.getCountry());
//				updateStorage.setLocation(storage.getLocation());
//				updateStorage.setStatus(storage.getStatus());
//				updateStorage.setCommencementDate(storage.getCommencementDate());
//				updateStorage.setCommencementSource(storage.getCommencementSource());
//				updateStorage.setCurrentOperator(storage.getCurrentOperator());
//				updateStorage.setCurrentOwners(storage.getCurrentOwners());
//				updateStorage.setCurrentOwnership(storage.getCurrentOwnership());
//				updateStorage.setOwnershipNotes(storage.getOwnershipNotes());
//				updateStorage.setHistoricOperator(storage.getHistoricOperator());
//				updateStorage.setHistoricOwners(storage.getHistoricOwners());
//				updateStorage.setHistoricOwnership(storage.getHistoricOwnership());
//				updateStorage.setHistoricalEquityYear(storage.getHistoricalEquityYear());
//				updateStorage.setEquitySource(storage.getEquitySource());
//				updateStorage.setProductsStored(storage.getProductsStored());
//				updateStorage.setModeOfAccess(storage.getModeOfAccess());
//				updateStorage.setCapacityM3(storage.getCapacityM3());
//				updateStorage.setCapacityYear(storage.getCapacityYear());
//				updateStorage.setTanks(storage.getTanks());
//				updateStorage.setTankSizeRange_min_m3(storage.getTankSizeRange_min_m3());
//				updateStorage.setTankSizeRange_max_m3(storage.getTankSizeRange_max_m3());
//				updateStorage.setCapacitySource(storage.getCapacitySource());
//				updateStorage.setCapitalInvestment(storage.getCapitalInvestment());
//				updateStorage.setCapexSource(storage.getCapexSource());
//				updateStorage.setNotes(storage.getNotes());
//				session.update(updateStorage);
//			}
//			tx.commit();
//		}
//		catch(Exception e)
//		{
//			logger.error("Exception in StrorageDaoImpl - Method update():"+e);
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
			logger.info("Class - StorageDaoImpl - delete()");
			Transaction tx=session.beginTransaction();
			for(String name:names)
			{
				
				Criteria criteria=session.createCriteria(Storage.class);
				criteria.add(Restrictions.eq("tankFarm", name));
				List list=criteria.list();
				for(int j=0;j<list.size();j++)
				{
					Storage storage=(Storage)list.get(j);
					session.delete(storage);
				}
			}
														
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in StorageDaoImpl - Method delete():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
	}
}
