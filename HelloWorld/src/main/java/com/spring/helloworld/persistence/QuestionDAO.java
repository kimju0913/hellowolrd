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
	public abstract int update(QuestionVO vo); // �湨�� ������Ʈ *�ڽ��� ���ϸ� ������Ʈ ���� 
	public abstract int delete(int q_bno );
	
	List<QuestionVO> Myselect(AnBoardMenuPage anC); //���� ��ü ���� 
	List<QuestionVO> MyMenuselect(AnBoardMenuPage anC); // ���� �޴� ����
	public abstract int MyQuestionCount(String userid); // ���� ���� ��ü ī��Ʈ 
	public abstract int MyMenuQuestionCount(AnBoardMenuPage anC); //���� �޴����� ī��Ʈ 
	
	
	
	
	public abstract int totalcount();     	// ���� ��ü ��Ż 
	public abstract int answercount();  	 // �亯�Ϸ� ��Ż 
	public abstract int answerNotcount();	//�亯����� ��Ż 
	public abstract int memutotalcount(String q_menu); // �޴� ��Ż
	public QuestionVO qnadetail(int q_bno);
	public int answerupdate (QuestionVO vo) ;
	
		
	
	
}
