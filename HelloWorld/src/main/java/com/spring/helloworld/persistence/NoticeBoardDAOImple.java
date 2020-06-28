package com.spring.helloworld.persistence;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.helloworld.domain.NoticeBoardPaging;
import com.spring.helloworld.domain.NoticeBoardVO;
import com.spring.helloworld.domain.NtFolderChange;
import com.spring.helloworld.domain.NtFolderDelete;



@Repository
public class NoticeBoardDAOImple implements NoticeBoardDAO{
	
	private static final String NAMESPACE = "com.spring.helloworld.noticeBoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardDAOImple.class);
	
	
	@Autowired
	public SqlSession sqlSession;

	@Override
	public NoticeBoardVO selectDetail(int bno) {
		logger.info("DAO select 실행 : pageCriteria");
		return sqlSession.selectOne(NAMESPACE + ".select_byBno", bno);
	}
	
	@Override
	public void getNtCnt(int nt_bno) {
		logger.info("dao 조회수 불러오기");
		int pluscnt = sqlSession.selectOne(NAMESPACE + ".find_cnt", nt_bno);
		System.out.println(pluscnt + "현재 조회수");
		
		int nt_cnt = pluscnt + 1;
		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setNt_cnt(nt_cnt);
		vo.setNt_bno(nt_bno);
		System.out.println(nt_cnt);
		sqlSession.update(NAMESPACE + ".plus_cnt", vo);
		System.out.println("조회수 없데이트 성공");
	}
	
	@Override
	public List<NoticeBoardVO> select(NoticeBoardPaging p) {
		logger.info("DAO select 실행 : pageCriteria");
		return sqlSession.selectList(NAMESPACE + ".paging_all", p);
	}


	@Override
	public int getTotalNumsOfRecords(NoticeBoardPaging p) {
		logger.info("DAO get total num 호출 ");
		
		return sqlSession.selectOne(NAMESPACE + ".total_count", p);
	}
	
	@Override
	public int getFolderNumsOfRecords(NoticeBoardPaging p) {
		
		return sqlSession.selectOne(NAMESPACE+ ".total_count_byFolder", p);
	}
	
	@Override
	public List<NoticeBoardVO> selectByFolder(NoticeBoardPaging p) {
		logger.info("DAO select 실행 : 폴더");
		return sqlSession.selectList(NAMESPACE + ".paging_folder", p);
	}

	@Override
	public int insert(NoticeBoardVO vo) {
		logger.info("DAO Insert 호출");
		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
		return result;
	}

	@Override
	public int update(NoticeBoardVO vo) {
		logger.info("DAO Update 호출");
		int result = sqlSession.update(NAMESPACE + ".update", vo);
		return result;
	}

	@Override
	public int delete(int nt_bno) {
		logger.info("DAO delete호출");
		int result = sqlSession.delete(NAMESPACE + ".delete", nt_bno);
		return result;
	}

	@Override
	public String getFolderList(String userid) {
		logger.info("폴더 리스트호출 in DAO");
		
		String folderList = sqlSession.selectOne(NAMESPACE + ".get_folderList", userid);
		return folderList;
	}

	@Override
	public int update_f(NoticeBoardVO vo) {
		logger.info("update DAO imple");
		return sqlSession.update(NAMESPACE + ".update_folder", vo);
	}
	
	

	@Override
	public Date selectFileDate(int bno) {
		logger.info("DAO find Date 호출");
		
		return sqlSession.selectOne(NAMESPACE + ".get_file_date", bno);
	}

	@Override
	public int update_fName(NtFolderChange fn) {
		logger.info("dao change folder name 호출 ");
		
		return sqlSession.update(NAMESPACE + ".update_fName", fn);
	}

	@Override
	public int update_fList(NtFolderChange fn) {
		return sqlSession.update(NAMESPACE + ".update_fList", fn);
	}

	@Override
	public int delete(NtFolderDelete fd) {
		
		return sqlSession.delete(NAMESPACE + ".delete_f", fd);
	}

	

	
	

	
	

	

	

	
}
