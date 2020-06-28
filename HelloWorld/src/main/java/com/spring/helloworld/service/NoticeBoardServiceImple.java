package com.spring.helloworld.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.NoticeBoardPaging;
import com.spring.helloworld.domain.NoticeBoardVO;
import com.spring.helloworld.domain.NtFolderChange;
import com.spring.helloworld.domain.NtFolderDelete;
import com.spring.helloworld.persistence.NoticeBoardDAO;



@Service
public class NoticeBoardServiceImple implements NoticeBoardService{

	private static Logger logger = LoggerFactory.getLogger(NoticeBoardServiceImple.class);
	
	
	@Autowired
	public NoticeBoardDAO nDao;
	

	@Override
	public int create(NoticeBoardVO vo) {
		logger.info("service create 호출");
		return nDao.insert(vo);
	}

	@Override
	public NoticeBoardVO read(int bno) {
		logger.info("service read detail 호출");
		nDao.getNtCnt(bno);
		return nDao.selectDetail(bno);
	}
	
	@Override
	public List<NoticeBoardVO> read(NoticeBoardPaging p) {
		logger.info("service read 호출 크리테리");
		
		return nDao.select(p);
	}
	
	@Override
	public List<NoticeBoardVO> read_by_folder(NoticeBoardPaging p) {
		
		return nDao.selectByFolder(p);
	}

	@Override
	public int update(NoticeBoardVO vo) {
		logger.info("service update 호출");
		return nDao.update(vo);
	}
	
	

	@Override
	public int delete(int bno) {
		logger.info("service delete 호출");
		return nDao.delete(bno);
	}

	@Override
	public int getTotalCnt(NoticeBoardPaging p) {
		logger.info("gettotalCnt Service 호출");
		return nDao.getTotalNumsOfRecords(p);
	}
	
	@Override
	public int getFolderCnt(NoticeBoardPaging p) {
		
		return nDao.getFolderNumsOfRecords(p);
	}

	@Override
	public String folderList(String userid) {
		logger.info("서비스 폴더 목록 호출 ");
		return nDao.getFolderList(userid);
	}

	@Override
	public int update(int bno, String nt_folder) {
		logger.info("서비스 폴더 수정 호출 ");
		NoticeBoardVO vo = new NoticeBoardVO(bno, nt_folder, null, null, null, null, null, 0, 0, null);
		logger.info("service : " + vo.getNt_bno()+ vo.getNt_folder());
		
		return nDao.update_f(vo);
	}

	@Override
	public Date readFileDate(int bno) {
		logger.info("service findDate. bno : " + bno);
		return nDao.selectFileDate(bno);
	}

	@Override
	public int update(NtFolderChange fn) {
		
		return nDao.update_fName(fn);
	}

	@Override
	public int updateFList(NtFolderChange fn) {
		
		return nDao.update_fList(fn);
	}

	@Override
	public int delete_f(NtFolderDelete fd) {
		
		return nDao.delete(fd);
	}

	

	

	
}
