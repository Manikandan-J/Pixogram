package com.social.pixogram.service;

import java.util.List;

import com.social.pixogram.model.Media;

public interface MediaService {

	public List<Media> getUsersMedia(int userId);

	public Media postMedia(Media m);
}
