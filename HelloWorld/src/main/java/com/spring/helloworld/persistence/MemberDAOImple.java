package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.util.PageCriteria;

@Repository
public class MemberDAOImple implements MemberDAO {
	private static final String NAMESPACE = "com.spring.helloworld.MemberMapper";

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImple.class);

	@Autowired
	private SqlSession sqlSession;

	@Override // 프로필 사진 업로드
	public int photoupdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".photoupdate", vo);
	}

	@Override
	public int useridselect(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_userid_list", userid);
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {

		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	}

	@Override
	public MemberVO selsect(String userid) {
		logger.info("memberDAO select() 호출 " + userid);

		return sqlSession.selectOne(NAMESPACE + ".select_by_userid", userid);
	}

	@Override
	public int insert(MemberVO vo) {

		logger.info("insert(회원가입)");

		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("update(회원정보수정) ");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(String userid) {
		logger.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", userid);
	}

	@Override
	public String selectIdByPhone(MemberVO vo) {

		return sqlSession.selectOne(NAMESPACE + ".findId_by_phone", vo);
	}

	@Override
	public String selectIdByEmail(MemberVO vo) {
		logger.info("dao 메일 확인" + vo.getUser_email() + vo.getUser_name());
		return sqlSession.selectOne(NAMESPACE + ".findId_by_email", vo);
	}

	@Override
	public String checkIdExist(String userid) {
		System.out.println("---------------------" + userid);
		return sqlSession.selectOne(NAMESPACE + ".checkId_exist", userid);
	}

	@Override
	public String selectPwByEmail(MemberVO vo) {
		return sqlSession.selectOne(NAMESPACE + ".findPw_by_email", vo);
	}

	@Override
	public String selectPwByPhone(MemberVO vo) {
		return sqlSession.selectOne(NAMESPACE + ".findPw_by_phone", vo);
	}

	@Override
	public int emailupdate(MemberVO vo) {

		return sqlSession.update(NAMESPACE + ".user_email_update", vo);
	}

	@Override
	public int passwordupdate(MemberVO vo) {

		return sqlSession.update(NAMESPACE + ".user_pw_update", vo);
	}

	@Override
	public int phoenupdate(MemberVO vo) {
		return sqlSession.update(NAMESPACE + ".user_phoen_update", vo);
	}

	@Override
	public List<MemberVO> searchName(MemberVO vo) {
		logger.info("MemberDAO (사람찾기 이름) select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_searchName", vo);
	}

	@Override
	public List<MemberVO> searchPhone(MemberVO vo) {
		logger.info("MemberDAO (사람찾기 폰) select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_searchPhone", vo);
	}

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".member_count_user");
	}

	@Override
	public List<MemberVO> selectuserall(PageCriteria c) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_page" ,c);
	}
	
	@Override
	   public int insertDefaultOption(MemberVO vo) {
	      return sqlSession.insert(NAMESPACE + ".make_default", vo);
	   }
	
	

}