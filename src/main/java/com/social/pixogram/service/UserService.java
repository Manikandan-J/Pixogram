package com.social.pixogram.service;

import java.util.List;
import java.util.Optional;


import com.social.pixogram.model.User;


public interface UserService {

	public List<User> getUsers();
	
	public User createUser(User user);
	
	public Optional<User> getUserById(Long userId);

	Optional<User> getUserByName(String name);
}
