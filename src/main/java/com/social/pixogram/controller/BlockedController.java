package com.social.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.Blocked;
import com.social.pixogram.service.BlockedService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BlockedController {

	@Autowired
	BlockedService blockedService;

	@PostMapping(path = "/block")
	public Blocked blockUser(@RequestBody Blocked block) {
		System.out.println(block);
		Blocked blockObj = new Blocked();
		List<Blocked> _allBlockedUsers = blockedService.getAllBlocked();
		for (Blocked obj : _allBlockedUsers) {
			if (obj.getBlockedId() == block.getBlockedId() && obj.getUserId() == block.getUserId()) {
				System.out.println("Already user is blocked");
				blockObj = obj;
			} else {
				blockObj = blockedService.blockUser(obj);
			}
		}
		return blockObj;
	}

	@GetMapping(path = "/blocked/{userId}")
	public List<Blocked> getBlockedUsers(@PathVariable Long userId) {
		System.out.println("The user with id " + userId + "has blocked these Id's");
		List<Blocked> blockedList = blockedService.getAllBlocked();
		List<Blocked> _blocked = new ArrayList<>();

		for (Blocked obj : blockedList) {
			if (obj.getUserId() == userId) {
				_blocked.add(obj);
			}
		}
		return _blocked;
	}

	@DeleteMapping(path = "/unblock/{userId}/{blockedId}")
	public ResponseEntity<String> unblockUser(@PathVariable("userId") long userId,
			@PathVariable("blockedId") Long blockedId) {
		List<Blocked> blocked = blockedService.getAllBlocked();
		List<Blocked> _blocked = new ArrayList<>();

		for (Blocked block : blocked) {
			if (block.getUserId() == userId) {
				_blocked.add(block);
			}
		}

		for (Blocked block : _blocked) {
			if (block.getBlockedId() == blockedId) {
				System.out.println(block.getId());
				blockedService.unblockUser(block.getId());
			}
		}
		return new ResponseEntity<>("User has been unblocked", HttpStatus.OK);
	}
}
