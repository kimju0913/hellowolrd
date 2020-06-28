package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.DiaryBoardFolderChangeVO;
import com.spring.helloworld.domain.DiaryBoardFolderDeleteVO;
import com.spring.helloworld.domain.DiaryBoardPagingVO;
import com.spring.helloworld.domain.DiaryBoardVO;


// CRUD(CREATE, READ, UPDATE, DELETE)
public interface DiaryBoardService {
	
	// ��ü ����
	public abstract List<DiaryBoardVO> readAll(DiaryBoardPagingVO p);
	// folder_name �����ؼ� ����
	public abstract List<DiaryBoardVO> readByFolder(DiaryBoardPagingVO p);
	
	// �迭��
	public abstract String readFolderList(String userid);
	
	public abstract DiaryBoardVO read(int d_bno);
	public abstract int create(DiaryBoardVO vo); 
	public abstract int update(DiaryBoardVO vo);
	public abstract int delete(int d_bno);
	
	
	// paging ó��
	public abstract int getTotalNumsOfPagingAll(DiaryBoardPagingVO p);
	public abstract int getTotalNumsOfPaging(DiaryBoardPagingVO p);

	// ���� ����
	public abstract int delete_f(DiaryBoardFolderDeleteVO fd);
	public abstract int update(int d_bno, String d_folder);
	public abstract int update(DiaryBoardFolderChangeVO fn);
	public abstract int updateFList(DiaryBoardFolderChangeVO fn);
	
	// �޷� ����
	public abstract List<DiaryBoardVO> select_date(DiaryBoardPagingVO p);
	// ��¥�� ����¡	
	public abstract int datePaging(DiaryBoardPagingVO p);
	
	
}











