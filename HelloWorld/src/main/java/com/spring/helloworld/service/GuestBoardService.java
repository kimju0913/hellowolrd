package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;








public interface GuestBoardService {
	public abstract List<GuestBoardVO> read();//��ü�б�
	List<GuestBoardVO> read(GuestboardPaging p);
	public abstract int create(GuestBoardVO vo ); //���� 
	public abstract int update(GuestBoardVO vo); // ������Ʈ 
	
	public abstract int delete(int g_bno);
	public abstract int replyupdate(GuestBoardVO vo);
	public int getTotalCnt(GuestboardPaging p);
	
	
}
