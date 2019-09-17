package com.social.pixogram.service;

import java.util.List;

import com.social.pixogram.model.Follow;

public interface FollowService {

	public Follow follow(Follow follow);

	public List<Follow> getAll();

	public void unfollow(long id);
}
