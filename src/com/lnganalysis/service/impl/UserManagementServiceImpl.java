package com.lnganalysis.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.constants.UserConstants;
import com.lnganalysis.dao.domain.HistoryDao;
import com.lnganalysis.dao.domain.UserDao;
import com.lnganalysis.dao.domain.impl.HistoryDaoImpl;
import com.lnganalysis.dao.domain.impl.UserDaoImpl;
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.UserManagementService;

public class UserManagementServiceImpl implements UserManagementService {
    static final Logger logger=Logger.getLogger(UserManagementServiceImpl.class);
	@Override
	public String saveUser(String userData){
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			InputStream is=UserManagementServiceImpl.class.getClassLoader().getResourceAsStream(ApplicationConstants.APP_PROPERTIES);
			Properties properties=new Properties();
			properties.load(is);			
			UserDao userDao=new UserDaoImpl();
			JSONObject jsonUserObject=getJsonObject(userData);
			User user=new User();//userDao.getUser((String)jsonUserObject.get(UserConstants.EMAIL));
			String email=(String)jsonUserObject.get(UserConstants.EMAIL);
			User userExists=userDao.getUser(email);
			if(null!=userExists)
			{
				response=ApplicationConstants.USER_EXISTS;
			}
			else
			{
				String userName=email.substring(0, email.indexOf("@"));
				user.setUserName(userName);
				user.setFirstName((String)jsonUserObject.get(UserConstants.FIRST_NAME));
				user.setLastName((String)jsonUserObject.get(UserConstants.LAST_NAME));
				user.setMobile((String)jsonUserObject.get(UserConstants.MOBILE));
				user.setEmail(email);
				user.setAddress((String)jsonUserObject.get(UserConstants.ADDRESS));
				user.setAdmin((String)jsonUserObject.get(UserConstants.ADMIN));
				user.setRole((String)jsonUserObject.get(UserConstants.ROLE));
		//		user.setPassword((String)jsonUserObject.get(UserConstants.PASSWORD));
				user.setUserImage(userName);
				user.setPasswordReset(ApplicationConstants.NO);
				user.setPassword((String)properties.get("DEFAULT_PASSWORD"));
			
			
				userDao.saveUser(user);
				response=ApplicationConstants.SUCCESS;
			}
			
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method saveUser():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
	}

	@Override
	public String updateUser(String userData) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
					
			JSONObject jsonUserObject=getJsonObject(userData);
			UserDao userDao=new UserDaoImpl();
			
			String email=(String)jsonUserObject.get(UserConstants.EMAIL);
			String userName=email.substring(0, email.indexOf("@"));
			
			User user=userDao.getUser(email);
			
			user.setUserName(userName);
			user.setFirstName((String)jsonUserObject.get(UserConstants.FIRST_NAME));
			user.setLastName((String)jsonUserObject.get(UserConstants.LAST_NAME));
			user.setMobile((String)jsonUserObject.get(UserConstants.MOBILE));			
			user.setAddress((String)jsonUserObject.get(UserConstants.ADDRESS));
			user.setAdmin((String)jsonUserObject.get(UserConstants.ADMIN));
			user.setRole((String)jsonUserObject.get(UserConstants.ROLE));			
	//		user.setUserImage((String)jsonUserObject.get(UserConstants.IMAGE_NAME));			
			userDao.updateUser(user);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method updateUser():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		UserDao userDao=null;
		User user=null;
		try
		{
			userDao=new UserDaoImpl();
			user=userDao.getUser(email);
		}
		catch(Exception e)
		{		
			logger.error("Exception in UserManagementServiceImpl - Method getUser():"+e);
		}		
		return user;
	}
	public List<User> getUsers()
	{
		UserDao userDao=null;
		List<User> usersList=null;
		try
		{
			userDao=new UserDaoImpl();
			usersList=userDao.getUsers();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method getUsers():"+e);
		}
		return usersList;
	}


	@Override
	public List<User> getAdminUsers(){
		// TODO Auto-generated method stub
		UserDao userDao=null;
		List<User> usersList=null;
		try
		{
			userDao=new UserDaoImpl();
			usersList=userDao.getAdminUsers();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method getAdminUsers():"+e);
			
		}
		return usersList;
	}

	@Override
	public List<User> getNonAdminUsers(){
		// TODO Auto-generated method stub
		UserDao userDao=null;
		List<User> usersList=null;
		try
		{
			userDao=new UserDaoImpl();
			usersList=userDao.getNonAdminUsers();
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method getNonAdminUsers():"+e);
		}
		return usersList;
	}

	@Override
	public String deleteUser(String email) {
		// TODO Auto-generated method stub
		UserDao userDao=null;
		User user;
		HistoryDao historyDao=null;
		String response=null;
		try
		{
			userDao=new UserDaoImpl();
			historyDao=new HistoryDaoImpl();
			user=userDao.getUser(email);
			if(null!=user)
			{
				List<History> hisortyList=historyDao.readUserHistory(user);
				for(History history:hisortyList)
				{
					historyDao.deleteHistory(history);
				}
				userDao.deleteUser(email);
				response=ApplicationConstants.SUCCESS;
			}
			else
			{
				response=ApplicationConstants.USER_NOT_EXISTS;
			}
			
		}
		catch(Exception e)
		{
			logger.error("UserManagementServiceImpl - Method deleteUser():"+e);
			response=ApplicationConstants.FAIL;
			
		}
		return response;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		UserDao userDao=null;	
		String response=null;
		try
		{
			userDao=new UserDaoImpl();
			userDao.updateUser(user);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method updateUser():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
		
	}
	
	public JSONObject getJsonObject(String userData)throws Exception{
		JSONParser parser=new JSONParser();
		JSONObject jsonUserObject=(JSONObject)parser.parse(userData);
		return jsonUserObject;
	}

	@Override
	public String resetPassword(String email,String password) {
		// TODO Auto-generated method stub
		UserDao userDao=null;
		String response=null;
		try
		{
			userDao=new UserDaoImpl();
			User user=getUser(email);
			user.setPassword(password);			
			userDao.updateUser(user);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in UserManagementServiceImpl - Method resetPassword():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
	}

}
