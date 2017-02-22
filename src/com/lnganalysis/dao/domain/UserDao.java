package com.lnganalysis.dao.domain;

import java.util.List;

import com.lnganalysis.entities.domain.User;

public interface UserDao {
	public void saveUser(User user)throws Exception;
	public User getUser(String userName)throws Exception;
	public List<User> getUsers()throws Exception;
	public void updateUser(User user)throws Exception;
	public void deleteUser(String email)throws Exception;
	public List<User> getAdminUsers() throws Exception;
	public List<User> getNonAdminUsers() throws Exception;
}
