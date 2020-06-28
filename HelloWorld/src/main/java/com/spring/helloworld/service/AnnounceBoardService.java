package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.util.PageCriteria;

public interface AnnounceBoardService {
	
	public abstract List<AnnounceBoardVO> read(PageCriteria c);
	public abstract int create(AnnounceBoardVO vo);
	
	public abstract int announceUpdate(AnnounceBoardVO vo);
	
	public abstract int announceDelete(int an_bno);
	
	public abstract int announceCount();
	
	
	
}
