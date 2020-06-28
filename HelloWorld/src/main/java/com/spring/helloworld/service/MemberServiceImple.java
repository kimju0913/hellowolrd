package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.persistence.MemberDAO;
import com.spring.helloworld.util.PageCriteria;

@Service
public class MemberServiceImple implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImple.class);

	@Autowired
	private MemberDAO dao;

	@Override // 프로필 사진 업로드
	public int photoupdate(MemberVO vo) {
		
		return dao.photoupdate(vo);
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public int useridselect(String userid) {
		
		return dao.useridselect(userid);
	}

	@Override
	public MemberVO userInformation(String userid) {

		logger.info("사용자의 세부정보 리턴 ");

		return dao.selsect(userid);
	}

	@Override
	public int create(MemberVO vo) {
		logger.info("cerate() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("cerate() 호출");
		return dao.insert(vo);
	}

	@Override
	public int delete(String userid) {
		logger.info("delete() 호출");
		return dao.delete(userid);
	}

	@Override
	public int emailupdate(MemberVO vo) {
		
		return dao.emailupdate(vo);

	}

	@Override
	public int passwordupdate(MemberVO vo) {
	
		return dao.passwordupdate(vo);

	}

	@Override
	public int phoenupdate(MemberVO vo) {
	
		return dao.phoenupdate(vo);

	}

	@Override
	public MemberVO selectMember(String userid) {
		System.out.println("=====================service test");
		return dao.selsect(userid);
	}

	@Override
	public String findIdByEmail(MemberVO vo) {
		return dao.selectIdByEmail(vo);
	}

	@Override
	public String findIdByPhone(MemberVO vo) {
		return dao.selectIdByPhone(vo);
	}

	@Override
	public String checkId(String userid) {
		return dao.checkIdExist(userid);
	}

	@Override
	public String findPwByEmail(MemberVO vo) {

		return dao.selectPwByEmail(vo);
	}

	@Override
	public String findPwByPhone(MemberVO vo) {

		return dao.selectPwByPhone(vo);
	}

	@Override
	public List<MemberVO> searchName(MemberVO vo) {
		logger.info("select(사람찾기 이름) 호출");
		return dao.searchName(vo);
	}

	@Override
	public List<MemberVO> searchPhone(MemberVO vo) {
		logger.info("select(사람찾기 폰) 호출");
		return dao.searchPhone(vo);
	}

	@Override
	public int memberCount() {
		
		return dao.memberCount();
	}

	@Override
	public List<MemberVO> SelectUserAll(PageCriteria c) {
		
		return dao.selectuserall(c);
	}

	@Override
	   public int createDefaultOption(MemberVO vo) {
	      
	      return dao.insertDefaultOption(vo);
	   }
	
}