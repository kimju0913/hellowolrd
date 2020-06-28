package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;
import com.spring.helloworld.persistence.GuestBoardDAO;


@Service
public class GuestBoardServiceImple implements GuestBoardService  {
	private static final Logger logger = 
			LoggerFactory.getLogger(GuestBoardServiceImple.class);
	
	
	@Autowired
	private GuestBoardDAO dao ;
	
	
	@Override
	public int getTotalCnt(GuestboardPaging p) {
		// TODO Auto-generated method stub
		return dao.getTotalNumsOfRecords(p);
	}
	@Override
	public List<GuestBoardVO> read(GuestboardPaging p) {
		// TODO Auto-generated method stub
		return dao.select(p) ;
	}
	
	@Override
	public int replyupdate(GuestBoardVO vo) {
		logger.info("replyupdate(g_bno ,g_reply) 호출 ");
		return dao.replyupdate(vo);
	}
	
	@Override
	public List<GuestBoardVO> read() {
		logger.info("GuestBoard() 호출 list read");
		return dao.select();
	}
	@Override
	public int create(GuestBoardVO vo) {
		logger.info("cerate() 호출");
		return dao.insert(vo );
	}
	@Override
	public int update(GuestBoardVO vo) {
		logger.info("update() 호출");
		return dao.update(vo);
	}
	
	@Override
	public int delete(int g_bno) {
		logger.info("delete() 호출");
		return dao.delete(g_bno);
	}
	
}
