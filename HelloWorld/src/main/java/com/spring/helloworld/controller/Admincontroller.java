package com.spring.helloworld.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.domain.CountVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.service.AnnounceBoardService;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.service.QuestionService;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.util.PageMaker;

@Controller
@RequestMapping(value = "/admin")
public class Admincontroller {
	private static final Logger logger = LoggerFactory.getLogger(Admincontroller.class);

	@Autowired
	MemberService memberservice;

	@Autowired
	QuestionService quesionservice; // 문의

	@Autowired
	AnnounceBoardService anboardservice;// 공지

	@RequestMapping(value = "/admin-main", method = RequestMethod.GET)
	public void adminMaib(Model model) {

	}

	@RequestMapping(value = "/admin-situation", method = RequestMethod.GET)
	public void adminSituation(Model model) {
		int memberCount = (Integer) memberservice.memberCount();

		int announceCount = anboardservice.announceCount();
		int questionTotalCount = quesionservice.totalcount();
		int questionNotAnswer = quesionservice.answerNotcount();
		CountVO vo = new CountVO(memberCount, announceCount, questionTotalCount, questionNotAnswer);

		// memberCount,announceCount,questionTotalCount,questionNotAnswer);
		model.addAttribute("count", vo);

	}

//----------------------------------------------------------------------------
	@RequestMapping(value = "/admin-qna", method = RequestMethod.GET) // 문의
	public void qnalist(Model model, Integer page, Integer perPage) {
		 logger.info(""+page);
		PageCriteria c = new PageCriteria();
		PageMaker maker = new PageMaker();

		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}
		c.setNumsPerPage(10);

		List<QuestionVO> Qlist = quesionservice.read(c);

		maker.setCriteria(c);
		maker.setTotalCount(quesionservice.answerNotcount());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		model.addAttribute("qlist", Qlist);

	}

	@RequestMapping(value = "/admin-qnaEnd", method = RequestMethod.GET) // 문의 답변완료
	public void qnaEndlist(Model model, Integer page, Integer perPage) {
	

		PageCriteria c = new PageCriteria();
		PageMaker maker = new PageMaker();

		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}
		c.setNumsPerPage(10);

		List<QuestionVO> Qlist = quesionservice.readEnd(c);

		maker.setCriteria(c);
		maker.setTotalCount(quesionservice.answercount());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);

		model.addAttribute("qlist", Qlist);
	}

	@RequestMapping(value = "/admin-user", method = RequestMethod.GET) // 회원
	public void memberlist(Model model, Integer page, Integer perPage) {
		PageCriteria c = new PageCriteria();
		PageMaker maker = new PageMaker();

		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}
		c.setNumsPerPage(10);

		List<MemberVO> memberlist = memberservice.SelectUserAll(c);

		maker.setCriteria(c);
		maker.setTotalCount(memberservice.memberCount());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);

		model.addAttribute("memberlist", memberlist);
	}

	@RequestMapping(value = "/admin-announce", method = RequestMethod.GET) // 공지사항
	public void anlist(Model model, Integer page, Integer perPage) {

		

	
		
		
		PageCriteria c = new PageCriteria();
		PageMaker maker = new PageMaker();

		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}
		c.setNumsPerPage(10);

		List<AnnounceBoardVO> list = anboardservice.read(c);

		maker.setCriteria(c);
		maker.setTotalCount(anboardservice.announceCount());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);

		model.addAttribute("anlist", list);

	}
	// -------------------------------------------------------------------------------------------

	@RequestMapping(value = "/qna-answer", method = RequestMethod.GET)
	public void Qnaanswer(int q_bno, Model model) {
		QuestionVO vo = new QuestionVO();

		vo = quesionservice.qnadetail(q_bno);

		model.addAttribute("vo", vo);

	}

	@RequestMapping(value = "/answer-post", method = RequestMethod.POST)
	public String answerupdate(QuestionVO vo, Model model) {

		logger.info("번호" + vo.getQ_bno());
		logger.info("내용" + vo.getQ_answer());

		quesionservice.answerupdate(vo);
		return "redirect:/admin/admin-qnaEnd"; // redirect 재설정
	}

	@RequestMapping(value = "/announce-register", method = RequestMethod.GET)
	public void announceRegister(Model model) {
	}

	@RequestMapping(value = "/announce-register", method = RequestMethod.POST)
	public String announceRegister(AnnounceBoardVO vo, Model model) {

		anboardservice.create(vo);
		return "redirect:/admin/admin-announce";

	}

	@RequestMapping(value = "/admin-userdelete")
	public void adminChangeWindow(MemberVO vo, Model model, String userid) {
		userid = vo.getUserid();
		logger.info("adminChangeWindow () 호출 userid : " + vo.getUserid());
		MemberVO memberId = memberservice.selectMember(userid);
		model.addAttribute("memberId", memberId);
		// List<MemberVO> memberId = memberservice.SelectUserAll();
	}

//   userdelet
	@ResponseBody
	@RequestMapping(value = "/userdelet", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> updateProfContent(@RequestBody MemberVO vo) {

		int result = 0;
		ResponseEntity<Integer> entity = null;
		logger.info(vo.getUserid());

		result = memberservice.delete(vo.getUserid());

		if (result == 1) {
			logger.info("성공");
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else {

			logger.info("실패");
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		}

		return entity;

	} // end updateProfContent
}