package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;

@Repository // @component �� ����
public class GuestBoardDAOImple implements GuestBoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(GuestBoardDAOImple.class);
	// mapper ��� ����
	private static final String NAMESPACE = "com.spring.helloworld.GuestBoardMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GuestBoardVO> select(GuestboardPaging p) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_all_homeid", p);
	}

	@Override
	public int getTotalNumsOfRecords(GuestboardPaging p) {
		logger.info("DAO get total num ȣ�� ");
		return sqlSession.selectOne(NAMESPACE + ".guest_total_count", p);
	}

	@Override
	public int replyupdate(GuestBoardVO vo) {
		logger.info("replyupdate() ȣ��");

		return sqlSession.update(NAMESPACE + ".replyinsert", vo);
	}

	@Override
	public List<GuestBoardVO> select() {
		// TODO Auto-generated method stub
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");

	}

	@Override
	public int insert(GuestBoardVO vo) {
		logger.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(GuestBoardVO vo) {
		logger.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);

	}

	@Override
	public int delete(int g_bno) {
		logger.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", g_bno);

	}

	@Override
	public List<GuestBoardVO> select(GuestBoardVO criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalNumsOfRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReplycnt(int amount, int bno) {
		// TODO Auto-generated method stub
		return 0;
	}
}
