package com.lnganalysis.dao.domain.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.entities.domain.Contracts;

public class ContractsDaoImpl implements DomainDao{
	private static SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(ContractsDaoImpl.class);
	@Override
	public void save(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			logger.info("Class - ContractsDaoImpl - Save()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			for(Object e : list)
			{
				
				Contracts contracts=(Contracts)e;
//				System.out.println("StartFrom:"+contracts.getContractStartFrom());
				session.save(contracts);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ContractsDaoImpl - Method save():"+e);
			throw e;
		}
		finally
		{			
			session.close();			
		}
	}
	public static void main(String[] args) {				
		Session s=sessionFactory.openSession();
		Contracts contracts=new Contracts();
		contracts.setYear(2011);
		s.save(contracts);
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
			logger.info("Class - ContractsDaoImpl - delete(Set<String> names)");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Contracts where contractIndicator=:name");
			for(String name:names)
			{
				query.setParameter("name", name);
				query.executeUpdate();
			}
//			for(String name:names)
//			{
//				
//				Criteria criteria=session.createCriteria(Contracts.class);
//				criteria.add(Restrictions.eq("contractIndicator", name));
//				List list=criteria.list();
//				for(int j=0;j<list.size();j++)
//				{
//					Contracts contracts=(Contracts)list.get(j);
//					session.delete(contracts);
//				}
//			}													
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ContractsDaoImpl - Method delete(Set<String> names):"+e);
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
			logger.info("Class - ContractsDaoImpl - delete()");
			Transaction tx=session.beginTransaction();			
				Query query=session.createQuery("delete Contracts where contractIndicator =:name");	
				query.setParameter("name", name);
				query.executeUpdate();
								
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ContractsDaoImpl - Method delete():"+e);
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
			logger.info("Class - ContractsDaoImpl - readTerminals()");
			Transaction tx=session.beginTransaction();			
			Query query=session.createQuery("select distinct contractIndicator from Contracts");				
			terminals=(List<String>)query.list();						
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in ContractsDaoImpl - Method readTerminals():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return terminals;
	}

}
