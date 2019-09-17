package com.social.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.Follow;
import com.social.pixogram.repo.FollowRepo;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepo followRepo;

	@Override
	public Follow follow(Follow follow) {
		return followRepo.save(follow);
	}

	@Override
	public List<Follow> getAll() {
		return (List<Follow>) followRepo.findAll();
	}


	@Override
	public void unfollow(long id) {
		followRepo.deleteById(id);
		return;
	}

}
