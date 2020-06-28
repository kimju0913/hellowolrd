package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.FrcReplyVO;

public interface FrcReplyService {
	int create(FrcReplyVO vo);
	List<FrcReplyVO> read(int frc_bno);
	int update(FrcReplyVO vo);
	int delete(int frc_rno);
}
