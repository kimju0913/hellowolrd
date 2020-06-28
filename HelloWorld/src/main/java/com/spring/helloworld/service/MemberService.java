package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.util.PageCriteria;

public interface MemberService {
	MemberVO loginCheck(MemberVO vo); // �α��� üũ

	MemberVO userInformation(String userid); // ���� ���̵� ȸ������ ��ȯ

	public abstract int create(MemberVO vo); // ����

	public abstract int update(MemberVO vo); // ȸ�� ���� ������Ʈ

	public abstract int delete(String userid); // ȸ�� ���� ���� (Ż��)

	public abstract int useridselect(String userid); // ���̵� ���� ����

	public abstract int photoupdate(MemberVO vo);

	public int emailupdate(MemberVO vo); // �̸��� ������Ʈ

	public int phoenupdate(MemberVO vo);// ��ȭ��ȣ ������Ʈ

	public int passwordupdate(MemberVO vo);// ��й�ȣ ������Ʈ 
	
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