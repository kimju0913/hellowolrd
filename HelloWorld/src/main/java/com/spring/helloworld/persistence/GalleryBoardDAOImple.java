package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.GalleryBoardPaging;
import com.spring.helloworld.domain.GalleryBoardVO;
import com.spring.helloworld.domain.GlAlbumChange;
import com.spring.helloworld.domain.GlFolderChange;
import com.spring.helloworld.domain.GlFolderDelete;

@Repository
public class GalleryBoardDAOImple implements GalleryBoardDAO {
	
	private static final String NAMESPACE = 
			"com.spring.helloworld.GalleryBoardMapper";
	
	@Autowired 
	private SqlSession sqlSession; 
	
	@Override
	public List<GalleryBoardVO> select(GalleryBoardPaging p) {
		List<GalleryBoardVO> list ;
		if(p.getFolder_name() == null || p.getFolder_name() == "" ) {
		list =  sqlSession.selectList(NAMESPACE + ".paging", p);
	    }else {
	    list = sqlSession.selectList(NAMESPACE + ".paging_folder", p);
     	}
		return list;
	}
	
	@Override
	public String select_folder(String userid) {
		
		return sqlSession.selectOne(NAMESPACE+".select_folder", userid);
	}

	@Override
	public GalleryBoardVO select(int gl_bno) {
		
		return sqlSession.selectOne(NAMESPACE+".select_by_gl_bno", gl_bno);
	}
	
	@Override
	public int insert(GalleryBoardVO vo) {
		
		return sqlSession.insert(NAMESPACE+".insert", vo);
	}

	@Override
	public int update(GalleryBoardVO vo) {
		return sqlSession.update(NAMESPACE+".update", vo);
	}
	
	@Override
	public int update_noImg(GalleryBoardVO vo) {
	    return sqlSession.update(NAMESPACE+".update_noImg_change", vo);
	}

	@Override
	public int delete(int gl_bno) {
		return sqlSession.delete(NAMESPACE+".delete", gl_bno);
	}
	
	@Override
	public int getTotalNumsOfPaging(GalleryBoardPaging p) {
		int result = 0 ; 
	if(p.getFolder_name() == null || p.getFolder_name() == "" ) {
		result = sqlSession.selectOne(NAMESPACE + ".total_count", p);
	} else {
		result = sqlSession.selectOne(NAMESPACE + ".total_count_folder", p);
	 } 
	return result ;
	}

	@Override
	public int delete(GlFolderDelete fd) {
		return sqlSession.delete(NAMESPACE + ".delete_f", fd);
	}
	
	@Override
	public int update_fName(GlFolderChange fn) {
		return sqlSession.update(NAMESPACE + ".update_fName", fn);
	}
	
	@Override
	public int update_fList(GlFolderChange fn) {
		return sqlSession.update(NAMESPACE+ ".update_fList", fn);
	}
	
	@Override
	public int update_changeFile(GlAlbumChange change) {
		return sqlSession.update(NAMESPACE+ ".update_changePath",change);
	}
	
}
