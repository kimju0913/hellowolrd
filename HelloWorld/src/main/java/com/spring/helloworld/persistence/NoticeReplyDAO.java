package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.NoticeReplyVO;

public interface NoticeReplyDAO {
	public abstract int insert(NoticeReplyVO vo);
	public abstract List<NoticeReplyVO> select(int bno);
	public abstract int update(NoticeReplyVO vo);
	public abstract int delete(int rno);
	public abstract int delete_all(int bno);
	
	
}
