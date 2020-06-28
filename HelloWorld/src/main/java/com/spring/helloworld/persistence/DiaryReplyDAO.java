package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.DiaryReplyVO;

public interface DiaryReplyDAO {
	int insert(DiaryReplyVO vo);
	List<DiaryReplyVO> select(int d_bno);
	int update(DiaryReplyVO vo);
	int delete(int d_rno);
	
	
	
} // end ReplyDAO
