package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.NoticeReplyVO;

public interface NoticeReplyService {

	public abstract int create(NoticeReplyVO vo);
	public abstract List<NoticeReplyVO> read(int bno);
	public abstract int update(NoticeReplyVO vo);
	public abstract int delete(int rno);
	public abstract int delete_all(int bno);
	
}
