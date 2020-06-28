package com.spring.helloworld.persistence;

import java.util.Date;

import com.spring.helloworld.domain.MainformVO;

public interface MngMinihomeDAO {
	
	public abstract Date getCntDate(String userid);
	public abstract MainformVO selectMainform(String userid);
	public abstract int updateCnt(String userid);
	public abstract int resetCnt(String userid);
	public abstract int updateTitle(MainformVO vo);
	public abstract int updateProfileContent(MainformVO vo);
	public abstract int updateProfilePhoto(MainformVO vo);
	public abstract int updateTapMenu(MainformVO vo);
	public abstract int updateTheme(MainformVO vo);
}
