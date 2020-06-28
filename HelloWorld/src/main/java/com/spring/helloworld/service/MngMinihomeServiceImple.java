package com.spring.helloworld.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.MainformVO;
import com.spring.helloworld.persistence.MngMinihomeDAO;

@Service
public class MngMinihomeServiceImple implements MngMinihomeService {

	@Autowired
	MngMinihomeDAO miniDao;
	
	@Override
	public Date readCntDate(String userid) {
		
		return miniDao.getCntDate(userid);
	}

	@Override
	public MainformVO readMainform(String userid) {
		
		return miniDao.selectMainform(userid);
	}

	@Override
	public int updateCnt(String userid) {
		
		return miniDao.updateCnt(userid);
	}

	@Override
	public int resetCnt(String userid) {
	
		return miniDao.resetCnt(userid);
	}

	@Override
	public int updateTitle(MainformVO vo) {
	
		return miniDao.updateTitle(vo);
	}

	@Override
	public int updateProfileContent(MainformVO vo) {
		// TODO Auto-generated method stub
		return miniDao.updateProfileContent(vo);
	}
	@Override
	public int updateProfilePhoto(MainformVO vo) {
		// TODO Auto-generated method stub
		return miniDao.updateProfilePhoto(vo);
	}

	
	@Override
	public int updateTapMenu(MainformVO vo) {
		// TODO Auto-generated method stub
		return miniDao.updateTapMenu(vo);
	}

	@Override
	public int updateTheme(MainformVO vo) {
		// TODO Auto-generated method stub
		return miniDao.updateTheme(vo);
	}
	
	
}
