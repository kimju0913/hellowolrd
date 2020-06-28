package com.spring.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.persistence.AnnounceBoardDAO;
import com.spring.helloworld.util.PageCriteria;

@Service
public class AnnounceBoardServiceImple implements AnnounceBoardService {

	@Autowired AnnounceBoardDAO dao;
	
	
	
	@Override
	public int create(AnnounceBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}
	
	@Override
	public List<AnnounceBoardVO> read(PageCriteria c) {
		// TODO Auto-generated method stub
		return dao.select(c);
	}
	
	@Override
	public int announceDelete(int an_bno) {
		// TODO Auto-generated method stub
		return dao.announceDelete(an_bno);
	}
	
	@Override
	public int announceUpdate(AnnounceBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.announceUpdate(vo);
	}
	
	@Override
	public int announceCount() {
		// TODO Auto-generated method stub
		return dao.announceCount();
	}
}
