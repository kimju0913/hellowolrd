package com.spring.helloworld.persistence;

import java.util.Date;
import java.util.List;

import com.spring.helloworld.domain.NoticeBoardPaging;
import com.spring.helloworld.domain.NoticeBoardVO;
import com.spring.helloworld.domain.NtFolderChange;
import com.spring.helloworld.domain.NtFolderDelete;

public interface NoticeBoardDAO {
	public abstract NoticeBoardVO selectDetail(int bno);
	public abstract List<NoticeBoardVO> select(NoticeBoardPaging p);
	public abstract List<NoticeBoardVO> selectByFolder(NoticeBoardPaging p);
	public abstract Date selectFileDate(int bno);
	public abstract int insert(NoticeBoardVO vo);
	public abstract String getFolderList(String userid);
	public abstract int update(NoticeBoardVO vo);
	public abstract int update_f(NoticeBoardVO vo);
	public abstract int update_fName(NtFolderChange fn);
	public abstract int update_fList(NtFolderChange fn);
	public abstract int delete(int nt_bno);
	public abstract int delete(NtFolderDelete fd);
	public abstract int getTotalNumsOfRecords(NoticeBoardPaging p);
	public abstract int getFolderNumsOfRecords(NoticeBoardPaging p);
	public abstract void getNtCnt(int bno);

	
}
