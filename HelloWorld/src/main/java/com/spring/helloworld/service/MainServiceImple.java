package com.spring.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.persistence.MainDAO;
import com.spring.helloworld.persistence.MemberDAO;


@Service
public class MainServiceImple implements MainService {

	@Autowired
	MainDAO mainDao;
	MemberDAO memDao;
	
	@Override
	public List<MemberVO> getAllMember(String userid) {
		// TODO Auto-generated method stub
		return mainDao.selectMember(userid);
	}

	

}
