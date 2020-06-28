package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.DiaryBoardFolderChangeVO;
import com.spring.helloworld.domain.DiaryBoardFolderDeleteVO;
import com.spring.helloworld.domain.DiaryBoardPagingVO;
import com.spring.helloworld.domain.DiaryBoardVO;
import com.spring.helloworld.persistence.DiaryBoardDAO;

@Service // @Component
// 스프링 프레임워크에게 서비스 계층(Service/Business layer)의
// 콤포넌트임을 알려주는 어노테이션
public class DiaryBoardServiceImple implements DiaryBoardService {
	private static final Logger logger = LoggerFactory.getLogger(DiaryBoardServiceImple.class);

	@Autowired
	private DiaryBoardDAO dao;

	// 전체 보기
	@Override
	public List<DiaryBoardVO> readAll(DiaryBoardPagingVO p) {
		logger.info("read_all() 호출 ");
		logger.info("ServiceImple_readAll : " + p);
		return dao.selectAll(p);
	}

	// folder_name 지정헤서 보기
	@Override
	public List<DiaryBoardVO> readByFolder(DiaryBoardPagingVO p) {
		logger.info("read_by_folder() 호출 ");
		logger.info("ServiceImple_readByFolder : " + p);
		return dao.selectByFolder(p);
	}

	@Override
	public DiaryBoardVO read(int d_bno) {
		logger.info("read() 호출 : bno = " + d_bno);
		return dao.select(d_bno);
	}

	@Override
	public int create(DiaryBoardVO vo) {
		logger.info("create() 호출 ");
		logger.info("vo log : " + vo);
		return dao.insert(vo);
	}

	@Override
	public int update(DiaryBoardVO vo) {
		logger.info("update() 호출 ");
		logger.info("ServiceImple_d_content : " + vo.getD_content());
		logger.info("ServiceImple_d_bno : " + Integer.toString(vo.getD_bno()));
		logger.info("ServiceImple_user_name : " + vo.getUser_name());
		return dao.update(vo);
	}

	@Override
	public int delete(int d_bno) {
		logger.info("delete() 호출 ");
		logger.info("ServiceImple_bno : " + d_bno);
		return dao.delete(d_bno);
	}

	@Override
	public int getTotalNumsOfPaging(DiaryBoardPagingVO p) {
		logger.info("ServiceImple_paging: " + p);
		return dao.getTotalNumsOfPaging(p);
	}

	// 전체 보여주기
	@Override
	public int getTotalNumsOfPagingAll(DiaryBoardPagingVO p) {
		logger.info("ServiceImple_paging: " + p);
		return dao.getTotalNumsOfPagingAll(p);
	}

	@Override
	public String readFolderList(String userid) {
		logger.info("ServiceImple_folderList_userid : " + userid);
		return dao.selectByFolderList(userid);
	}

	// 폴더 편집 관련
	@Override
	public int delete_f(DiaryBoardFolderDeleteVO fd) {
		logger.info("ServiceImple_delete_folder : " + fd);
		return dao.delete(fd);
	}

	@Override
	public int update(int d_bno, String d_folder) {
		DiaryBoardVO vo = new DiaryBoardVO(d_bno, d_folder, null, null, null, null);
		logger.info("ServiceImple_update_folder : " + vo.getD_bno() + vo.getD_folder());
		return dao.update_f(vo);
	}

	@Override
	public int update(DiaryBoardFolderChangeVO fn) {
		logger.info("ServiceImple_update_folder_name : " + fn);
		return dao.update_fName(fn);
	}

	@Override
	public int updateFList(DiaryBoardFolderChangeVO fn) {
		logger.info("ServiceImple_update_folder_List : " + fn);

		return dao.update_fList(fn);
	}

	// 달력, 날짜로 검색
	@Override
	public List<DiaryBoardVO> select_date(DiaryBoardPagingVO p) {
		logger.info("ServiceImple_select_date : " + p);
		return dao.select_date(p);
	}

	// 날짜로 검색 했을때 페이징 처리
	@Override
	public int datePaging(DiaryBoardPagingVO p) {
		logger.info("____ServiceImple_paging: " + p.getD_date());
		return dao.datePaging(p);
	}

} // end DiaryBoardServiceImple()
