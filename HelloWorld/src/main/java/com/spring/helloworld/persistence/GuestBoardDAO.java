package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;







public interface GuestBoardDAO {

	//Ȩ������ ���� ����
	List<GuestBoardVO> select(GuestboardPaging p);
	public abstract int insert(GuestBoardVO vo ); // ���� �ۼ�
 	public abstract int update(GuestBoardVO vo); // �湨�� ������Ʈ *�ڽ��� ���ϸ� ������Ʈ ���� 
	public abstract int delete(int g_bno );        // ���� ���� *���� ���� or ���ۼ��� 
	public abstract int getTotalNumsOfRecords();  // �� ���� �ټ� 
	public abstract List<GuestBoardVO> select();  //
	public abstract List<GuestBoardVO> select(GuestBoardVO criteria); // vpdlwld cjfl 
	int getTotalNumsOfRecords(GuestboardPaging p );
	
	
	public abstract int replyupdate(GuestBoardVO vo);
	
	public abstract int updateReplycnt(int amount, int bno);  // ���� ��� ������Ʈ 
	
	
	
	
	
	
}
