package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.FrcReplyVO;
import com.spring.helloworld.persistence.FrcReplyDAO;



@Service
public class FrcReplyServiceImple implements FrcReplyService{
	private static final Logger logger = 
			LoggerFactory.getLogger(FrcReplyServiceImple.class);
	@Autowired
	private FrcReplyDAO frcReplyDao;

	
	
	@Override
	public int create(FrcReplyVO vo) {
	
		logger.info("create() ȣǮ");
		
		logger.info("�Խ��� ��� ���� ������Ʈ ����");
		return frcReplyDao.insert(vo);
	}

	@Override
	public List<FrcReplyVO> read(int frc_bno) {
		return frcReplyDao.select(frc_bno);
	}

	@Override
	public int update(FrcReplyVO vo) {
		return frcReplyDao.update(vo);
	}

	@Override
	public int delete(int frc_rno) {
		
		logger.info("��� ���� ���� rno : " + frc_rno);
		return frcReplyDao.delete(frc_rno);
	}

}
