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
// /replies(POST) : ��� �߰�(insert)
// /replies/all/����(GET) : �ش� �۹�ȣ(bno) �� ��� ��� �˻�(select)
// /replies/����(PUT) : �ش� ��� ��ȣ(rno) �� ������ ����(update)
// /replies/����(DELETE) : �ش� ��� ��ȣ(rno) �� ��� ����(delete)

@RestController
@RequestMapping(value="/replies")
public class DiaryReplyRESTController {
	private static final Logger logger = 
			LoggerFactory.getLogger(DiaryReplyRESTController.class);
	
	// @Requestbody
	// - Ŭ���̾�Ʈ���� ���۹��� JSON �����͸� �ڹ� ��ü�� ��ȯ ���ִ� annotation
	
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

	// ��� ��������
	@RequestMapping(value="/all/{no}", method=RequestMethod.GET)
	public ResponseEntity<List<DiaryReplyVO>> readReplies(
			@PathVariable("no")int d_bno) {
		System.out.println(d_bno + "-------------------------------");
		List<DiaryReplyVO> list = replyService.read(d_bno);
		return new ResponseEntity<List<DiaryReplyVO>>(list, HttpStatus.OK);
	}
	

	// ��� update
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
	
	
	
	// ��� ����
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

