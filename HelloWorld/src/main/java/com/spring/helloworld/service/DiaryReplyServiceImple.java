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
	// - 두 개의 데이터베이스 변경이 생길 때
	// 위의 내용이 실행되었고, 아래 내용이 에러가 발생하면
	// 위의 내용은 rollback 되어야 한다,
	// 이러한 기능을 해주는게 Transactional 어노테이션이다.
	
	@Transactional
	// root-context.xml 에서 설정한 transactionManager를 weaving
	
	@Override
	public int create(DiaryReplyVO vo) {
		
		logger.info("댓글 입력 성공!");
		//TODO : ㅋㅋㄹㅋㅋ
		
		logger.info("게시판 댓글 개수 업데이트 성공");
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
		logger.info("댓글 삭제 성공");
		logger.info("게시판 댓글 개수 업데이트 성공");
		return replyDao.delete(d_rno);
	}
	
	
	
	
	
} // end ReplyServiceImple {}
