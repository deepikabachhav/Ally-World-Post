package com.app.allyworld.FriendService.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FriendRequest {

	private Integer senderProfileId;
	private Integer receiverProfileId;

	public FriendRequest() {
		super();
	}

	public FriendRequest(Integer senderProfileId, Integer receiverProfileId) {
		super();
		this.senderProfileId = senderProfileId;
		this.receiverProfileId = receiverProfileId;
	}

	public Integer getSenderProfileId() {
		return senderProfileId;
	}

	public void setSenderProfileId(Integer senderProfileId) {
		this.senderProfileId = senderProfileId;
	}

	public Integer getReceiverProfileId() {
		return receiverProfileId;
	}

	public void setReceiverProfileId(Integer receiverProfileId) {
		this.receiverProfileId = receiverProfileId;
	}

	@Override
	public String toString() {
		return "Sender [senderProfileId=" + senderProfileId + ", receiverProfileId=" + receiverProfileId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((receiverProfileId == null) ? 0 : receiverProfileId.hashCode());
		result = prime * result + ((senderProfileId == null) ? 0 : senderProfileId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendRequest other = (FriendRequest) obj;
		if (receiverProfileId == null) {
			if (other.receiverProfileId != null)
				return false;
		} else if (!receiverProfileId.equals(other.receiverProfileId))
			return false;
		if (senderProfileId == null) {
			if (other.senderProfileId != null)
				return false;
		} else if (!senderProfileId.equals(other.senderProfileId))
			return false;
		return true;
	}

}
