package com.social.pixogram.service;

import java.util.List;


import com.social.pixogram.model.Blocked;


public interface BlockedService {
	
	public List<Blocked> getAllBlocked(); 
	
	public void unblockUser(Long id);
	
	public Blocked blockUser(Blocked block);
	
}
