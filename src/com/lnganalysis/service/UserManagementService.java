package com.lnganalysis.service;

import java.util.List;

import com.lnganalysis.entities.domain.User;

public interface UserManagementService {
	public String saveUser(String userData);
	public String updateUser(String userData);
	public User getUser(String email);
	public List<User> getUsers();
	public List<User> getAdminUsers();
	public List<User> getNonAdminUsers();
	public String updateUser(User user);
	public String deleteUser(String email);
	public String resetPassword(String email,String password);
}
