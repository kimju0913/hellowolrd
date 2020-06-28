package com.spring.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.persistence.QuestionDAO;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;

@Repository
public class QuestionServiceImple implements QuestionService {

	@Autowired
	private QuestionDAO dao;

	@Override
	public int MyMenuQuestionCount(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return dao.MyMenuQuestionCount(anC);
	}

	@Override
	public int MyQuestionCount(String userid) {
		// TODO Auto-generated method stub
		return dao.MyQuestionCount(userid);
	}

	@Override
	public List<QuestionVO> read(PageCriteria c) {
		// TODO Auto-generated method stub
		return dao.select(c);
	}

	@Override
	public List<QuestionVO> readEnd(PageCriteria c) {
		// TODO Auto-generated method stub
		return dao.selectEnd(c);
	}

	@Override
	public int answercount() {
		// TODO Auto-generated method stub
		return dao.answercount();
	}

	@Override
	public int create(QuestionVO vo) {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}

	@Override
	public int delete(int q_bno) {
		// TODO Auto-generated method stub
		return dao.delete(q_bno);
	}

	@Override
	public List<QuestionVO> read() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public int menutotalcount(String q_menu) {
		// TODO Auto-generated method stub
		return dao.memutotalcount(q_menu);
	}

	@Override
	public List<QuestionVO> readMenu(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return dao.selectMenu(anC);
	}

	@Override
	public List<QuestionVO> MyQuestionread(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return dao.Myselect(anC);
	}

	@Override
	public List<QuestionVO> MyQuestionreadMenu(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return dao.MyMenuselect(anC);
	}

	@Override
	public int answerNotcount() {
		// TODO Auto-generated method stub
		return dao.totalcount();
	}

	@Override
	public int totalcount() {
		// TODO Auto-generated method stub
		return dao.answerNotcount();
	}

	@Override
	public QuestionVO qnadetail(int q_bno) {
		// TODO Auto-generated method stub
		return dao.qnadetail(q_bno);
	}

	@Override
	public int answerupdate(QuestionVO vo) {
		// TODO Auto-generated method stub
		return dao.answerupdate(vo);
	}
}
