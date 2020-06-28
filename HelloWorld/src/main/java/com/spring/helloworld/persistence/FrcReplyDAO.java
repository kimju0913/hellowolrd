package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.FrcReplyVO;

public interface FrcReplyDAO {
	int insert(FrcReplyVO vo);
	List<FrcReplyVO> select(int frc_bno);
	int update(FrcReplyVO vo);
	int delete(int frc_rno);
	
}
