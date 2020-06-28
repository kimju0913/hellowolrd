package com.spring.helloworld.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.helloworld.domain.NoticeReplyVO;
import com.spring.helloworld.persistence.NoticeReplyDAO;


@Repository
public class NoticeReplyServiceImple implements NoticeReplyService {
	
	private static Logger logger = LoggerFactory.getLogger(NoticeReplyServiceImple.class);
	
	@Autowired
	NoticeReplyDAO rDao;

	@Override
	public int create(NoticeReplyVO vo) {
		logger.info("service ======= create 호출");
		return rDao.insert(vo);
	}

	@Override
	public List<NoticeReplyVO> read(int bno) {
		logger.info("service ======= read 호출");
		return rDao.select(bno);
	}

	@Override
	public int update(NoticeReplyVO vo) {
		logger.info("service ======= update 호출");
		return rDao.update(vo);
	}

	@Override
	public int delete(int rno) {
		logger.info("service ======= delete(rno) 호출");
		return rDao.delete(rno);
	}

	@Override
	public int delete_all(int bno) {
		logger.info("service ======= delete_all 호출");
		return rDao.delete_all(bno);
	}
	
	

}
