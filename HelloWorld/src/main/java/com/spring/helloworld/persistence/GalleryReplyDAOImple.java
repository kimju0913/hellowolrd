package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.GalleryReplyVO;


@Repository
public class GalleryReplyDAOImple implements GalleryReplyDAO{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(GalleryReplyDAOImple.class);
	
	private static final String NAMESPACE = 
			"com.spring.helloworld.GalleryReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(GalleryReplyVO vo) {
		logger.info("reply dao imple ===== " + vo.getGl_reply_content());
		return sqlSession.insert(NAMESPACE+".insert_reply", vo);
	}

	@Override
	public List<GalleryReplyVO> select(int gl_bno) {
		logger.info("reply dao imple select");
		return sqlSession.selectList(NAMESPACE+".select_reply_by_gl_bno", gl_bno);
	}


	@Override
	public int update(GalleryReplyVO vo) {
		return sqlSession.update(NAMESPACE+".update_reply", vo);
	}

	@Override
	public int delete(int gl_rno) {
		return sqlSession.delete(NAMESPACE+".delete_reply", gl_rno);
	}

	
	

}
