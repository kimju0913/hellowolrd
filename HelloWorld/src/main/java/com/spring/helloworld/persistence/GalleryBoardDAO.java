package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.GalleryBoardPaging;
import com.spring.helloworld.domain.GalleryBoardVO;
import com.spring.helloworld.domain.GlAlbumChange;
import com.spring.helloworld.domain.GlFolderChange;
import com.spring.helloworld.domain.GlFolderDelete;

public interface GalleryBoardDAO {
	
	
	public abstract List<GalleryBoardVO> select(GalleryBoardPaging p); //��ü
	public abstract String select_folder(String userid); //���� ����
	
	
	public abstract GalleryBoardVO select(int gl_bno);
	
	public abstract int insert(GalleryBoardVO vo) ; 
	
	public abstract int update(GalleryBoardVO vo);
	public abstract int update_noImg(GalleryBoardVO vo);
	public abstract int delete(int gl_bno) ; 
	
	//����¡ ó��
	public abstract int getTotalNumsOfPaging(GalleryBoardPaging p);
	
	//���� ����
	public abstract int delete(GlFolderDelete fd);
	
	//���� ������Ʈ
	public abstract int update_fName(GlFolderChange fn);
	public abstract int update_fList(GlFolderChange fn);
	public abstract int update_changeFile(GlAlbumChange change);
	
}
