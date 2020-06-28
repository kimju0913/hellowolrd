package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.MemberVO;

@Repository
public class MainDAOImple implements MainDAO{
	
	private static final String NAMESPACE = "com.spring.helloworld.MainMapper";
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<MemberVO> selectMember(String userid) {
		
		return sqlsession.selectList(NAMESPACE + ".select_all_member", userid);
	}
	
	

}
