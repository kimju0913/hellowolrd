package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.DiaryBoardFolderChangeVO;
import com.spring.helloworld.domain.DiaryBoardFolderDeleteVO;
import com.spring.helloworld.domain.DiaryBoardPagingVO;
import com.spring.helloworld.domain.DiaryBoardVO;

@Repository // @Component
// - 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
// - Spring component bean으로 등록함
// - 스프링 프레임워크가 bean을 생성하기 위해서는
//   root-context.xml에 bean으로 등록해야 함
// - <context:component-scan ... />
public class DiaryBoardDAOImple implements DiaryBoardDAO {
	private static final String NAMESPACE = "com.spring.helloworld.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(DiaryBoardDAOImple.class);

	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;

	// 기존 코드
	@Override
	public DiaryBoardVO select(int d_bno) {
		logger.info("select() 호출 : bno = " + d_bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", d_bno);
	}

	@Override
	public int insert(DiaryBoardVO vo) {
		logger.info("insert() 호출");
		logger.info("vo 로그 : " + vo);
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(DiaryBoardVO vo) {
		logger.info("update() 호출");
		logger.info("DAOImple_vo : " + vo);
		logger.info("DAOImple_d_content : " + vo.getD_content());
		logger.info("DAOImple_d_user_name : " + vo.getUser_name());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int d_bno) {
		logger.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", d_bno);
	}

	// 전체
	@Override
	public int getTotalNumsOfPagingAll(DiaryBoardPagingVO p) {
		logger.info("getTotalNumsOfPaging () 호출");
		logger.info("페이징 start : " + p.getStart());
		logger.info("페이징 end : " + p.getEnd());
		return sqlSession.selectOne(NAMESPACE + ".total_count", p);
	}

	@Override
	public int getTotalNumsOfPaging(DiaryBoardPagingVO p) {
		logger.info("getTotalNumsOfPaging () 호출");
		logger.info("페이징 start : " + p.getStart());
		logger.info("페이징 end : " + p.getEnd());
		return sqlSession.selectOne(NAMESPACE + ".total_count_by_folder", p);
	}

	@Override // 폴더 전체 보기
	public List<DiaryBoardVO> selectAll(DiaryBoardPagingVO p) {
		logger.info("DAOImple_paging_p : " + p);
		return sqlSession.selectList(NAMESPACE + ".paging", p);

	}

	// 폴더 이름으로
	@Override
	public List<DiaryBoardVO> selectByFolder(DiaryBoardPagingVO p) {
		logger.info("DAOImple_selectByFolder : " + p);
		return sqlSession.selectList(NAMESPACE + ".paging_by_d_folder", p);
	}

	// 폴더 리스트
	@Override
	public String selectByFolderList(String userid) {
		logger.info("select() 호출 : userid = " + userid);
		return sqlSession.selectOne(NAMESPACE + ".select_by_folderList", userid);
	}

	// 폴더 편집
	@Override
	public int update_f(DiaryBoardVO vo) {
		logger.info("DAOImple_folder_update : " + vo);
		return sqlSession.update(NAMESPACE + ".update_folder", vo);
	}

	@Override
	public int update_fName(DiaryBoardFolderChangeVO fn) {
		logger.info("DAOImple_folder_name : " + fn);

		return sqlSession.update(NAMESPACE + ".update_fName", fn);
	}

	@Override
	public int update_fList(DiaryBoardFolderChangeVO fn) {
		logger.info("DAOImple_folder_List : " + fn);

		return sqlSession.update(NAMESPACE + ".update_fList", fn);
	}

	@Override
	public int delete(DiaryBoardFolderDeleteVO fd) {
		logger.info("DAOImple_delete_folder : " + fd);
		return sqlSession.delete(NAMESPACE + ".delete_f", fd);
	}

	// 달력 관련 날짜로 검색
	@Override
	public List<DiaryBoardVO> select_date(DiaryBoardPagingVO p) {
		String d_date = p.getD_date() + "%";
		p.setD_date(d_date);
		logger.info("DAOImple_d_date : " + d_date);
		return sqlSession.selectList(NAMESPACE + ".select_date", p);
	}

	// 날짜 로 검색 시 페이징
	@Override
	public int datePaging(DiaryBoardPagingVO p) {
		String d_date = p.getD_date() + "%";
		p.setD_date(d_date);
		logger.info("DAOImple_d_date : " + d_date);
		return sqlSession.selectOne(NAMESPACE + ".datePaging", p);
	}

	
} // end DiaryBoardDAOImple{}
