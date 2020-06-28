package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.helloworld.domain.DiaryReplyVO;
import com.spring.helloworld.persistence.DiaryBoardDAO;
import com.spring.helloworld.persistence.DiaryReplyDAO;


@Service
public class DiaryReplyServiceImple implements DiaryReplyService{
	private static final Logger logger =
			LoggerFactory.getLogger(DiaryReplyServiceImple.class);
	
	@Autowired
	private DiaryReplyDAO replyDao;
	
	// @Transactional
	// - �� ���� �����ͺ��̽� ������ ���� ��
	// ���� ������ ����Ǿ���, �Ʒ� ������ ������ �߻��ϸ�
	// ���� ������ rollback �Ǿ�� �Ѵ�,
	// �̷��� ����� ���ִ°� Transactional ������̼��̴�.
	
	@Transactional
	// root-context.xml ���� ������ transactionManager�� weaving
	
	@Override
	public int create(DiaryReplyVO vo) {
		
		logger.info("��� �Է� ����!");
		//TODO : ����������
		
		logger.info("�Խ��� ��� ���� ������Ʈ ����");
		return replyDao.insert(vo);
	}

	@Override
	public int update(DiaryReplyVO vo) {
		return replyDao.update(vo);
	}
	
	@Override
	public List<DiaryReplyVO> read(int d_bno) {
		return replyDao.select(d_bno);
	}


	@Override
	public int delete(int d_rno, int d_bno) {
		logger.info("��� ���� ����");
		logger.info("�Խ��� ��� ���� ������Ʈ ����");
		return replyDao.delete(d_rno);
	}
	
	
	
	
	
} // end ReplyServiceImple {}
