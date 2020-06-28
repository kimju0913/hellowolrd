package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.GalleryBoardPaging;
import com.spring.helloworld.domain.GalleryBoardVO;
import com.spring.helloworld.domain.GlAlbumChange;
import com.spring.helloworld.domain.GlFolderChange;
import com.spring.helloworld.domain.GlFolderDelete;
import com.spring.helloworld.persistence.GalleryBoardDAO;


@Service
public class GalleryBoardServiceImple implements GalleryBoardService {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(GalleryBoardServiceImple.class);
	
	@Autowired
	private GalleryBoardDAO dao ;
	
	@Override
	public List<GalleryBoardVO> read(GalleryBoardPaging p) {
		return dao.select(p);
	}
	
	
	@Override
	public String read_folder(String homeId) {
		return dao.select_folder(homeId);
	}
	
	@Override
	public GalleryBoardVO read(int gl_bno) {
		return dao.select(gl_bno);
	}
	
	@Override
	public int create(GalleryBoardVO vo) {
		
		logger.info("create vo");
		return dao.insert(vo);
		
	}

	@Override
	public int update(GalleryBoardVO vo) {
		return dao.update(vo);
	}
	
	@Override
	   public int update_noImg(GalleryBoardVO vo) {
	      return dao.update_noImg(vo);
	   }

	@Override
	public int delete(int gl_bno) {
		return dao.delete(gl_bno);
	}

	@Override
	public int getTotalNumsOfPaging(GalleryBoardPaging p) { //��������
		return dao.getTotalNumsOfPaging(p);
	}
	
	@Override
	public int delete_f(GlFolderDelete fd) {
		
		return dao.delete(fd);
	}

	@Override
	public int update_fName(GlFolderChange fn) {
		
		return dao.update_fName(fn);
	}


	@Override
	public int updateFList(GlFolderChange fn) {
		
		return dao.update_fList(fn);
	}
	
	@Override
	public int update_changeFile(GlAlbumChange change) {
		logger.info("change imple + " + change.getChangeImgPath() + " +++ " + change.getGl_img());
		return dao.update_changeFile(change);
	}

}