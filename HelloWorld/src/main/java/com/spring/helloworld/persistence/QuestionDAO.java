package com.spring.helloworld.persistence;

import java.util.List;
import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;

public interface QuestionDAO {

	List<QuestionVO> select(PageCriteria c);
	List<QuestionVO> selectEnd(PageCriteria c);
	
	
	public int getTotalNumsOfRecords() ;
	
	
	List<QuestionVO> select();
	List<QuestionVO> selectMenu(AnBoardMenuPage anC);
	public abstract int insert(QuestionVO vo);
	public abstract int update(QuestionVO vo); // 방묠록 업데이트 *자신의 방명록만 업데이트 가능 
	public abstract int delete(int q_bno );
	
	List<QuestionVO> Myselect(AnBoardMenuPage anC); //나의 전체 문의 
	List<QuestionVO> MyMenuselect(AnBoardMenuPage anC); // 나의 메뉴 문의
	public abstract int MyQuestionCount(String userid); // 나의 문의 전체 카운트 
	public abstract int MyMenuQuestionCount(AnBoardMenuPage anC); //나의 메뉴문의 카운트 
	
	
	
	
	public abstract int totalcount();     	// 문의 전체 토탈 
	public abstract int answercount();  	 // 답변완료 토탈 
	public abstract int answerNotcount();	//답변대기중 토탈 
	public abstract int memutotalcount(String q_menu); // 메뉴 토탈
	public QuestionVO qnadetail(int q_bno);
	public int answerupdate (QuestionVO vo) ;
	
		
	
	
}
