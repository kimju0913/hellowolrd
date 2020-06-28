package com.spring.helloworld.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.helloworld.domain.NoticeBoardPaging;
import com.spring.helloworld.domain.NoticeBoardVO;
import com.spring.helloworld.domain.NtFolderChange;
import com.spring.helloworld.domain.NtFolderDelete;
import com.spring.helloworld.service.NoticeBoardService;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.util.PageMaker;



@Controller
@RequestMapping(value = "/ntBoard")
public class NoticeBoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(NoticeBoardController.class);
	
	@Autowired
	private NoticeBoardService noticeBoardService;
	
	@RequestMapping("/ntList")
	public void list(Model model, Integer page, Integer perPage, String folder, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		PageCriteria c = new PageCriteria();
		c.setNumsPerPage(10);
		NoticeBoardPaging p;
		logger.info("page : " +page +" perPage : " +  perPage );
		String homeId = (String) session.getAttribute("homeId");
		if(homeId == null || homeId == "") {
			homeId = "";
		}
		List<NoticeBoardVO> list = null;
		
		if(page != null) {
			c.setPage(page);
			
		}
		if(perPage != null) {
		 	c.setNumsPerPage(perPage);
			
			
		}		
		p = new NoticeBoardPaging(c.getStart(), c.getEnd(), homeId, folder);
		logger.info(folder + "폴더 폴더 폴더 ");
		
		if(folder == null || folder == "") {
			list = noticeBoardService.read(p);
		}else {
			list = noticeBoardService.read_by_folder(p);
		}
		
		String folder_List = noticeBoardService.folderList(homeId);
		if(folder_List != null || folder_List =="") {
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		}
		model.addAttribute("ntList", list);
		
		logger.info("c ="+c);
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		if(folder == null || folder == "") {
			maker.setTotalCount(noticeBoardService.getTotalCnt(p));
		}else {
			maker.setTotalCount(noticeBoardService.getFolderCnt(p));
		}
		maker.setPageData();
		
		model.addAttribute("maker", maker);
		
		model.addAttribute("folder_pager", folder);
		
	}
	
	
	@RequestMapping(value = "/ntList", method = RequestMethod.POST)
	public void listPost(Model model, Integer page, Integer perPage, String folder, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		
		PageCriteria c = new PageCriteria();
		NoticeBoardPaging p;
		String homeId = (String)session.getAttribute("homeId");
		String folder_List = noticeBoardService.folderList(homeId);
		String[] ntFolderList = folder_List.split(",");
		List<NoticeBoardVO> list = null;
		
		
		if(page != null) {
			c.setPage(page);
		}
		if(perPage != null) {
			c.setNumsPerPage(perPage);
		}	
		p = new NoticeBoardPaging(c.getStart(), c.getEnd(), homeId, folder);
		
		
		
		if(folder == null || folder == "") {
			list = noticeBoardService.read(p);
		}else {
			list = noticeBoardService.read_by_folder(p);
		}
		
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		if(folder == null || folder == "") {
			maker.setTotalCount(noticeBoardService.getTotalCnt(p));
		}else {
			maker.setTotalCount(noticeBoardService.getFolderCnt(p));
		}
		maker.setPageData();
		
		model.addAttribute("maker", maker);
		model.addAttribute("folder_pager", folder);
		model.addAttribute("ntFolderList", ntFolderList);
		model.addAttribute("ntList", list);
		
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void getRegist(Model model, String homeId, HttpServletRequest req) {
		logger.info("regist Get 호출");
		
		HttpSession session = req.getSession();
		homeId = (String)session.getAttribute("loginId");
		
		String folder_List = noticeBoardService.folderList(homeId);
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String postRegist(NoticeBoardVO vo, MultipartFile[] files, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<String> fileNames = new ArrayList<String>();
		
		int result = 0;
		String nt_file = "";
		String userid = (String)session.getAttribute("loginId");
		String user_name = (String)session.getAttribute("loginName");
		
		
			logger.info(files[0].getOriginalFilename() + " 파일길이 : " + files.length);
			logger.info(vo.getNt_content() + "tlqkf!!!!");
		
		// 파일이 있는 경우 
		if(files[0].getOriginalFilename() != "") {
			
			logger.info("uploadPost2() 호출 : 파일 개수 = " +files.length);
		
			if(files.length > 1) {
			for(MultipartFile f : files) {
				fileNames.add(saveUploadFile(f, userid) + " ");
			}
			
			nt_file = String.join("," , fileNames);
			} else {
				nt_file = saveUploadFile(files[0], userid);
			}
		}
		
		
		logger.info("regist Post 호출" + nt_file);
		
		
		logger.info(nt_file);
		vo = new NoticeBoardVO(0, vo.getNt_folder(), userid, user_name, vo.getNt_title(), vo.getNt_content(), null, 0, 0, nt_file);
		
		result = noticeBoardService.create(vo);
		
		if(result == 1) {
			System.out.println("글 등록 성공");
			return "redirect:/ntBoard/ntList";
		}
		
		return "regist";
		
	}
	
	@RequestMapping(value = "/detail")
	public void showDetail(Model model, int bno, HttpSession session) {
		logger.info("cotroller detail 호출");
		
		String homeId = (String)session.getAttribute("homeId");
		logger.info( homeId + " : detail Session");
		
		System.out.println(bno + " : bno 체크");
		NoticeBoardVO vo = noticeBoardService.read(bno);
		
		String folder_List = noticeBoardService.folderList(homeId);
		if(folder_List != null || folder_List =="") {
			String[] ntFolderList = folder_List.split(",");
			model.addAttribute("ntFolderList", ntFolderList);
			}
		String[] nt_files = null  ;
		List<String> fileList = new ArrayList<>();
		String[] files = null;
		
		if(vo.getNt_file()!=null) {
			nt_files = vo.getNt_file().split(",");
			
			for(int i = 0; i < nt_files.length; i++) {
				files = nt_files[i].split("__");
				fileList.add(files[1]);
			}
		}
		
	
		
		System.out.println(vo.getNt_content()+ "|" + vo.getNt_title());
		model.addAttribute("ntBoardVO", vo);
		
		model.addAttribute("nt_file", nt_files);
		model.addAttribute("fileList", fileList);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void goToUpdate(Model model, NoticeBoardVO vo, HttpSession session) {
		logger.info("update Get 호출");
		logger.info("bno" + vo.getNt_bno());
		logger.info("content : " + vo.getNt_content());
//		String userid = "test";
		NoticeBoardVO vo_test =noticeBoardService.read(vo.getNt_bno());
		String folder_List = noticeBoardService.folderList((String)session.getAttribute("loginId"));
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		model.addAttribute("ntBoardVo", vo_test);
		
	}

	@RequestMapping(value = "/afterUpdate", method = RequestMethod.POST)
	public String postUpdate(NoticeBoardVO vo, RedirectAttributes redirect) {
		logger.info("update Post 호출");
		int result = 0;
		
		result = noticeBoardService.update(vo);
		
		if(result == 1) {
			System.out.println("글 수정 성공");
			return "redirect:/ntBoard/ntList";
		}
		
		return "redirect:/ntBoard/ntList";
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Integer[] nt_bnos, Model model) {
		logger.info("delete post 호출");
		
		
		for(int x : nt_bnos) {
			noticeBoardService.delete(x);
		}

		return "redirect:/ntBoard/ntList";
		
	}
	
	@RequestMapping(value = "/moving_folder")
	public void makeMoveWindow(Integer[] nt_bnos, Model model, HttpSession session) {
		for(int x : nt_bnos) {
			logger.info(x + "|");
		}
		String homeId = (String)session.getAttribute("homeId");
		String folder_List = noticeBoardService.folderList(homeId);
		if(folder_List != null || folder_List == "") {
		String[] ntFolderList = folder_List.split(",");
		model.addAttribute("ntFolderList", ntFolderList);
		}
		model.addAttribute("nt_bnos", nt_bnos);
		
		
		
	}
	
	@RequestMapping(value = "update_folder", method = RequestMethod.GET)
	@ResponseBody
	public Integer updateFolder(@RequestParam(value = "nt_bnos[]")List<Integer> nt_bnos, String nt_folder) {
		logger.info("업데이트 폴더호출");
		System.out.println(nt_bnos.get(0) + nt_folder);
		int result = 0;
		for(int i = 0; i < nt_bnos.size(); i++) {
			logger.info(i + " : bno");
			result = noticeBoardService.update(nt_bnos.get(i), nt_folder);
			logger.info("업데이트 성 공 ! " + i);
			
		}
		
		
		
		return result;
	}
	
	@RequestMapping("/fileDown")
    public ModelAndView download(@RequestParam("filecol")String filecol, int nt_bno, HttpSession session){
        String homeId = (String)session.getAttribute("homeId");
        logger.info("@@@@@@@@@@@@@@@FileDown(1) START@@@@@@@@@@@@@@@" + homeId);
        logger.info("nt_bno : " + nt_bno);
       
        String uploadedFolder =  homeId + File.separator;
        
       
        
        String fullPath = uploadPath + uploadedFolder + filecol;
         
        File file = new File(fullPath);
        
        
        logger.info("@@@@@@@@@@@@@@@FileDown(1) END@@@@@@@@@@@@@@@");
         
        return new ModelAndView("download", "downloadFile", file);
    }
	
	@RequestMapping(value = "/managingFolder", method = RequestMethod.GET)
	public void manageFolder(String userid, Model model, HttpSession session) {
		
		String homeId = (String)session.getAttribute("homeId");
		String folder_List = noticeBoardService.folderList(homeId);
		String[] ntFolderList = folder_List.split(",");
		
		model.addAttribute("ntFolderList", ntFolderList);
		
	}
	
	@RequestMapping(value = "/managingFolder", method = RequestMethod.POST)
	public void updateFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model, HttpSession session) {
		logger.info(beforeChangeF + "-> 변경 전 폴더이름 | " + afterChangeF + "-> 병경 후 이름");
		String folder_List = String.join(",", changedFolder);
		String homeId = (String)session.getAttribute("homeId");
		
		NtFolderChange fn;
		if(beforeChangeF != null && afterChangeF != null){	
			
			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new NtFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			noticeBoardService.update(fn);
		}else {
			fn = new NtFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			//TODO :수정말고 걍 리스트만 추가 
		}
			
			noticeBoardService.updateFList(fn);
		
		logger.info(folder_List + "변경 되었는가아아아아");
		String folderList[] = folder_List.split(",");
		
	
		model.addAttribute("ntFolderList", folderList);

	}
	
	@RequestMapping(value = "/MngFolderdelete", method = RequestMethod.POST)
	public String deleteFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model, String[] deletedFolder,
			HttpSession session){
		String folder_List = String.join(",", changedFolder);
		
		String homeId = (String)session.getAttribute("homeId");
		for(String x : deletedFolder) {
			NtFolderDelete fd = new NtFolderDelete(homeId, x);
			noticeBoardService.delete_f(fd);
		}
		
		NtFolderChange fn;
		if(beforeChangeF != null && beforeChangeF != "" && afterChangeF != null && afterChangeF != ""){	
			
			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new NtFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			noticeBoardService.update(fn);
		}else {
			fn = new NtFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			//TODO :수정말고 걍 리스트만 추가 
		}
			
			noticeBoardService.updateFList(fn);
		
		logger.info(folder_List + "변경 되었는가아아아아");
		String folderList[] = folder_List.split(",");
		
	
		model.addAttribute("ntFolderList", folderList);
		
		return "redirect:/ntBoard/managingFolder";
	}


	
	
	
	private String saveUploadFile(MultipartFile file, String userid) {
		//UUID : 업로드 하는 파일 이름이 중복되지 않도록 
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "__" + file.getOriginalFilename();
		
		String savePath = getUploadPath(uploadPath, userid);
		
		File target = new File(uploadPath + File.separator + savePath,
				savedName);
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			logger.info("파일 저장성공 : " + savedName);
			return savedName;
		} catch (IOException e) {
			logger.error("파일 저장 실패 ");
			e.printStackTrace();
			return null;
		}
		
	}// saveUploadFile()
	
	private static String getUploadPath(String uploadPath, String userid) {
		
		String filePath =
				 File.separator
				+ userid;
		makeDir(uploadPath, userid);

		return filePath;
	}
	
	private static void makeDir(String uploadPath, String path) {
		File dirPath = new File(uploadPath, path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
			logger.info(dirPath.getPath() + " successfully created.");
		} else {
			logger.info(dirPath.getPath() + " already exists.");
		}
	}
	
	
}
