package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.MemberVO;

public interface MainService {
	public abstract List<MemberVO> getAllMember(String userid);
	
}
