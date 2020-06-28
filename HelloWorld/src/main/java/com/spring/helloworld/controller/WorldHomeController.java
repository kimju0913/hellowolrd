package com.spring.helloworld.controller;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.helloworld.domain.FriendsVO;
import com.spring.helloworld.domain.MainformVO;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.service.DiaryBoardService;
import com.spring.helloworld.service.FriendService;
import com.spring.helloworld.service.GalleryBoardService;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.service.MngMinihomeService;
import com.spring.helloworld.service.NoticeBoardService;
import com.spring.helloworld.util.MediaUtil;
import com.spring.helloworld.util.VisitCountUtil;



@Controller
@RequestMapping(value = "/world")
public class WorldHomeController {
	private static final Logger logger = LoggerFactory.getLogger(WorldHomeController.class);
	
	@Resource(name="imgUploadPath")
	private String ImgUploadPath ;
	
	@Autowired
	NoticeBoardService nService;
	
	@Autowired
	MemberService mService;
	
	@Autowired
	GalleryBoardService glService;
	
	@Autowired
	MngMinihomeService MngMiniService;
	
	@Autowired
	FriendService frService;
	
	@Autowired
	DiaryBoardService drService;
	
	@RequestMapping(value = "/mini-home-page", method = RequestMethod.GET)
	public void test(Model model ,HttpServletRequest req) {
		HttpSession session = req.getSession();
		VisitCountUtil vc = new VisitCountUtil();
		String homeid = (String) session.getAttribute("homeId");	
		String homeName = mService.selectMember(homeid).getUser_name();
		String loginId = (String) session.getAttribute("loginId");
		
		Date cntDate = MngMiniService.readCntDate(homeid);
		List<FriendsVO> frList = frService.readFrList(homeid);
		
		try {			
			if(vc.compareDate(cntDate)){
				MngMiniService.resetCnt(homeid);
			}			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(!homeid.equals(loginId)){
			MngMiniService.updateCnt(homeid);
		}
		
		MainformVO mainformVO =  MngMiniService.readMainform(homeid);
		String[] menuList = mainformVO.getTap_menu().split(",");
		
		
		MemberVO memberVO = mService.selectMember(homeid);
		
		String folder_List = nService.folderList(homeid);
		if(folder_List != null || folder_List =="") {
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		}
		
		folder_List = glService.read_folder(homeid);
		if(folder_List != null || folder_List =="") {
			String[] glFolderList = folder_List.split(",");
			model.addAttribute("glFolderList", glFolderList);
		}
		
		folder_List = drService.readFolderList(homeid);
		if(folder_List != null || folder_List =="") {
			String[] drFolderList = folder_List.split(",");
			model.addAttribute("drFolderList", drFolderList);
		}
		logger.info("theme : " + mainformVO.getTheme());
		model.addAttribute("menuList", menuList);
		model.addAttribute("frList", frList);
		model.addAttribute("homeName", homeName);
		model.addAttribute("memberVO", memberVO);
		model.addAttribute("mainformVO", mainformVO);

		
	}
	@RequestMapping(value = "/tap", method = RequestMethod.GET)
	public void tap(Model model) {
		
	}
	
	@RequestMapping(value = "/getntList")
	public String getNtList(Model model, HttpSession session){
		String userid = (String)session.getAttribute("homeId");					
		
		String folder_List = nService.folderList(userid);
		if(folder_List != null || folder_List =="") {
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		}
		
		return "redirect:/world/minihome_test";
		
	}
	
	@RequestMapping(value = "/titleUpdate")
	public void gotitleUpdate(Model model, HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		MainformVO mainformVO =  MngMiniService.readMainform(userid);
		
		model.addAttribute("vo", mainformVO);
	}

	@RequestMapping(value = "/profileUpdate" )
	public void goprofUpdate(Model model, HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		MainformVO mainformVO =  MngMiniService.readMainform(userid);
		
		model.addAttribute("vo", mainformVO);
		
		
		
	}
	
	@RequestMapping(value = "/photoUpdate")
	public void goprofPhoto(Model model, HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		MainformVO mainformVO =  MngMiniService.readMainform(userid);
		
		model.addAttribute("vo", mainformVO);
		
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> display(String fileName , String gl_folder) throws IOException{
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		String filePath = ImgUploadPath +File.separator+fileName ;
		in = new FileInputStream(filePath);
		String extension = filePath.substring(filePath.lastIndexOf(".")+1);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		entity = new ResponseEntity<byte[]>(
				IOUtils.toByteArray(in),
				httpHeaders, 
				HttpStatus.OK); 
		return entity;
	}
	
}
