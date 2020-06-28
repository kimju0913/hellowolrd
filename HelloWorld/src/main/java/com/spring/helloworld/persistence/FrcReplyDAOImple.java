package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.FrcReplyVO;

@Repository
public class FrcReplyDAOImple implements FrcReplyDAO{
	private static final String NAMESPACE =
			"com.spring.helloworld.FrcReplyMapper"; 
	 /* FrcReply-mapper俊 <mapper namespace="com.spring.helloworld.FrcReplyMapper"> 客
	 * 老摹矫难具窃 */
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(FrcReplyVO vo) {
		
		return sqlSession.insert(NAMESPACE + ".frcinsert", vo);
	}

	@Override
	public List<FrcReplyVO> select(int frc_bno) {
		return sqlSession.selectList(NAMESPACE + ".select_all_by_bno", frc_bno);
	}

	@Override
	public int update(FrcReplyVO vo) {
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int frc_rno) {
		return sqlSession.delete(NAMESPACE + ".delete", frc_rno);
	}
	
}// end FrcReplyDAOImple
