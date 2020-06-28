package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;

public interface QuestionService {

	List<QuestionVO> read(PageCriteria c);//������ ó��  ���� //
	List<QuestionVO> readEnd(PageCriteria c);
	public abstract int totalcount();	// �亯 ��ü ��Ż 
	public abstract int answercount();	// �Ϸ� ��Ż 
	public abstract int answerNotcount(); // �亯�����  ��Ż 
	public abstract int menutotalcount(String q_menu);
	
	
	List<QuestionVO> read();//��ü�б�
	List<QuestionVO> readMenu(AnBoardMenuPage anC);//��ü�б�
	 
	 
	public abstract int create(QuestionVO vo ); //���� 
	public abstract int delete(int q_bno);  // ����


	List<QuestionVO> MyQuestionread(AnBoardMenuPage anC);  // ���� ��ü  ����
	List<QuestionVO> MyQuestionreadMenu(AnBoardMenuPage anC); // ���� �޴� ����
	public abstract int MyQuestionCount(String userid); // ���� ���� ��ü ī��Ʈ 
	public abstract int MyMenuQuestionCount(AnBoardMenuPage anC); //���� �޴����� ī��Ʈ 
	
	
	
	public QuestionVO qnadetail(int q_bno);
	public int answerupdate(QuestionVO vo);
}


