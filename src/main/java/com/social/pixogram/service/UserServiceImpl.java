package com.social.pixogram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.User;
import com.social.pixogram.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

@Autowired
UserRepo userRepo;

@Override
public List<User> getUsers() {
return (List<User>) userRepo.findAll();
}

@Override
public User createUser(User user) {
return userRepo.save(new User(user.getName(), user.getEmail(), user.getPassword()));
}

@Override
public Optional<User> getUserById(Long userId) {
return (Optional<User>) userRepo.findById(userId);
}

@Override
public Optional<User> getUserByName(String name) {
// TODO Auto-generated method stub
return userRepo.findByName(name);
}

}