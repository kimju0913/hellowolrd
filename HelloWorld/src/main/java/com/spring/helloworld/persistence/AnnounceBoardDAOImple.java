package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.util.PageCriteria;

@Repository
public class AnnounceBoardDAOImple  implements AnnounceBoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger =
			LoggerFactory.getLogger(AnnounceBoardDAOImple.class);
	
	private static final String NAMESPACE =	"com.spring.helloworld.AnnounceMapper";
	
	@Override
	public int insert(AnnounceBoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + ".announce_insert", vo);
	}
	
	@Override
	public List<AnnounceBoardVO> select(PageCriteria c) {
		// TODO Auto-generated method stub
		logger.info("¼¿·¿ µé¾î¿È ");
		return sqlSession.selectList(NAMESPACE+".select_page", c);
	}
	
	@Override
	public int announceCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+ ".announce_count");
	}
	
	@Override
	public int announceDelete(int an_bno) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+ "announce_delete");
	}
	@Override
	public int announceUpdate(AnnounceBoardVO vo) {
	
		return  sqlSession.update(NAMESPACE+".announce_update");
	}
	
	
	
	
}
