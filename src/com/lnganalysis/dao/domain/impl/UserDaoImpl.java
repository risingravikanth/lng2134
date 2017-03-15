package com.lnganalysis.dao.domain.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lnganalysis.config.DbConfiguration;
import com.lnganalysis.dao.domain.UserDao;
import com.lnganalysis.entities.domain.User;

public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory=DbConfiguration.getSessionFactory();		
	static final Logger logger=Logger.getLogger(UserDaoImpl.class);	
	@Override
	public void saveUser(User user)throws Exception {
		// TODO Auto-generated method stub
		Session session=null;				 
		try
		{
			logger.info("Class - UserDaoImpl - saveUser()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserDaoImpl - Method saveUser():"+e);
			throw e;
		}
		finally
		{					
			session.close();					
		}
	}
			
	@Override
	public User getUser(String email)throws Exception {
		// TODO Auto-generated method stub
		User user=null;		
		Session session=null;
		try
		{
			logger.info("Class - UserDaoImpl - getUser()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from User where email=:email");
			query.setParameter("email",email);
			user=(User)query.uniqueResult();
//			Criteria criteria=session.createCriteria(User.class);
//			criteria.add(Restrictions.eq("email", email));
//			user=(User)criteria.uniqueResult();					
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserDaoImpl - Method getUser():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}							
		return user;
	}
	
	@Override
	public void updateUser(User user)throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			logger.info("Class - UserDaoImpl - updateUser()");
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			logger.error("Exception in UserDaoImpl - Method updateUser():"+e);
			throw e;
		} finally {			
				session.close();			
		}
		
		
	}
	public List<User> getUsers()throws Exception
	{
		List<User> usersList=null;		
		Session session=null;
		try
		{
			logger.info("Class - UserDaoImpl - getUsers()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from User");
			usersList=(List<User>)query.list();	
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserDaoImpl - Method getUsers():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
	
		
		return usersList;
	}
	@Override
	public void deleteUser(String email)throws Exception{
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<User> usersList=null;
		try {
			logger.info("Class - UserDaoImpl - deleteUser()");
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User user=getUser(email);
			session.delete(user); 
			tx.commit();
		} catch (Exception e) {
			logger.error("Exception in UserDaoImpl - Method deleteUser():"+e);
			throw e;
		} finally {			
			session.close();			
		}
	}
	
	
	
	@Override
	public List<User> getAdminUsers() throws Exception {
		// TODO Auto-generated method stub
		List<User> usersList=null;		
		Session session=null;
		try
		{
			logger.info("Class - UserDaoImpl - getAdminUsers()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from User where admin=:value");
//			Criteria criteria=session.createCriteria(User.class);
//			criteria.add(Restrictions.eq("admin", "Y"));
			query.setParameter("value","Y");
			usersList=(List<User>)query.list();				
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserDaoImpl - Method getAdminUsers():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}
		
		return usersList;				
	}
	
	
	
	@Override
	public List<User> getNonAdminUsers() throws Exception {
		// TODO Auto-generated method stub
		List<User> usersList=null;		
		Session session=null;
		try
		{
			logger.info("Class - UserDaoImpl - getNonAdminUsers()");
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from User where admin=:value");
//			Criteria criteria=session.createCriteria(User.class);
//			criteria.add(Restrictions.eq("admin", "N"));
			query.setParameter("value","N");
			usersList=(List<User>)query.list();	
			
			tx.commit();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserDaoImpl - Method getNonAdminUsers():"+e);
			throw e;
		}
		finally
		{
			session.close();
		}		
		return usersList;	
	}
			

}
