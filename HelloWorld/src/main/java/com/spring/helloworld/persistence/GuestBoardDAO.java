package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;







public interface GuestBoardDAO {

	//홈페이지 주인 방명록
	List<GuestBoardVO> select(GuestboardPaging p);
	public abstract int insert(GuestBoardVO vo ); // 방명록 작성
 	public abstract int update(GuestBoardVO vo); // 방묠록 업데이트 *자신의 방명록만 업데이트 가능 
	public abstract int delete(int g_bno );        // 방명록 삭제 *방멸록 주인 or 글작성자 
	public abstract int getTotalNumsOfRecords();  // 총 방명록 겟수 
	public abstract List<GuestBoardVO> select();  //
	public abstract List<GuestBoardVO> select(GuestBoardVO criteria); // vpdlwld cjfl 
	int getTotalNumsOfRecords(GuestboardPaging p );
	
	
	public abstract int replyupdate(GuestBoardVO vo);
	
	public abstract int updateReplycnt(int amount, int bno);  // 방명록 댓글 업데이트 
	
	
	
	
	
	
}
