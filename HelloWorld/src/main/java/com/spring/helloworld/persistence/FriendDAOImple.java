package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;

@Repository
public class FriendDAOImple implements FriendDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	private static final String NAMESPACE = "com.spring.helloworld.FriendMapper";

	@Override
	public int insertFrRequest(FriendsRequestVO vo) {
		return sqlsession.insert(NAMESPACE + ".insert_frRequest", vo);
	}
	
	@Override
	public int insertFr(FriendsRequestVO vo) {
		return sqlsession.insert(NAMESPACE + ".add_fr", vo);
	}

	@Override
	public List<FriendsRequestVO> selectSendRequest(String send_userid) {
		return sqlsession.selectList(NAMESPACE + ".select_send_frApply", send_userid);
	}

	@Override
	public List<FriendsRequestVO> selectGetRequest(String get_userid) {
		return sqlsession.selectList(NAMESPACE + ".select_get_frApply", get_userid);
	}
	
	@Override
	public FriendsRequestVO selectRequestAccepted(FriendsRequestVO vo) {
		return sqlsession.selectOne(NAMESPACE + ".select_request_accepted", vo);
	}
	
	@Override
	public List<String> selectFrIdList(String userid) {
		return sqlsession.selectList(NAMESPACE + ".select_fr_Id_list", userid);
	}

	
	@Override
	public List<String> checkingApplied1(FriendsRequestVO vo) {
		
		return sqlsession.selectList(NAMESPACE + ".checking_already_applied1",  vo);
	}

	@Override
	public List<String> checkingApplied2(FriendsRequestVO vo) {
		
		return sqlsession.selectList(NAMESPACE + ".checking_already_applied2",  vo);
	}

	@Override
	public int updateRequest(FriendsRequestVO vo) {
		System.out.println("dao ================= " + vo.getRequest_status() + vo.getGet_userid() + vo.getSend_userid());
		return sqlsession.update(NAMESPACE+".update_request", vo);
	}
	
	@Override
	public int updateFriend1(FriendsRequestVO vo) {
		System.out.println(vo.getSend_user_nickname() + "-------=-=-=-=-=-=-==");
		
		return  sqlsession.update(NAMESPACE+".update_friend1", vo);
	}

	@Override
	public int updateFriend2(FriendsRequestVO vo) {
		return  sqlsession.update(NAMESPACE+".update_friend2", vo);
	}

	@Override
	public int deleteRequest(FriendsRequestVO vo) {
		return sqlsession.delete(NAMESPACE + ".delete_request", vo);
	}

	@Override
	public List<FriendsVO> selectFrList(String userid) {
		return sqlsession.selectList(NAMESPACE + ".select_fr_list", userid);
	}

	@Override
	public int deleteFriend(FriendsVO vo) {
		return sqlsession.delete(NAMESPACE + ".delete_friend", vo);
	}

	@Override
	public FriendsVO findnickname(FriendsVO vo) {
	   // TODO Auto-generated method stub
	   return sqlsession.selectOne(NAMESPACE + ".select_friends_nickname", vo);
	}


}
