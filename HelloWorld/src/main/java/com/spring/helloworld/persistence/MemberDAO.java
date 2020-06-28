package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.util.PageCriteria;

public interface MemberDAO {
	MemberVO loginCheck(MemberVO vo);
	public abstract MemberVO selsect(String userid);// 세션에 있는 유저아이디를 통해서 사용자의 정보 반환 
	public abstract int insert(MemberVO vo);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid );
	public abstract int useridselect(String userid);
	public abstract int photoupdate(MemberVO vo);
	public abstract String selectIdByPhone(MemberVO vo);
	public abstract String selectIdByEmail(MemberVO vo);
	public abstract String selectPwByEmail(MemberVO vo);
	public abstract String selectPwByPhone(MemberVO vo);
	public abstract String checkIdExist(String userid);
	public abstract int phoenupdate(MemberVO vo);     //폰번호 업데이트 
	public abstract int passwordupdate(MemberVO vo);  // 비밀번호 업데이
	public abstract int emailupdate(MemberVO vo);// 이메일 업데이트
	List<MemberVO> selectuserall(PageCriteria c);
	public abstract int memberCount();
    public abstract List<MemberVO> searchName(MemberVO vo);
	public abstract List<MemberVO> searchPhone(MemberVO vo);
	public abstract int insertDefaultOption(MemberVO vo);
	

}