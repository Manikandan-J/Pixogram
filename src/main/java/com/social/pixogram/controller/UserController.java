package com.social.pixogram.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.User;
import com.social.pixogram.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

@Autowired
UserService userService;

@GetMapping(path = "/users")
public List<User> getUsers() {
System.out.println("Retrieving the users");
return userService.getUsers();
}

@PostMapping(path = "/user/create")
public User createUser(@RequestBody User user) {
System.out.println("Creating the User Account");
User _user = userService.createUser(user);
return _user;
}

@GetMapping(path = "/user/{userId}")
public Optional<User> getUserById(@PathVariable Long userId) {
System.out.println("Retreiving the user with  " + userId);
return userService.getUserById(userId);
}

@GetMapping(path = "/username/{name}")
public Optional<User> getUserByName(@PathVariable String name)
{

return userService.getUserByName(name);

}

}
