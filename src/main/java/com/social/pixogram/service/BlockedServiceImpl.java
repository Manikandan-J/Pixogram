package com.social.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.Blocked;
import com.social.pixogram.repo.BlockedRepo;

@Service
public class BlockedServiceImpl implements BlockedService{

	@Autowired
	BlockedRepo blockedRepo;

	@Override
	public List<Blocked> getAllBlocked() {
		return (List<Blocked>) blockedRepo.findAll();
	}

	@Override
	public void unblockUser(Long id) {
		blockedRepo.deleteById(id);
		return;
	}

	@Override
	public Blocked blockUser(Blocked blocked) {
		return blockedRepo.save(blocked);
	}
	
	
}
