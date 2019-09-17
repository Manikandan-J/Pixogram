package com.social.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.Media;
import com.social.pixogram.repo.MediaRepo;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	MediaRepo mediaRepo;

	@Override
	public List<Media> getUsersMedia(int userId) {
		return (List<Media>) mediaRepo.findAll();
	}

	@Override
	public Media postMedia(Media m) {
		// TODO Auto-generated method stub
		return mediaRepo.save(new Media(m.getUserId(), m.getUrl(), m.getTitle(), m.getDescription(), m.getTags()));
	}

}
