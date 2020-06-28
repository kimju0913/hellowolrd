package com.spring.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.helloworld.domain.FriendsRequestVO;
import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.service.FriendService;

@RestController
@RequestMapping(value = "/friend")
public class FriendRestController {
	
	@Autowired
	FriendService fservice;
	
	@RequestMapping(value = "/sendRequest", method = RequestMethod.POST)
	public ResponseEntity<Integer> sendRequest(@RequestBody FriendsRequestVO vo){
		ResponseEntity<Integer> entity = null;
		List<String> checkingList1 = fservice.checkingApplied1(vo);
		List<String> checkingList2 = fservice.checkingApplied2(vo);
		int result = 0;
		
		if(checkingList1.size()>0) {
			for(int i = 0; i < checkingList1.size(); i++) {
				if(checkingList1.get(i).equals("waiting")) {
					result = 100;
					entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
					return entity;
				}
			}
			
			if(checkingList2.size() > 0) {
				for(int i = 0; i < checkingList2.size(); i++) {
					if(checkingList2.get(i).equals("waiting")) {
						result = 100;
						entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
						return entity;
					}
				}
			}
				
				System.out.println(checkingList1.get(0));
				vo.setRequest_status("waiting");
				result = fservice.createRequest(vo);
				entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
	
		}
		
				
		if(checkingList1.size() == 0) {
			if(checkingList2.size() > 0) {
				for(int i = 0; i < checkingList2.size(); i++) {
					if(checkingList2.get(i).equals("waiting")) {
						result = 100;
						entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
						return entity;
					}
				}
			
				System.out.println("어디서 나올까 과연2");
				vo.setRequest_status("waiting");
				result = fservice.createRequest(vo);
				entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
			}
			
			if(checkingList2.size()==0) {
			vo.setRequest_status("waiting");
			result = fservice.createRequest(vo);
			entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
			}
			
		}
		
		return entity;
	
	}
	
	@RequestMapping(value = "/changeNickname", method = RequestMethod.POST)
	public ResponseEntity<Integer> changeNickname(@RequestBody FriendsRequestVO vo){
		ResponseEntity<Integer> entity = null;
		List<String> checkingList1 = fservice.checkingApplied1(vo);
		List<String> checkingList2 = fservice.checkingApplied2(vo);
		int result = 0;
		
		if(checkingList1.size()>0) {
			for(int i = 0; i < checkingList1.size(); i++) {
				if(checkingList1.get(i).equals("Cwaiting")) {
					result = 100;
					entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
					return entity;
				}
			}
			
			if(checkingList2.size() > 0) {
				for(int i = 0; i < checkingList2.size(); i++) {
					if(checkingList2.get(i).equals("Cwaiting")) {
						result = 100;
						entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
						return entity;
					}
				}
			}
				
				System.out.println(checkingList1.get(0));
				vo.setRequest_status("Cwaiting");
				result = fservice.createRequest(vo);
				entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
	
		}
		
				
		if(checkingList1.size() == 0) {
			if(checkingList2.size() > 0) {
				for(int i = 0; i < checkingList2.size(); i++) {
					if(checkingList2.get(i).equals("Cwaiting")) {
						result = 100;
						entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
						return entity;
					}
				}
			
				System.out.println("어디서 나올까 과연2");
				vo.setRequest_status("Cwaiting");
				result = fservice.createRequest(vo);
				entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
			}
			
			if(checkingList2.size()==0) {
			vo.setRequest_status("Cwaiting");
			result = fservice.createRequest(vo);
			entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
			}
			
		}
		
		return entity;
	
	}
	
	
	@RequestMapping(value = "/deleteRequest", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteRequest(@RequestBody FriendsRequestVO vo, HttpSession session){
		String userid = (String)session.getAttribute("loginId");
		vo.setSend_userid(userid);
		
		int result = fservice.deleteRequest(vo);
		System.out.println("delete result : " + result);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteFriend", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteFriend(@RequestBody FriendsVO vo, HttpSession session){
		String userid = (String)session.getAttribute("loginId");
		vo.setUserid(userid);
		
		int result = fservice.deleteFriend(vo);
		System.out.println("delete result : " + result);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/refuse", method = RequestMethod.PUT)
	public ResponseEntity<Integer> refuseRequest(@RequestBody FriendsRequestVO vo, HttpSession session){
		String userid = (String)session.getAttribute("loginId");
		vo.setGet_userid(userid);
		vo.setRequest_status("refused");
		System.out.println(vo.getRequest_status()+ "-------");
		int result = fservice.updateRequest(vo);
		
		System.out.println(result + "====================");
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accept", method = RequestMethod.PUT)
	public ResponseEntity<Integer> acceptRequest(@RequestBody FriendsRequestVO vo, HttpSession session){
		String userid = (String)session.getAttribute("loginId");
		vo.setGet_userid(userid);
		vo.setRequest_status("accepted");
		
		int result = fservice.updateRequest(vo);
		
		if(result == 1) {
			vo = fservice.readRequestAccepted(vo);
			result = fservice.createFreinds(vo);
		}else {
			result = 0;
		}
		
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}  
	
	@RequestMapping(value = "/acceptChange", method = RequestMethod.PUT)
	public ResponseEntity<Integer> acceptChangeRequest(@RequestBody FriendsRequestVO vo, HttpSession session){
		String userid = (String)session.getAttribute("loginId");
		vo.setGet_userid(userid);
		vo.setRequest_status("accepted");
		
		int result = fservice.updateRequest(vo);
		
		if(result == 1) {
			result = fservice.updateFriend1(vo);
			result = fservice.updateFriend2(vo);
		}else {
			result = 0;
		}
		
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	

}
