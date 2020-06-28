package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;

public interface FriendService {

	public abstract int createRequest(FriendsRequestVO vo);
	public abstract int createFreinds(FriendsRequestVO vo);
	public abstract List<FriendsRequestVO> readSendReuest(String send_userid);
	public abstract List<FriendsRequestVO> readGetRequest(String get_userid);
	public abstract FriendsRequestVO readRequestAccepted(FriendsRequestVO vo);
	public abstract List<String> readFrIdList(String userid);
	public abstract List<FriendsVO> readFrList(String userid);
	public abstract List<String> checkingApplied1(FriendsRequestVO vo);
	public abstract List<String> checkingApplied2(FriendsRequestVO vo);
	public abstract int updateRequest(FriendsRequestVO vo);
	public abstract int updateFriend1(FriendsRequestVO vo);
	public abstract int updateFriend2(FriendsRequestVO vo);
	public abstract int deleteRequest(FriendsRequestVO vo);
	public abstract int deleteFriend(FriendsVO vo);
	public abstract FriendsVO findnickname(FriendsVO vo);
	
}
