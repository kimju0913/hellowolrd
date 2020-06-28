package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.DiaryBoardFolderChangeVO;
import com.spring.helloworld.domain.DiaryBoardFolderDeleteVO;
import com.spring.helloworld.domain.DiaryBoardPagingVO;
import com.spring.helloworld.domain.DiaryBoardVO;

public interface DiaryBoardDAO {
	
	public abstract DiaryBoardVO select(int d_bno);
	
	public abstract int insert(DiaryBoardVO vo);

	public abstract int update(DiaryBoardVO vo);

	public abstract int delete(int d_bno);

	
	// 폴더 전체 페이징
	public abstract int getTotalNumsOfPagingAll(DiaryBoardPagingVO p);
	public abstract int getTotalNumsOfPaging(DiaryBoardPagingVO p);
	
	// 전체 보기
	public abstract List<DiaryBoardVO> selectAll(DiaryBoardPagingVO p);
	// 폴더 이름으로
	public abstract List<DiaryBoardVO> selectByFolder(DiaryBoardPagingVO p);
	
	
	// folderList 배열로
	public abstract String selectByFolderList(String userid);

	
	// 폴더 편집
	public abstract int update_f(DiaryBoardVO vo);
	public abstract int update_fName(DiaryBoardFolderChangeVO fn);
	public abstract int update_fList(DiaryBoardFolderChangeVO fn);
	public abstract int delete(DiaryBoardFolderDeleteVO fd);
	
	// 달력 클릭 했을때 글 정보 가져오기
	public abstract List<DiaryBoardVO> select_date(DiaryBoardPagingVO p);
	// 날짜로 검색 했을때 페이징
	public abstract int datePaging(DiaryBoardPagingVO p);
	
	
	
} // end BoardDAO{}
