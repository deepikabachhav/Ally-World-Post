package com.app.allyworld.FriendService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.allyworld.FriendService.repository.FriendRequestRepository;

@Service
public class FriendRequestServiceImpl implements FriendRequestService{
	
	@Autowired
	private FriendRequestRepository friendRepository;

	@Override
	public void sendFriendRequest() {
		// TODO Auto-generated method stub
		
	}

}
