package com.villains.service;

import java.util.List;

import com.villains.model.User;


public interface UserService {
	List<User> getAllUser();
	Boolean registerUser(User user);
	User authenticateUser(User user);
	User findUserByEmail(User user);
	void editUser(User user);

}
