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

	
	// ���� ��ü ����¡
	public abstract int getTotalNumsOfPagingAll(DiaryBoardPagingVO p);
	public abstract int getTotalNumsOfPaging(DiaryBoardPagingVO p);
	
	// ��ü ����
	public abstract List<DiaryBoardVO> selectAll(DiaryBoardPagingVO p);
	// ���� �̸�����
	public abstract List<DiaryBoardVO> selectByFolder(DiaryBoardPagingVO p);
	
	
	// folderList �迭��
	public abstract String selectByFolderList(String userid);

	
	// ���� ����
	public abstract int update_f(DiaryBoardVO vo);
	public abstract int update_fName(DiaryBoardFolderChangeVO fn);
	public abstract int update_fList(DiaryBoardFolderChangeVO fn);
	public abstract int delete(DiaryBoardFolderDeleteVO fd);
	
	// �޷� Ŭ�� ������ �� ���� ��������
	public abstract List<DiaryBoardVO> select_date(DiaryBoardPagingVO p);
	// ��¥�� �˻� ������ ����¡
	public abstract int datePaging(DiaryBoardPagingVO p);
	
	
	
} // end BoardDAO{}
