package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.NoticeReplyVO;


@Repository
public class NoticeReplyDAOImple implements NoticeReplyDAO{
	
	private static final String NAMESPACE = "com.spring.helloworld.noticeReplyMapper";
	private static Logger logger = LoggerFactory.getLogger(NoticeReplyDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(NoticeReplyVO vo) {
		logger.info("replyDAO ======= insert 角青");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<NoticeReplyVO> select(int bno) {
		logger.info("replyDAO ======= select 角青");
		return sqlSession.selectList(NAMESPACE + ".select", bno);
	}

	@Override
	public int update(NoticeReplyVO vo) {
		logger.info("replyDAO ======= update 角青");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int rno) {
		logger.info("replyDAO ======= delete 角青");
		return sqlSession.delete(NAMESPACE + ".delete_one", rno);
	}

	@Override
	public int delete_all(int bno) {
		logger.info("replyDAO ======= delete_all 角青");
		return sqlSession.delete(NAMESPACE + ".delete_all", bno);
	}

	
	
}
