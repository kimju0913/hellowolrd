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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.helloworld.domain.FrcBoardVO;
import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.persistence.FriendDAO;
import com.spring.helloworld.service.FrcBoardService;
import com.spring.helloworld.service.FriendService;
import com.spring.helloworld.service.MemberService;


@Controller
@RequestMapping(value = "/frcboard") // url경로 : helloworld/board/
public class FrcBoardController {
   private static final Logger logger = 
         LoggerFactory.getLogger(FrcBoardController.class);
   
   @Autowired
   private FrcBoardService frcBoardService;
   
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private FriendService friendService;
   
   @Autowired
   private FriendDAO friendDao;
   
   
   
   @RequestMapping(value = "/frcList", method = RequestMethod.GET)
   public void frcList(Model model,  HttpServletRequest req, HttpSession session) {
      
      String sessiontest = (String)session.getAttribute("homeId");
      
      logger.info("세션테스츠 ===-=-=-=-=-=" + sessiontest);
      
      List<FriendsVO> frList = friendDao.selectFrList(sessiontest);
      model.addAttribute("frList", frList);
      logger.info("fr_id테스트 =-=-=-=" + frList);
      
      String homeId = (String) session.getAttribute("homeId");
   
      
      String loginId = (String) session.getAttribute("loginId");
      logger.info("로그인아이디 : " + loginId);

      
      logger.info("homeId : " + homeId);
      logger.info("loginId : " + loginId);
      
      
//      String userId = (String)session.getAttribute("loginId");
//      List<String> frIdList = friendService.readFrIdList(userId);
//
//      if (frIdList.size() > 0) {
//         System.out.println(frIdList.get(0));
//         model.addAttribute("frIdList", frIdList);
//      }
      


      
      List<FrcBoardVO> list = frcBoardService.read(homeId);
      model.addAttribute("frcBoardList", list);
      
   }// end list()
   
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public void registerGET() {
      logger.info("register() 호출");
   }// end registerGET()
   
   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public String registerPOST(FrcBoardVO vo, RedirectAttributes reAttr, HttpServletRequest request) throws Exception {
      // 세션 아이디를 통한  MemberVO 를 통해서      유저 정보 리턴 
      // MemberService 를 통해서     userInformation(userid) < 활용
      logger.info("registerPOST() 호출");
      HttpSession session = request.getSession();
      
      String loginId = (String) session.getAttribute("loginId");
      logger.info("FrcBoardCreate() loginId" + loginId);
      MemberVO mvo = memberService.userInformation(loginId);
      logger.info("vo.content get : " + vo.getFrc_content());
      int result = 0;
      
      vo.setUserid(loginId);
      vo.setUser_name(mvo.getUser_name());
      
      String homeId = (String) session.getAttribute("homeId");
//      String homeId = "manseon";
      FriendsVO fvo =new FriendsVO();
      
//      String userId = (String)session.getAttribute("userId");
      fvo.setUserid(homeId);
      fvo.setFr_id(loginId);
      fvo=friendService.findnickname(fvo); // 닉네임 가져오기 

      vo.setHome_id(homeId);
      
      logger.info("vo.homeId get : " + homeId);

      vo.setNickname(fvo.getNickname());
      // fr_user_nikname
      
      FrcBoardVO frcCheckVO = frcBoardService.check_already_written(vo);
      
      if(frcCheckVO == null) {
    	  result = frcBoardService.create(vo);
      }else {
    	 frcBoardService.delete(frcCheckVO.getFrc_bno());
    	 result = frcBoardService.create(vo);
    	  
      }
      
     
      
      
      if(result == 1) {
         System.out.println("registerPOST result : " + result);
         reAttr.addFlashAttribute("insert_result", "success");
      }else {
         reAttr.addFlashAttribute("insert_result", "fail");
      }
      
      return "redirect:/frcboard/frcList";
   }// end registerPOST()
   
   public void detail(int frc_bno, Model model) {
      logger.info("detail() 호출 : frc_bno : " + frc_bno);
      FrcBoardVO vo = frcBoardService.read(frc_bno);
      model.addAttribute("FrcBoardVO", vo);
   }// end detail()
   
   @RequestMapping(value = "/update", method = RequestMethod.GET)
   public void update(int frc_bno, Model model) {
      logger.info("update() 호출 frc_bno : " + frc_bno);
      FrcBoardVO vo = frcBoardService.read(frc_bno);
      model.addAttribute("FrcBoardVO", vo);
   }// end update GET
   
   @RequestMapping(value = "/update", method = RequestMethod.POST)
   public String updatePOST(FrcBoardVO vo) {
      logger.info("updatePOST 호출 : frc_bno" + vo.getFrc_bno());
      frcBoardService.update(vo);
      logger.info(vo.getFrc_content());
      
      return "redirect:/frcboard/frcList" ;
   } // end updatePOST
   
   @RequestMapping(value = "/delete", method = RequestMethod.POST)
   public String delete(int frc_bno) {
      logger.info("delete() 호출 : frc_bno" + frc_bno);
       frcBoardService.delete(frc_bno);

      return "redirect:/frcboard/frcList";
   }
   
   
}// end FrcBoardController