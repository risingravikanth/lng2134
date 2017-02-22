package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.Storage;
import com.lnganalysis.entities.domain.SupplyDemand;

public class SupplyDemandDaoImpl implements DomainDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
    static final Logger logger=Logger.getLogger(SupplyDemand.class);
	@Override
	public void save(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - SupplyDemandDaoImpl - save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				SupplyDemand supplyDemand=(SupplyDemand)e;
				session.save(supplyDemand);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in SupplyDemandDaoImpl - Method save():"+e);
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

	}

}
