package com.spring.helloworld.service;

import java.util.Date;
import java.util.List;

import com.spring.helloworld.domain.NoticeBoardPaging;
import com.spring.helloworld.domain.NoticeBoardVO;
import com.spring.helloworld.domain.NtFolderChange;
import com.spring.helloworld.domain.NtFolderDelete;


public interface NoticeBoardService {
	public abstract int create(NoticeBoardVO vo);
	public abstract NoticeBoardVO read(int bno);
	public abstract List<NoticeBoardVO> read(NoticeBoardPaging p);
	public abstract int getTotalCnt(NoticeBoardPaging p);
	public abstract int update(NoticeBoardVO vo);
	public abstract int delete(int bno);
	public abstract int delete_f(NtFolderDelete fd);
	public abstract int update(int bno, String nt_folder);
	public abstract int update(NtFolderChange fn);
	public abstract int updateFList(NtFolderChange fn);
	public abstract List<NoticeBoardVO> read_by_folder(NoticeBoardPaging p);
	public abstract int getFolderCnt(NoticeBoardPaging p);
	public abstract String folderList(String userid);
	public abstract Date readFileDate(int bno);
}
