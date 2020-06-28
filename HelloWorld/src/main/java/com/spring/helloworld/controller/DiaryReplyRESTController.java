package com.spring.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.helloworld.domain.DiaryReplyVO;
import com.spring.helloworld.service.DiaryReplyService;


// RequestMapping
// /replies(POST) : 댓글 추가(insert)
// /replies/all/숫자(GET) : 해당 글번호(bno) 의 모든 댓글 검색(select)
// /replies/숫자(PUT) : 해당 댓글 번호(rno) 의 내용을 수정(update)
// /replies/숫자(DELETE) : 해당 댓글 번호(rno) 의 댓글 삭제(delete)

@RestController
@RequestMapping(value="/replies")
public class DiaryReplyRESTController {
	private static final Logger logger = 
			LoggerFactory.getLogger(DiaryReplyRESTController.class);
	
	// @Requestbody
	// - 클라이어트에서 전송받은 JSON 데이터를 자바 객체로 변환 해주는 annotation
	
	@Autowired
	private DiaryReplyService replyService;
	
	
	@RequestMapping(value = "" , method=RequestMethod.POST)		
	public ResponseEntity<Integer>createReply(@RequestBody DiaryReplyVO vo , HttpSession session) {
		
			String userid = (String)session.getAttribute("loginId");
			String user_name = (String)session.getAttribute("loginName");
			vo.setUserid(userid);
			vo.setUser_name(user_name);
			
			int result = 0;
			result = replyService.create(vo);
			if(result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
			
			
		}

	// 댓글 가져오기
	@RequestMapping(value="/all/{no}", method=RequestMethod.GET)
	public ResponseEntity<List<DiaryReplyVO>> readReplies(
			@PathVariable("no")int d_bno) {
		System.out.println(d_bno + "-------------------------------");
		List<DiaryReplyVO> list = replyService.read(d_bno);
		return new ResponseEntity<List<DiaryReplyVO>>(list, HttpStatus.OK);
	}
	

	// 댓글 update
	@RequestMapping(value="/{no}", method=RequestMethod.PUT)
	public ResponseEntity<String>updateReply(@PathVariable("no") int d_rno, @RequestBody DiaryReplyVO vo) {
		vo.setD_rno(d_rno);
		int result = replyService.update(vo);
		ResponseEntity<String> entity = null;
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		return entity;
	}
	
	
	
	// 댓글 삭제
	@RequestMapping(value="/{no}", method=RequestMethod.DELETE)
	public ResponseEntity<String>deleteReply(@PathVariable("no") int d_rno, @RequestBody DiaryReplyVO vo) {
			logger.info(vo.getD_bno() + "");
		try {
			replyService.delete(d_rno, vo.getD_bno());
			return  new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
			
		}
		
			 
	
	
	}
	
} // end ReplyRESTController {}

