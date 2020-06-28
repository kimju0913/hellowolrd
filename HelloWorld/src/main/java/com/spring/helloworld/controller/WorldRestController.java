package com.spring.helloworld.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.spring.helloworld.domain.MainformVO;
import com.spring.helloworld.service.GalleryBoardService;
import com.spring.helloworld.service.MngMinihomeService;
import com.spring.helloworld.util.GLFileUploadUtil;

@RestController
@RequestMapping(value = "/worldRest")
public class WorldRestController {

	@Resource(name = "imgUploadPath")
	private String ImgUploadPath;
	@Autowired
	MngMinihomeService miniService;

	@Autowired
	GalleryBoardService service;

	@RequestMapping(value = "/title", method = RequestMethod.PUT)
	public ResponseEntity<Integer> updateReply(@RequestBody MainformVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("loginId");
		System.out.println("=================== title 호출");
		int result = 0;
		ResponseEntity<Integer> entity = null;

		vo.setUserid(userid);
		result = miniService.updateTitle(vo);

		if (result == 1) {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		}

		return entity;

	} // end updatetitle

	@RequestMapping(value = "/profContent", method = RequestMethod.PUT)
	public ResponseEntity<Integer> updateProfContent(@RequestBody MainformVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("loginId");
		int result = 0;
		ResponseEntity<Integer> entity = null;

		vo.setUserid(userid);
		result = miniService.updateProfileContent(vo);

		if (result == 1) {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		}

		return entity;

	} // end updateProfContent

	@RequestMapping(value = "/profPhoto", method = RequestMethod.POST)
	public ResponseEntity<String> uploadAjaxPost(@RequestBody MultipartFile file, HttpSession session, MainformVO vo)
			throws IOException {
		// 파일 하나만 저장
		int result = 0;
		String userid = (String) session.getAttribute("loginId");
		ResponseEntity<String> entity = null;
		String savedName = null;
		vo.setUserid(userid);

		if (file.getSize() == 0) {
			System.out.println("========== + " + vo.getProfile_photo());
			result = miniService.updateProfilePhoto(vo);

		} else {
			savedName = GLFileUploadUtil.saveUploadedFile(ImgUploadPath, file.getOriginalFilename(), file.getBytes(),
					userid);
			vo.setProfile_photo(savedName);
			result = miniService.updateProfilePhoto(vo);
		}

		if (result == 1) {
			entity = new ResponseEntity<String>(savedName, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>(savedName, HttpStatus.OK);
		}
		return entity;

	}

	@RequestMapping(value = "/tapMenu", method = RequestMethod.PUT)
	public ResponseEntity<Integer> updateTabMenu(@RequestBody MainformVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("loginId");
		int result = 0;
		ResponseEntity<Integer> entity = null;

		vo.setUserid(userid);
		result = miniService.updateTapMenu(vo);

		if (result == 1) {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		}

		return entity;

	}

	@RequestMapping(value = "/theme", method = RequestMethod.PUT)
	public ResponseEntity<Integer> updateTheme(@RequestBody MainformVO vo, HttpSession session) {

		String userid = (String) session.getAttribute("loginId");
		int result = 0;
		ResponseEntity<Integer> entity = null;

		vo.setUserid(userid);
		result = miniService.updateTheme(vo);

		if (result == 1) {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		}

		return entity;

	}

}// end restController
