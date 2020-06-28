package com.spring.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.helloworld.domain.GalleryReplyVO;
import com.spring.helloworld.service.GalleryReplyService;





@Controller
@RequestMapping(value = "/reply")
public class GalleryReplyController {
	
	@Autowired
	private GalleryReplyService replyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(
			@RequestBody GalleryReplyVO vo, HttpSession session){
		
		String loginId = (String)session.getAttribute("loginId");
		String loginName = (String)session.getAttribute("loginName");
		
		vo.setUserid(loginId);
		vo.setUser_name(loginName);
	
			int result = replyService.create(vo);
			return new ResponseEntity<Integer>(result,HttpStatus.OK);
		 // Controller - > Service 
		
	}
	
	@RequestMapping(value = "/all/{no}" , method = RequestMethod.GET)
	public ResponseEntity<List<GalleryReplyVO>> readReply(
			@PathVariable("no") int gl_bno){
		List<GalleryReplyVO> list = replyService.read(gl_bno);
		return new ResponseEntity<List<GalleryReplyVO>>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{no}" , method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable("no") int gl_rno, @RequestBody GalleryReplyVO vo ){
		vo.setGl_rno(gl_rno);
		int result = replyService.update(vo);
		ResponseEntity<String> entity = null;
		if(result == 1) {
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("fail",HttpStatus.OK);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{no}" , method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(
			@PathVariable("no") int gl_rno , 
			@RequestBody GalleryReplyVO vo){
		try {
			replyService.delete(gl_rno);
			return new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail",HttpStatus.OK);
		}
	}
	
	
	
}
