package com.lnganalysis.dao.source.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.entities.source.Type;

public class TypeDaoImpl implements SourceDao {
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();
	static final Logger logger=Logger.getLogger(TypeDaoImpl.class);
	@Override
	public void deleteSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		try
		{
			logger.info("Class - TypeDaoImpl - deleteSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("delete Type where name =:sourceName");
			query.setParameter("sourceName", sourceName);
			query.executeUpdate();
//			Criteria criteria=session.createCriteria(Type.class);
//			criteria.add(Restrictions.eq("name", sourceName));
//			Type type=(Type)criteria.uniqueResult();
//			session.delete(type);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in TypeDaoImpl - Method deleteSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
	}

	@Override
	public List<Object> readSource()throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List typeList=null;
		try
		{
			logger.info("Class - TypeDaoImpl - readSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Type");
			typeList=query.list();
//			Criteria criteria=session.createCriteria(Type.class);
//			typeList=criteria.list();			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in TypeDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		return typeList;
	}

	@Override
	public void saveSource(String sourceName)throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();		
		try
		{
			logger.info("Class - TypeDaoImpl - saveSource()");
			Transaction tx=session.beginTransaction();
			Type type=new Type();
			type.setName(sourceName);
			session.save(type);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in TypeDaoImpl - Method readSource():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		
		
	}

	@Override
	public List  findSource(String sourceName) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();	
		List result=null;
		try
		{
			logger.info("Class - TypeDaoImpl - findSource()");
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Type where name=:sourceName");
			query.setParameter("sourceName", sourceName);
			result=query.list();
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in TypeDaoImpl - Method findSource()"+e);
			throw e;
		}
		finally
		{
			session.close();
		}	
		return result;
	}

}
