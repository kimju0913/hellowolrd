package com.spring.helloworld.persistence;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.MainformVO;

@Repository
public class MngMinihomeDAOImple implements MngMinihomeDAO{

	private static final String NAMESPACE = "com.spring.helloworld.MngMinihomeMapper";
	
	
	@Autowired
	public SqlSession sqlSession;
	
	
	
	@Override
	public Date getCntDate(String userid) {
		return sqlSession.selectOne(NAMESPACE + ".getCntDate", userid);
	}

	@Override
	public MainformVO selectMainform(String userid) {
		return sqlSession.selectOne(NAMESPACE + ".select_all_mainform", userid);
	}

	@Override
	public int updateCnt(String userid) {
		return sqlSession.update(NAMESPACE + ".update_cnt", userid);
	}

	@Override
	public int resetCnt(String userid) {
		return sqlSession.update(NAMESPACE + ".reset_cnt", userid);
	}

	@Override
	public int updateTitle(MainformVO vo) {
		
		return sqlSession.update(NAMESPACE + ".update_title", vo);
	}

	@Override
	public int updateProfileContent(MainformVO vo) {
		
		return sqlSession.update(NAMESPACE + ".update_profile_content", vo);
	}
	
	@Override
	public int updateProfilePhoto(MainformVO vo) {
		
		return sqlSession.update(NAMESPACE + ".update_photo", vo);
	}
	
	@Override
	public int updateTapMenu(MainformVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update_tap_menu", vo);
	}

	@Override
	public int updateTheme(MainformVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update_theme", vo);
	}
	
	
	
}
