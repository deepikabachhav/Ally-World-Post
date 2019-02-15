package com.app.allyworld.FriendService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.allyworld.FriendService.entity.FriendRequest;

@Repository
public interface FriendRequestRepository extends MongoRepository<FriendRequest, Integer> {

}
