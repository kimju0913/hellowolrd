package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.GalleryBoardPaging;
import com.spring.helloworld.domain.GalleryBoardVO;
import com.spring.helloworld.domain.GlAlbumChange;
import com.spring.helloworld.domain.GlFolderChange;
import com.spring.helloworld.domain.GlFolderDelete;

public interface GalleryBoardService {
	
	public abstract List<GalleryBoardVO> read(GalleryBoardPaging p);
	public abstract String read_folder(String homeId);
	
	public abstract GalleryBoardVO read(int gl_bno);
	
	public abstract int create(GalleryBoardVO vo);
	public abstract int update(GalleryBoardVO vo);
	public abstract int update_noImg(GalleryBoardVO vo);
	public abstract int delete(int gl_bno);
	
	public abstract int getTotalNumsOfPaging(GalleryBoardPaging p);
	
	public abstract int delete_f(GlFolderDelete fd);
	
	public abstract int update_fName(GlFolderChange fn);
	public abstract int updateFList(GlFolderChange fn);
	public abstract int update_changeFile(GlAlbumChange change);
}
