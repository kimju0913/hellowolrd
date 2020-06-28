package com.spring.helloworld.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;

@Repository
public class QuestionDAOImple implements QuestionDAO {

	private static Logger logger = LoggerFactory.getLogger(QuestionDAOImple.class);

	private static final String NAMESPACE = "com.spring.helloworld.QuestionMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int MyMenuQuestionCount(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".My_menu_total_count" ,anC);
	}

	@Override
	public int MyQuestionCount(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".My_total_count",userid);
	}

	@Override
	public int getTotalNumsOfRecords() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<QuestionVO> select(PageCriteria c) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_page", c);
	}

	@Override
	public int delete(int q_bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionVO> selectEnd(PageCriteria c) {
		// TODO Auto-generated method stubselect_page_not_null
		return sqlSession.selectList(NAMESPACE + ".select_page_not_null", c);
	}

	@Override
	public int insert(QuestionVO vo) {
		// TODO Auto-generated method stub
		logger.info("insert");
		return sqlSession.insert(NAMESPACE + ".insertquestion", vo);
	}

	@Override
	public List<QuestionVO> select() {

		return sqlSession.selectList(NAMESPACE + ".select_question");
	}

	@Override
	public List<QuestionVO> selectMenu(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		logger.info("sleectMenu:");
		return sqlSession.selectList(NAMESPACE + ".select_q_menu", anC);
	}

	@Override
	public int memutotalcount(String q_menu) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".menu_total_count", q_menu);
	}

	@Override
	public int update(QuestionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionVO> MyMenuselect(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_my_Question_By_menu", anC);
	}

	@Override
	public List<QuestionVO> Myselect(AnBoardMenuPage anC) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_my_Question_All", anC);
	}

	@Override
	public int answerNotcount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".question_count_not_answer");
	}

	@Override
	public int answercount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".total_count_answer");
	}

	@Override
	public int totalcount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".question_count");
	}

	@Override
	public QuestionVO qnadetail(int q_bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_bno", q_bno);
	}

	@Override
	public int answerupdate(QuestionVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".question_update", vo);
	}
}
