package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.GalleryReplyVO;


public interface GalleryReplyService {
	
	int create(GalleryReplyVO vo) ; //insert
	List<GalleryReplyVO> read(int gl_bno); //select
	int update(GalleryReplyVO vo);
	int delete(int gl_rno);
	
}
