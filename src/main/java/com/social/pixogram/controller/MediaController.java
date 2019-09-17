package com.social.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.Media;
import com.social.pixogram.service.MediaService;
import com.social.pixogram.service.StorageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MediaController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	StorageService storageService;
	
	List<String> files = new ArrayList<String>();

	@GetMapping(path = "/media/{userId}")
	public List<Media> getUsersMedia(@PathVariable int userId) {
		System.out.println("Get all media for the user " + userId);
		List<Media> mediaObj = mediaService.getUsersMedia(userId);
		List<Media> mediaList = new ArrayList<>();
		
		System.out.println(userId);
		System.out.println(mediaObj);
		for (Media obj : mediaObj) {
			if (obj.getUserId() == userId) {
				mediaList.add(obj);
			}
		}
		System.out.println(mediaList);
		return mediaList;
	}
}
