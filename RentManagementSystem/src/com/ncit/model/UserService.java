package com.ncit.model;

import java.util.List;

import com.ncit.entity.User;

public interface UserService {

	//Login using User
	public boolean isUserValid(User user);
	
	//Get all users
	public List<User>getAllUsers();
	
	//Create a new user
	public boolean insertUser(User user);
	
	//Get user by its id
	public User getUserById(int id);
	
	//Update user by id
	public boolean updateUser(User user);
	
	//Delete user by id
	public boolean deleteUser(User user);
	
}
