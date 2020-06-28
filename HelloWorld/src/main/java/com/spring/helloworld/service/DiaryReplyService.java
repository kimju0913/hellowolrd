package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.DiaryReplyVO;


public interface DiaryReplyService {
	int create(DiaryReplyVO vo); 
	List<DiaryReplyVO> read(int d_bno);
	int update(DiaryReplyVO vo);
	int delete(int d_rno, int d_bno);
	
	
	
	
} // end ReplyService
