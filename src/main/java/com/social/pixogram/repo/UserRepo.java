package com.social.pixogram.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.social.pixogram.model.User;

public interface UserRepo extends CrudRepository<User, Long>{

	Optional<User> findByName(String name);

}
