package com.spring.helloworld.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.helloworld.domain.MainformVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.service.MngMinihomeService;
import com.spring.helloworld.util.MediaUtil;

@Controller
@RequestMapping(value = "/user")
	
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@Resource(name = "profileuploadPath")
	private String profileuploadPath;

	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private MngMinihomeService mngservice;
	//---------------------------------------------------------------------------------------

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginpage(String url, Model model) {

		logger.info("loginpage	()");
		model.addAttribute("targetUrl", url);
	}
	//---------------------------------------------------------------------------------------

	@RequestMapping(value = "/profilephoto", method = RequestMethod.GET)
	public void userprofile(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		MemberVO vo = memberservice.userInformation(loginId);
		model.addAttribute("vo", vo);
		
		logger.info("userprofile()");

	}
	//---------------------------------------------------------------------------------------

	@RequestMapping(value = "/user-register", method = RequestMethod.GET)
	public void userregister(Model model) {
		logger.info("user-register()");

	}
	@RequestMapping(value = "/user-update", method = RequestMethod.GET)
	public void userUpdate(Model model ,HttpServletRequest req) {
		logger.info("user-register()");
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		MemberVO vo = memberservice.userInformation(loginId);
		model.addAttribute("user", vo);

	}

	@RequestMapping(value = "/profileupload", method = RequestMethod.POST)
	public String profileupload(MultipartFile file, Model model ,HttpServletRequest req) throws IOException, Exception {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		String formatName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		//MediaType mType = MediaUtil.getMediaType(formatName);
		
		String savedName = saveUploadFile(loginId, formatName, file.getBytes(), req);
		
		MemberVO vo = new MemberVO();
		vo.setUser_photo(savedName);
		vo.setUserid(loginId);
		memberservice.photoupdate(vo);
		
		

		return "redirect:/user/mypage";
	}
	
	//TODO---------------------------------------------------------------------------------------
	private String saveUploadFile(String loginId , String formatName, byte[] fileData ,HttpServletRequest req ) throws Exception {

		//  test
		String savedName =   loginId+"."+formatName;
		logger.info(savedName);
		File target = new File(profileuploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
		}// end saveUploadFile()
	//---------------------------------------------------------------------------------------


	@ResponseBody
	@RequestMapping(value = "/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
       
		logger.info("display file �뱾�뼱�샂");
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtil.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(profileuploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtil.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(profileuploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}
		
		new File(profileuploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	
	
	
	
	
	@ResponseBody
	   @RequestMapping(value = "/user-register", method = RequestMethod.POST)
	   public ResponseEntity<String> register(@RequestBody MemberVO vo,Model model , HttpSession session) {
	      int result = 0;
	      
	      session.removeAttribute("loginCheck");
	      
	      result = memberservice.create(vo);
	      
	      if(result == 1) {
	      String username = vo.getUser_name();
	      vo.setUser_name(username + "님의 미니홈피");
	      result = memberservice.createDefaultOption(vo);
	      logger.info("기본정보 생성 부분 : " + result);
	      }
	      
	      ResponseEntity<String> entity = null;
	      if (result == 4) {
	         entity = new ResponseEntity<String>("success", HttpStatus.OK);
	      } else if(result == 0){
	    	  logger.info("실패시 : " + result);
	         memberservice.delete(vo.getUserid());
	         entity = new ResponseEntity<String>("fail", HttpStatus.OK);
	      }
	      logger.info("entity"+entity);
	      
	      return entity;   
	   }

	@RequestMapping(value = "/login-post", method = RequestMethod.POST)
	public void loginPost(MemberVO vo, Model model, HttpSession session) {
		logger.info("loginPost	()");
		session.removeAttribute("loginCheck");
		MemberVO result = memberservice.loginCheck(vo);
		logger.info("result : " + result);
		model.addAttribute("login_result", result);
	}
	//---------------------------------------------------------------------------------------

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		logger.info("logout() �샇異�");

		HttpSession session = req.getSession();
		session.removeAttribute("loginId");
		session.invalidate();

		return "redirect:/";
	} // end logout()
	//---------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public void Usermypage(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		logger.info("mypage() : 濡쒓렇�씤 �븘�씠�뵒 : " + loginId);
		MemberVO vo = memberservice.userInformation(loginId);
		logger.info(vo.getUser_photo());
		model.addAttribute("member", vo);
	}
	//---------------------------------------------------------------------------------------

	@ResponseBody
	@RequestMapping(value = "/useridselect/{userid}", method = RequestMethod.POST)
	public ResponseEntity<Integer> useridselect(@PathVariable("userid")  String userid, Model model) {
		logger.info("/useridselect�뱾�뼱�샂 ");
		logger.info(userid);
		

		try {
			int result =(Integer) memberservice.useridselect(userid);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}
	//---------------------------------------------------------------------------------------

	//user member update 
	
	@RequestMapping(value = "/update-phoen")
	public String  updatephoen(String phoen, HttpServletRequest req ,MemberVO vo) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");

		logger.info("loginId::"+loginId);
		logger.info("phoen::"+phoen);
		vo.setUser_phone(phoen);
		vo.setUserid(loginId);
		memberservice.phoenupdate(vo);
		
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/update-password")
	public String  updatepassword(String password ,HttpServletRequest req,MemberVO vo) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		logger.info("pw::"+ password);
		vo.setPassword(password);
		vo.setUserid(loginId);
		memberservice.passwordupdate(vo);
		
		return "redirect:/";
	}
	@RequestMapping(value = "/update-email")
	public String  updateemail(String email ,HttpServletRequest req ,MemberVO vo ) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		vo.setUser_email(email);
		vo.setUserid(loginId);
		memberservice.emailupdate(vo);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/minihomeUpdate")
	public void minihomeUpdate(HttpSession session, Model model) {
		String userid = (String)session.getAttribute("loginId");
		
		MainformVO vo = mngservice.readMainform(userid);
		
		String menuList = vo.getTap_menu();
		if(menuList != null) {
		menuList = menuList.replace("diary,", "다이어리 / ");
		menuList = menuList.replace("notice,", "게시판 / ");
		menuList = menuList.replace("photo,", "사진첩 / ");
		menuList = menuList.replace("guest,", "방명록 /");
		
		}
		vo.setTap_menu(menuList);
		
		model.addAttribute("mainformVO", vo);
		
		
	}
	
	
	
	
	
	
	
	
///////////////////
	@RequestMapping(value = "/findId")
	public void findId(){
		logger.info("findid");
	}
	
	@RequestMapping(value = "/findPw")
	public void findPw(){
		
	}
	
	
	
	

}
