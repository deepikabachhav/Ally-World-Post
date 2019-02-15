package com.app.allyworld.FriendService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.allyworld.FriendService.entity.FriendRequest;
import com.app.allyworld.FriendService.service.FriendRequestService;

@RestController
@RequestMapping("/friends")
public class FriendServiceResource {

	@Autowired
	private FriendRequestService friendRequestService;

	@PostMapping("/{sender=? & receiver=?}")
	public void sendFriendRequest(@PathVariable("sender") int senderProfileId , @PathVariable ("receiver")int receiverProfileId) {
		friendRequestService.sendFriendRequest();
		
	}

	@GetMapping
	public void acceptFriendRequest() {

	}

	@PutMapping
	public void updateFriendsList() {

	}

}
