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
import com.spring.helloworld.domain.NoticeReplyVO;
import com.spring.helloworld.persistence.NoticeReplyDAOImple;




@RestController
@RequestMapping(value = "/ntReply")
public class NoticeReplyController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(NoticeReplyController.class);
	
	@Autowired
	NoticeReplyDAOImple ntService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(
			@RequestBody NoticeReplyVO vo, HttpSession session){
	
	
		logger.info("hi");
		vo.setUserid((String)session.getAttribute("loginId"));
		vo.setUser_name((String)session.getAttribute("loginName"));
		
		try {
			int result = ntService.insert(vo);
			return new ResponseEntity<Integer>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0,HttpStatus.OK);
		} // Controller - > Service 
		
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<NoticeReplyVO>> readReply(int bno){
		
		List<NoticeReplyVO> list = ntService.select(bno);
		return new ResponseEntity<List<NoticeReplyVO>>(list, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(@PathVariable("no")int rno, @RequestBody NoticeReplyVO vo){
		
		vo.setNt_rno(rno);
		vo.setUserid("test2");
		vo.setUser_name("À¯¼Û");
		
		int result = ntService.update(vo);
		ResponseEntity<String> entity;
		
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;		
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(@PathVariable("no")int rno){
		
		try {
			ntService.delete(rno);
			return new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail",HttpStatus.OK);
		}
		
		
	}
	
	
	
	
}
