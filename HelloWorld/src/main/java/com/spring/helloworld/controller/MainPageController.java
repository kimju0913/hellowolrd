package com.spring.helloworld.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.helloworld.domain.AnnounceBoardVO;
import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.domain.QuestionVO;
import com.spring.helloworld.service.AnnounceBoardService;
import com.spring.helloworld.service.FriendService;
import com.spring.helloworld.service.MainService;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.service.QuestionService;
import com.spring.helloworld.util.AnBoardMenuPage;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.util.PageMaker;

@Controller
@RequestMapping(value = "/main")
public class MainPageController {
   private static final Logger logger = LoggerFactory.getLogger(MainPageController.class);

   @Autowired
   MainService mainService;
   @Autowired
   FriendService fservice;
   @Autowired
   QuestionService questionservice;
   @Autowired
   MemberService memberservice;
   @Autowired
   AnnounceBoardService anboardservice;

   @RequestMapping(value = "/searchFrd")
   public void goToSearchFrd(MemberVO vo ,Model model, HttpSession session) {
      String userid = (String) session.getAttribute("loginId");
      logger.info("찾는사람 이름 : "+vo.getUser_name());
      logger.info("찾는사람 휴대전화 :  "+vo.getUser_phone());
      
      
      List<MemberVO> list =null;
      vo.setUserid(userid);
      if (vo.getUser_name() == null && vo.getUser_phone() == null) {
         
      }else if(vo.getUser_name() == null){
         list = memberservice.searchPhone(vo);
         // 폰 값이 있을 떄 
         
      }else if(vo.getUser_phone() == null){
         // 이름 값이 있을때
         list = memberservice.searchName(vo);
         
      }

      //System.out.println("-----------------" + list.get(0).getUser_name());

      List<String> fr_list = fservice.readFrIdList(userid);

      if (fr_list.size() > 0) {
         System.out.println(fr_list.get(0));
         model.addAttribute("frIdList", fr_list);
      }

      model.addAttribute("memberList", list);

   }

   @RequestMapping(value = "/appliedFrd")
   public void goToAppliedFrd(Model model, HttpSession session) {
      String userid = (String) session.getAttribute("loginId");
      List<FriendsRequestVO> getList = fservice.readGetRequest(userid);
      List<FriendsRequestVO> sendList = fservice.readSendReuest(userid);

      model.addAttribute("getList", getList);
      model.addAttribute("sendList", sendList);

   }

   @RequestMapping(value = "/requestPage")
   public void goRequestWindow(Model model, HttpSession session, String get_userid, String get_user_name) {
      String send_userid = (String) session.getAttribute("loginId");
      String send_user_name = (String) session.getAttribute("loginName");
      System.out.println("-------------------" + get_user_name);
      FriendsRequestVO frVO = new FriendsRequestVO(send_userid, send_user_name, null, get_userid, get_user_name, null,
            null, null, null);

      model.addAttribute("vo", frVO);

   }

   @RequestMapping(value = "/requestChangePage")
   public void goChangeWindow(Model model, HttpSession session, String get_userid, String get_user_name) {
      String send_userid = (String) session.getAttribute("loginId");
      String send_user_name = (String) session.getAttribute("loginName");
      System.out.println("-------------------" + get_user_name);
      FriendsRequestVO frVO = new FriendsRequestVO(send_userid, send_user_name, null, get_userid, get_user_name, null,
            null, null, null);

      model.addAttribute("vo", frVO);

   }

   @RequestMapping(value = "/managingFrd")
   public void goManagingFrd(Model model, HttpSession session) {
      String userid = (String) session.getAttribute("loginId");

      List<FriendsVO> frList = fservice.readFrList(userid);

      model.addAttribute("frList", frList);

   }

   @RequestMapping(value = "/main-center", method = RequestMethod.GET)
	public void MainCenter(Model model, String q_menu, QuestionVO vo, HttpServletRequest req) {

	}
	// Q/A post

	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public void qestioninsert(Model model) {

	}

	@RequestMapping(value = "/qna", method = RequestMethod.POST)
	public String qestioninsertpost(Model model, QuestionVO vo, HttpServletRequest req) {

		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");

		MemberVO mvo = memberservice.userInformation(userid);
		vo.setUserid(mvo.getUserid());
		vo.setUser_name(mvo.getUser_name());
		logger.info( "시크릿 " +vo.getQ_secret());
		String Q_secret = (String) vo.getQ_secret();

		if ( Q_secret==null || Q_secret.equals("")  ) {
			vo.setQ_secret("N");
		}
		logger.info(vo.getQ_secret());

		questionservice.create(vo);

		return "redirect:/main/question";
	}

	// 나의 질문
	@RequestMapping(value = "/myquestion", method = RequestMethod.GET)
	public void Myqestion(Model model, String q_menu, QuestionVO vo, HttpServletRequest req, Integer page, Integer perPage){
		
		PageCriteria c = new PageCriteria();
		AnBoardMenuPage anC =new AnBoardMenuPage();
		PageMaker maker = new PageMaker();
		
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");
		
		List<QuestionVO> qlist = null; 
		c.setNumsPerPage(10);
		if(page != null) {
			c.setPage(page);
			
		}
		if(perPage != null) {
		 	c.setNumsPerPage(perPage);
			
			
		}	
		// ---------------- qna 

		maker.setCriteria(c);
		if (q_menu == null || q_menu.equals("ALL") ||q_menu.equals("") ) {
			
			logger.info("메뉴값 널 ");
			anC= new  AnBoardMenuPage(userid, c.getStart(), c.getEnd());
			
			qlist = questionservice.MyQuestionread(anC);
			maker.setTotalCount(questionservice.MyQuestionCount(userid));
			
		} else {
			logger.info("메뉴값 있음 " +q_menu);
			anC= new  AnBoardMenuPage(q_menu, userid, c.getStart(), c.getEnd());
			logger.info(questionservice.MyMenuQuestionCount(anC)+"뭐니");

			qlist = questionservice.MyQuestionreadMenu(anC);
			maker.setTotalCount(questionservice.MyMenuQuestionCount(anC));
			model.addAttribute("q_menu", q_menu);
		}
		logger.info(""+qlist);
		model.addAttribute("myqestionlist", qlist);
	
		
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
		
		
		
		
		
	
		
	}

	@RequestMapping(value = "/announce", method = RequestMethod.GET)
	public void Announce(Model model, Integer page, Integer perPage) {

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

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public void question1(Model model, String q_menu, QuestionVO vo, HttpServletRequest req, Integer page, Integer perPage) {

		PageCriteria c = new PageCriteria();
		AnBoardMenuPage anC =new AnBoardMenuPage();
		PageMaker maker = new PageMaker();
		c.setNumsPerPage(10);
		HttpSession session = req.getSession(); // �꽭�뀡
		String userid = (String) session.getAttribute("loginId");
		
		List<QuestionVO> qlist = null; // 

		if(page != null) {
			c.setPage(page);
			
		}
		if(perPage != null) {
		 	c.setNumsPerPage(perPage);
			
			
		}	
		

		maker.setCriteria(c);
		if (q_menu == null || q_menu.equals("ALL") ||q_menu.equals("")) {
			logger.info("메뉴값없음에 들어옴 ");
			qlist = questionservice.read(c);
			maker.setTotalCount(questionservice.totalcount());
			
		} else {
			anC= new  AnBoardMenuPage(q_menu, userid, c.getStart(), c.getEnd());
			logger.info("?"+anC.getQ_menu() + anC.getStart());
			qlist = questionservice.readMenu(anC);
			maker.setTotalCount(questionservice.menutotalcount(q_menu));
			model.addAttribute("q_menu", q_menu);
		}
		logger.info(""+qlist);
		model.addAttribute("qlist", qlist);
	
		
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	
	
	}

}
