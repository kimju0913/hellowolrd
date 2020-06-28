package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.DiaryReplyVO;


@Repository
public class DiaryReplyDAOImple implements DiaryReplyDAO{
	private static final String NAMESPACE =
			"com.spring.helloworld.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(DiaryReplyVO vo) {
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<DiaryReplyVO> select(int d_bno) {
		return sqlSession.selectList(NAMESPACE + ".select_all_by_bno", d_bno);
	}

	@Override
	public int update(DiaryReplyVO vo) {
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int d_rno) {
		return sqlSession.delete(NAMESPACE + ".delete", d_rno);
	}

	
	
	
	
	
} // end ReplyDAOImple

