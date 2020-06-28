package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.GalleryReplyVO;


public interface GalleryReplyDAO {
	
	public abstract int insert(GalleryReplyVO vo);
	
	public abstract List<GalleryReplyVO> select(int gl_bno);
	
	public abstract int update(GalleryReplyVO vo);
	
	public abstract int delete(int gl_rno);
	
	
}
