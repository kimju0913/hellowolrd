package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;

public interface QuestionService {

	List<QuestionVO> read(PageCriteria c);//페이지 처리  문의 //
	List<QuestionVO> readEnd(PageCriteria c);
	public abstract int totalcount();	// 답변 전체 토탈 
	public abstract int answercount();	// 완료 토탈 
	public abstract int answerNotcount(); // 답변대기중  토탈 
	public abstract int menutotalcount(String q_menu);
	
	
	List<QuestionVO> read();//전체읽기
	List<QuestionVO> readMenu(AnBoardMenuPage anC);//전체읽기
	 
	 
	public abstract int create(QuestionVO vo ); //생성 
	public abstract int delete(int q_bno);  // 삭제


	List<QuestionVO> MyQuestionread(AnBoardMenuPage anC);  // 나의 전체  문의
	List<QuestionVO> MyQuestionreadMenu(AnBoardMenuPage anC); // 나의 메뉴 문의
	public abstract int MyQuestionCount(String userid); // 나의 문의 전체 카운트 
	public abstract int MyMenuQuestionCount(AnBoardMenuPage anC); //나의 메뉴문의 카운트 
	
	
	
	public QuestionVO qnadetail(int q_bno);
	public int answerupdate(QuestionVO vo);
}


