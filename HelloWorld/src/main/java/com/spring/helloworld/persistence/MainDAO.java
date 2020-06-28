package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.MemberVO;

public interface MainDAO {
	//전체 회원 불러오
	public abstract List<MemberVO> selectMember(String userid);
}
