package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;

public interface FriendDAO {
	
	public abstract int insertFrRequest(FriendsRequestVO vo);
	public abstract int insertFr(FriendsRequestVO vo);
	public abstract List<FriendsRequestVO> selectSendRequest(String send_userid);
	public abstract List<FriendsRequestVO> selectGetRequest(String get_userid);
	public abstract FriendsRequestVO selectRequestAccepted(FriendsRequestVO vo);
	public abstract List<String> selectFrIdList(String userid);
	public abstract List<FriendsVO> selectFrList(String userid);
	public abstract List<String> checkingApplied1(FriendsRequestVO vo);
	public abstract List<String> checkingApplied2(FriendsRequestVO vo);
	public abstract int updateRequest(FriendsRequestVO vo);
	public abstract int updateFriend1(FriendsRequestVO vo);
	public abstract int updateFriend2(FriendsRequestVO vo);
	public abstract int deleteRequest(FriendsRequestVO vo);
	public abstract int deleteFriend(FriendsVO vo);
	public abstract FriendsVO findnickname(FriendsVO vo);
}
