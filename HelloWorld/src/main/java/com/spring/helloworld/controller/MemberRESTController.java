package com.spring.helloworld.controller;


import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.util.MediaUtil;

@RestController
@RequestMapping(value = "/find")
public class MemberRESTController {
	
	@Resource(name = "profileuploadPath")
	private String profileuploadPath;
	
	@Autowired
	MemberService mService ;
	
	
	@RequestMapping(value = "/id", method = RequestMethod.POST)
	public ResponseEntity<String> findId(
			@RequestBody MemberVO vo){
		// @RequestBody 
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
			String result = null;
		
			if(vo.getUser_email() == null || vo.getUser_email() == "") {
				result = mService.findIdByPhone(vo);
			}
			if(vo.getUser_phone() == null || vo.getUser_phone() == "") {
				System.out.println("-=================logger email로 찾을때" + vo.getUser_email());
				
				result = mService.findIdByEmail(vo);
				System.out.println(result  + "----------------결과값");
			}

			return new ResponseEntity<String>(result,HttpStatus.OK);
		// Controller - > Service 
		
	}
	
	@RequestMapping(value = "/checkid", method = RequestMethod.GET)
	public ResponseEntity<String> checkingId(
			String userid){
		// @RequestBody 
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
			System.out.println("==-=-=-=-=-=-=-=-=-=-=" +userid);
			String result = null;
			result = mService.checkId(userid);
			

			return new ResponseEntity<String>(result,HttpStatus.OK);
		// Controller - > Service 
		
	}
	
	@RequestMapping(value = "/pw", method = RequestMethod.POST)
	public ResponseEntity<String> findPw(
			@RequestBody MemberVO vo){
		// @RequestBody 
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
			String result = null;
		
			if(vo.getUser_email() == null || vo.getUser_email() == "") {
				result = mService.findPwByPhone(vo);
			}
			if(vo.getUser_phone() == null || vo.getUser_phone() == "") {
				System.out.println("-=================logger email로 찾을때" + vo.getUser_email());
				
				result = mService.findPwByEmail(vo);
				System.out.println(result  + "————————결과값");
			}

			return new ResponseEntity<String>(result,HttpStatus.OK);
		// Controller - > Service 
		
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST)
	public ResponseEntity<String> uploadAjaxPost(@RequestBody MultipartFile file , HttpSession session , HttpServletRequest req) throws Exception{
	
		String loginId = (String) session.getAttribute("loginId");
		session = req.getSession();
		
		String formatName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		MediaType mType = MediaUtil.getMediaType(formatName);
		
		String savedName = saveUploadFile(loginId, formatName, file.getBytes(), req);
		
		MemberVO vo = new MemberVO();
		vo.setUser_photo(savedName);
		vo.setUserid(loginId);
		mService.photoupdate(vo);	
		ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
		
		
	}
	private String saveUploadFile(String loginId , String formatName, byte[] fileData ,HttpServletRequest req ) throws Exception {

		//  test
		String savedName =   loginId+"."+formatName;
		File target = new File(profileuploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
		}// end saveUploadFile()
	

}// end REST Controller