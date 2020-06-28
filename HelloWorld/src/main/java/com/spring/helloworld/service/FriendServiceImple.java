package com.spring.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.persistence.FriendDAO;

@Service
public class FriendServiceImple implements FriendService{

	@Autowired
	FriendDAO dao;

	@Override
	public int createRequest(FriendsRequestVO vo) {
		
		return dao.insertFrRequest(vo);
	}
	
	@Override
	public int createFreinds(FriendsRequestVO vo) {

		return dao.insertFr(vo);
	}

	@Override
	public List<FriendsRequestVO> readSendReuest(String send_userid) {
		
		return dao.selectSendRequest(send_userid);
	}

	@Override
	public List<FriendsRequestVO> readGetRequest(String get_userid) {
		
		return dao.selectGetRequest(get_userid);
	}
	
	@Override
	public FriendsRequestVO readRequestAccepted(FriendsRequestVO vo) {
		
		return dao.selectRequestAccepted(vo);
	}
	
	@Override
	public List<String> readFrIdList(String userid) {
		
		return dao.selectFrIdList(userid);
	}
	
	@Override
	public List<FriendsVO> readFrList(String userid) {
		
		return dao.selectFrList(userid);
	}

	@Override
	public List<String> checkingApplied1(FriendsRequestVO vo) {
		
		return dao.checkingApplied1(vo);
	}
	public List<String> checkingApplied2(FriendsRequestVO vo) {
		return dao.checkingApplied2(vo);
	}


	@Override
	public int updateRequest(FriendsRequestVO vo) {
		return dao.updateRequest(vo);
	}

	@Override
	public int deleteRequest(FriendsRequestVO vo) {
		
		return dao.deleteRequest(vo);
	}
	
	@Override
	public int deleteFriend(FriendsVO vo) {
		
		return dao.deleteFriend(vo);
	}

	@Override
	public int updateFriend1(FriendsRequestVO vo) {
		
		return dao.updateFriend1(vo);
	}

	@Override
	public int updateFriend2(FriendsRequestVO vo) {
		
		return dao.updateFriend2(vo);
	}

	@Override
	   public FriendsVO findnickname(FriendsVO vo) {
	      // TODO Auto-generated method stub
	      return dao.findnickname(vo);
	   }
	
}
