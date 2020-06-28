package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.util.PageCriteria;

public interface MemberService {
	MemberVO loginCheck(MemberVO vo); // 로그인 체크

	MemberVO userInformation(String userid); // 세션 아이디 회원정보 반환

	public abstract int create(MemberVO vo); // 생성

	public abstract int update(MemberVO vo); // 회원 정보 업데이트

	public abstract int delete(String userid); // 회원 정보 삭제 (탈퇴)

	public abstract int useridselect(String userid); // 아이디 정보 리턴

	public abstract int photoupdate(MemberVO vo);

	public int emailupdate(MemberVO vo); // 이메일 업데이트

	public int phoenupdate(MemberVO vo);// 전화번호 업데이트

	public int passwordupdate(MemberVO vo);// 비밀번호 업데이트 
	
	public abstract MemberVO selectMember(String userid);
	
	public abstract String findIdByEmail(MemberVO vo);
	
	public abstract String findIdByPhone(MemberVO vo);
	
	public abstract String findPwByEmail(MemberVO vo);
	public abstract String findPwByPhone(MemberVO vo);
	public abstract String checkId(String userid);
	
	public abstract int  memberCount();
	   
	   
	   
	   List<MemberVO> SelectUserAll(PageCriteria c);

	   public abstract List<MemberVO> searchName(MemberVO vo);

	   public abstract List<MemberVO> searchPhone(MemberVO vo);
	   public abstract int createDefaultOption(MemberVO vo);
	

}