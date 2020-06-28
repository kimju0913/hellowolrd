package com.spring.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.spring.helloworld.domain.FrcReplyVO;
import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.service.FrcReplyService;
import com.spring.helloworld.service.FriendService;
import com.spring.helloworld.service.MemberService;

@RestController
@RequestMapping(value = "/frcReplies")
public class FrcReplyRESTController {
   
   private static final Logger logger = LoggerFactory.getLogger(FrcReplyRESTController.class);
   
   @Autowired
   private FrcReplyService frcReplyService;
   
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private FriendService friendService;

   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<Integer> createReply(@RequestBody FrcReplyVO vo, HttpServletRequest request, Model model) {
      logger.info("creatReply() 호출");
      HttpSession session = request.getSession();
      
      
   
      String loginId = (String) session.getAttribute("loginId");
      logger.info("FrcBoardCreate() loginId" + loginId);
      MemberVO mvo = memberService.userInformation(loginId);
      logger.info("vo.content get : " + vo.getFrc_reply_content());
      
      vo.setUserid(loginId);
      vo.setUser_name(mvo.getUser_name());
      
      String homeId = (String) session.getAttribute("homeId");
      FriendsVO fvo =new FriendsVO();
      
      fvo.setUserid(homeId);
      fvo.setFr_id(loginId);
      logger.info(homeId + "홈ID<<  >>로그인ID" + loginId);
      fvo=friendService.findnickname(fvo); // 닉네임 가져오기 

      vo.setHome_id(homeId);
      logger.info("vo.homeId get : " + homeId);

      try {
         logger.info("출발");
         int result;
         if (homeId.equals(loginId)) {
            vo.setNickname(mvo.getUser_name());
            result = frcReplyService.create(vo);
            logger.info("loginId가 homeId일때(주인장) user_name : " + mvo.getUser_name());
         } else {
            vo.setNickname(fvo.getNickname());
            result = frcReplyService.create(vo);
            logger.info("loginId가 homeId가 아닐때 nickname : " + fvo.getNickname());
         }
         logger.info("createReply - result : " + result);
         logger.info("끝 resilt" + result);
         return new ResponseEntity<Integer>(result, HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<Integer>(0, HttpStatus.OK);
      }

   } // end creatReply

   @RequestMapping(value = "/all/{no}", method = RequestMethod.GET)
   public ResponseEntity<List<FrcReplyVO>> readFrcReplise(@PathVariable("no") int frc_bno) {
      List<FrcReplyVO> list = frcReplyService.read(frc_bno);
      return new ResponseEntity<List<FrcReplyVO>>(list, HttpStatus.OK);
   }// end readFrcReplies

   @RequestMapping(value = "/{no}", method = RequestMethod.PUT)
   public ResponseEntity<String> updateReply(@PathVariable("no") int frc_rno, @RequestBody FrcReplyVO vo) {

      vo.setFrc_rno(frc_rno);
      int result = frcReplyService.update(vo);
      ResponseEntity<String> entity = null;
      if (result == 1) {
         logger.info("updateReply - result : " + result);
         entity = new ResponseEntity<String>("success", HttpStatus.OK);
      } else {
         entity = new ResponseEntity<String>("fail", HttpStatus.OK);
      }
      return entity;
   }// end updateReply

   @RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
   public ResponseEntity<String> deleteReply(@PathVariable("no") int frc_rno, @RequestBody FrcReplyVO vo) {
      logger.info(vo.getFrc_bno() + "번 게시판" + vo.getFrc_rno() + "번 댓글 삭제 성공");
      try {
         frcReplyService.delete(frc_rno);
         return new ResponseEntity<String>("success", HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<String>("fail", HttpStatus.OK);
      }
   }
}// end FrcReplyRESTController