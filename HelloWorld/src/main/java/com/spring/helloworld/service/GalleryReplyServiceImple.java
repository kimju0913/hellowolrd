package com.spring.helloworld.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.helloworld.domain.GalleryReplyVO;
import com.spring.helloworld.persistence.GalleryReplyDAO;


@Service
public class GalleryReplyServiceImple implements GalleryReplyService {



	@Autowired
	private GalleryReplyDAO dao ;
	
	
	@Override
	public int create(GalleryReplyVO vo)  {
		return dao.insert(vo);
	}

	@Override
	public List<GalleryReplyVO> read(int gl_bno) {
		return dao.select(gl_bno);
	}

	@Override
	public int update(GalleryReplyVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(int gl_rno)  {
		return dao.delete(gl_rno);
	}


	


}
