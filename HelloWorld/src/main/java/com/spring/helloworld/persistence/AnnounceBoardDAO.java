package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.util.PageCriteria;


public interface AnnounceBoardDAO {

	public abstract List<AnnounceBoardVO> select(PageCriteria c);

	public abstract int insert(AnnounceBoardVO vo);
	
	public abstract int announceCount();
	
	public abstract int announceUpdate(AnnounceBoardVO vo);
	
	public abstract int announceDelete(int an_bno);
	
}
