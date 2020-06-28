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
// - ���� ����(Persistence Layer)�� DB ���� ����� ���
// - Spring component bean���� �����
// - ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//   root-context.xml�� bean���� ����ؾ� ��
// - <context:component-scan ... />
public class DiaryBoardDAOImple implements DiaryBoardDAO {
	private static final String NAMESPACE = "com.spring.helloworld.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(DiaryBoardDAOImple.class);

	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;

	// ���� �ڵ�
	@Override
	public DiaryBoardVO select(int d_bno) {
		logger.info("select() ȣ�� : bno = " + d_bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", d_bno);
	}

	@Override
	public int insert(DiaryBoardVO vo) {
		logger.info("insert() ȣ��");
		logger.info("vo �α� : " + vo);
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(DiaryBoardVO vo) {
		logger.info("update() ȣ��");
		logger.info("DAOImple_vo : " + vo);
		logger.info("DAOImple_d_content : " + vo.getD_content());
		logger.info("DAOImple_d_user_name : " + vo.getUser_name());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int d_bno) {
		logger.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", d_bno);
	}

	// ��ü
	@Override
	public int getTotalNumsOfPagingAll(DiaryBoardPagingVO p) {
		logger.info("getTotalNumsOfPaging () ȣ��");
		logger.info("����¡ start : " + p.getStart());
		logger.info("����¡ end : " + p.getEnd());
		return sqlSession.selectOne(NAMESPACE + ".total_count", p);
	}

	@Override
	public int getTotalNumsOfPaging(DiaryBoardPagingVO p) {
		logger.info("getTotalNumsOfPaging () ȣ��");
		logger.info("����¡ start : " + p.getStart());
		logger.info("����¡ end : " + p.getEnd());
		return sqlSession.selectOne(NAMESPACE + ".total_count_by_folder", p);
	}

	@Override // ���� ��ü ����
	public List<DiaryBoardVO> selectAll(DiaryBoardPagingVO p) {
		logger.info("DAOImple_paging_p : " + p);
		return sqlSession.selectList(NAMESPACE + ".paging", p);

	}

	// ���� �̸�����
	@Override
	public List<DiaryBoardVO> selectByFolder(DiaryBoardPagingVO p) {
		logger.info("DAOImple_selectByFolder : " + p);
		return sqlSession.selectList(NAMESPACE + ".paging_by_d_folder", p);
	}

	// ���� ����Ʈ
	@Override
	public String selectByFolderList(String userid) {
		logger.info("select() ȣ�� : userid = " + userid);
		return sqlSession.selectOne(NAMESPACE + ".select_by_folderList", userid);
	}

	// ���� ����
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

	// �޷� ���� ��¥�� �˻�
	@Override
	public List<DiaryBoardVO> select_date(DiaryBoardPagingVO p) {
		String d_date = p.getD_date() + "%";
		p.setD_date(d_date);
		logger.info("DAOImple_d_date : " + d_date);
		return sqlSession.selectList(NAMESPACE + ".select_date", p);
	}

	// ��¥ �� �˻� �� ����¡
	@Override
	public int datePaging(DiaryBoardPagingVO p) {
		String d_date = p.getD_date() + "%";
		p.setD_date(d_date);
		logger.info("DAOImple_d_date : " + d_date);
		return sqlSession.selectOne(NAMESPACE + ".datePaging", p);
	}

	
} // end DiaryBoardDAOImple{}
