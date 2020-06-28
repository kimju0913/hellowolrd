package com.spring.helloworld.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.helloworld.domain.GalleryBoardPaging;
import com.spring.helloworld.domain.GalleryBoardVO;
import com.spring.helloworld.domain.GlAlbumChange;
import com.spring.helloworld.domain.GlFolderChange;
import com.spring.helloworld.domain.GlFolderDelete;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.service.GalleryBoardService;
import com.spring.helloworld.util.FileAdministration;
import com.spring.helloworld.util.GLFileUploadUtil;
import com.spring.helloworld.util.MediaUtil;

import com.spring.helloworld.util.PageMaker;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(GalleryController.class);
	
	@Resource(name="imgUploadPath")
	private String ImgUploadPath ;
	
	
	private String photoAlbum = "Photoalbum";
	
	@Autowired
	private GalleryBoardService service; 
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public void main(Model model , Integer page , Integer perPage , String folder_name , HttpSession session ) {
		
		String homeId = (String)session.getAttribute("homeId");
		PageCriteria c = new PageCriteria();
		GalleryBoardPaging p;
		
		if(page != null) {
			c.setPage(page);
		}
		if(perPage != null) {
			c.setNumsPerPage(perPage);
		}
		
		 
		//String userid = (String)session.getAttribute("loginId");
		//homeId = (String)session.getAttribute("loginId");
		
		
		p = new GalleryBoardPaging(folder_name, homeId, c.getStart(), c.getEnd());
		List<GalleryBoardVO> glList = service.read(p);
		folderList(homeId); 
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		maker.setTotalCount(service.getTotalNumsOfPaging(p));
		maker.setPageData();
		
		model.addAttribute("pageMaker", maker);
		model.addAttribute("glList", glList);
		model.addAttribute("folderList", folderList(homeId));
		model.addAttribute("folder_name", folder_name);
		 
	}

	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public void registerGet(Model model, HttpSession session) {
		String homeId = (String)session.getAttribute("homeId");
		folderList(homeId);
		
        model.addAttribute("folderList", folderList(homeId));
	}
   
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	 public String registerPost(Model model ,GalleryBoardVO vo , MultipartFile file, RedirectAttributes reAttr, HttpSession session) throws IOException {
			String homeId = (String)session.getAttribute("homeId");
			String user_name = (String)session.getAttribute("loginName");
			String sum = null;
		   //   String gl_folder = vo.getGl_folder();
			sum = GLFileUploadUtil.saveUploadedFile(ImgUploadPath, file.getOriginalFilename(), file.getBytes() , homeId);
		    String realPath = sum ;
		    logger.info("register POST " + realPath);
		    vo = new GalleryBoardVO(0, vo.getGl_folder(), homeId , vo.getGl_title(), realPath, vo.getGl_content(), null, user_name);
		    int result = service.create(vo);
		     if(result ==1) { // DB insert 
		         reAttr.addFlashAttribute("insert_result", "success");
		     }else { //DB insert 
		         reAttr.addFlashAttribute("insert_result", "fail");
		     }
		      return "redirect:/gallery/list";
	}

	@RequestMapping(value = "/update" , method = RequestMethod.GET)
	 public void updateGet(int gl_bno , Model model ,HttpSession session ) {
		String homeId = (String)session.getAttribute("homeId");
		folderList(homeId);
        model.addAttribute("folderList", folderList(homeId));
		GalleryBoardVO vo = service.read(gl_bno);
		model.addAttribute("galleryBoardVO", vo);
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
    public String updatePost(GalleryBoardVO vo ,RedirectAttributes reAttr , MultipartFile file , Model model , HttpSession session) throws IOException {
      String savedName = null;
      String homeId = (String)session.getAttribute("homeId");
      vo.setUser_name((String)session.getAttribute("loginName"));
      int result = 0;
      if(file.getSize() == 0) {
         result = service.update_noImg(vo);
      }else {
    	  savedName = GLFileUploadUtil.saveUploadedFile(ImgUploadPath, file.getOriginalFilename(), file.getBytes() , homeId );
          
          String checkImgPath = ImgUploadPath + vo.getGl_img() ;
          logger.info("check IMG == " + checkImgPath);
          File deleteImg = new File(checkImgPath);
          FileAdministration.deleteDirectoryAndFiles(deleteImg);
       
          vo.setGl_img(savedName);
          result = service.update(vo);
      }
      if(result == 1 ) {
         reAttr.addFlashAttribute("update_result", "success");
      }else {
         reAttr.addFlashAttribute("update_result", "fail");
      }
      
      return "redirect:/gallery/list" ;
      
   }

	
	@RequestMapping(value = "/delete" , method = RequestMethod.POST)
	public String deletePost(RedirectAttributes reAttr ,GalleryBoardVO vo) {
	      int result = service.delete(vo.getGl_bno());
	      if(result == 1) {
	         String checkImgPath = ImgUploadPath + vo.getGl_img() ;
	         logger.info("check IMG == " + checkImgPath);
	         File deleteImg = new File(checkImgPath);
	         FileAdministration.deleteDirectoryAndFiles(deleteImg);
	         reAttr.addFlashAttribute("delete_result", "success");
	         
	      }else {
	    	  
	      }
	      return "redirect:/gallery/list";
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
		logger.info("======== gl " + entity );
		return entity;
	}
	
	
	
	@RequestMapping(value = "/managingFolder", method = RequestMethod.GET)
	public void manageFolder(Model model, HttpSession session) {
		String homeId = (String)session.getAttribute("homeId");
		//String homeId = (String)session.getAttribute("homeId");
		//String folder_List = noticeBoardService.folderList(homeId);
		//String[] ntFolderList = folder_List.split(",");
		folderList(homeId);
		model.addAttribute("glFolderList", folderList(homeId));
		
	}
	
	@RequestMapping(value = "/managingFolder", method = RequestMethod.POST)
	public void updateFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model, HttpSession session) {
		String folder_List = String.join(",", changedFolder);
		String homeId = (String)session.getAttribute("homeId");
		//file_name
		String beforeFilePath = ImgUploadPath+homeId+File.separator+photoAlbum + File.separator+ beforeChangeF;
		logger.info("managingFolder before : " + beforeFilePath);
		String afterFilePath = ImgUploadPath+homeId+File.separator+photoAlbum + File.separator+afterChangeF;
		logger.info("managingFolder after : " + afterFilePath);
		
		if(beforeChangeF != afterChangeF) {
		FileAdministration.moveFile(beforeFilePath, afterFilePath);
		GlAlbumChange change ;
		
		List<File> changePath = FileAdministration.getDirFileList(beforeFilePath);
		if(changePath != null) {
			logger.info("changePath size === " + changePath.size());
			 for (int i=0; i<changePath.size(); i++){
			   String fileName = changePath.get(i).getName();
			   logger.info("changePath . fileName ==  " + fileName);
			   String changeImgPath =  "/" + homeId +   "/" + photoAlbum +  "/"+ afterChangeF + "/"+ fileName ; 
			   String gl_img =   "/" + homeId +   "/" + photoAlbum +  "/"+ beforeChangeF+  "/" +fileName ;
			   logger.info("changePath imgPath == "  + changeImgPath);
			   logger.info("changePath Test == " + gl_img);
			   
			   change = new GlAlbumChange(changeImgPath, gl_img);
			   service.update_changeFile(change);
			   File del = new File(beforeFilePath);
			   logger.info("Filde del = " + del);
			   FileAdministration.deleteDirectoryAndFiles(del);
			  }
			}
		}

		GlFolderChange fn;
		if(beforeChangeF != null && afterChangeF != null){	
			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new GlFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			service.update_fName(fn);
		}else {
			fn = new GlFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
		}
		service.updateFList(fn);
		String folderList[] = folder_List.split(",");
		model.addAttribute("glFolderList", folderList);
		
		
	}
	
	
	@RequestMapping(value = "/MngFolderdelete", method = RequestMethod.POST)
	public String deleteFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model, String[] deletedFolder,
			HttpSession session){
		String homeId = (String)session.getAttribute("homeId");
		String folder_List = String.join(",", changedFolder);
		for(int i = 0 ; i < deletedFolder.length ; i ++) {
		String path = ImgUploadPath+homeId+File.separator+ photoAlbum + File.separator + deletedFolder[i];
		
		logger.info("=============delete Path " + path );
		File targetFolder = new File(path);
		
		FileAdministration.deleteDirectoryAndFiles(targetFolder);
		}
		//String homeId = (String)session.getAttribute("homeId");
		for(String x : deletedFolder) {
			GlFolderDelete fd = new GlFolderDelete(homeId, x);
			service.delete_f(fd);
		}
		
		GlFolderChange fn;
		if(beforeChangeF != null && beforeChangeF != "" && afterChangeF != null && afterChangeF != ""){	
			
			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new GlFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			service.update_fName(fn);
		}else {
			fn = new GlFolderChange(homeId, folder_List, beforeChangeF, afterChangeF);
			
		}
			
			service.updateFList(fn);
		
	
		String folderList[] = folder_List.split(",");
		
	
		model.addAttribute("ntFolderList", folderList);
		
		
		
		return "redirect:/gallery/managingFolder";
	}


	private String[] folderList(String homeId) {
		
		
		
		String folderSelect = service.read_folder(homeId);
		System.out.println(folderSelect + "---------------------folderList");
		if(folderSelect != null) {
			
		String [] folderList = folderSelect.split(",");
		return folderList;
	}
		return null;
  }
	
	
}
