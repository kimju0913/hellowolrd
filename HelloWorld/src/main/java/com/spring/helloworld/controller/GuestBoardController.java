package com.spring.helloworld.controller;

import java.io.FileInputStream;
import java.io.InputStream;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.domain.GuestboardPaging;
import com.spring.helloworld.domain.MemberVO;
import com.spring.helloworld.service.GuestBoardService;
import com.spring.helloworld.service.MemberService;
import com.spring.helloworld.util.MediaUtil;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.util.PageMaker;

@Controller
@RequestMapping(value = "/world")
public class GuestBoardController {
   private static final Logger logger = LoggerFactory.getLogger(GuestBoardController.class);

   @Autowired
   private GuestBoardService guestboardservice;
   @Autowired
   private MemberService memberService;
   
   @Resource(name = "profileuploadPath")
   private String profileuploadPath;

   @RequestMapping(value = "/gBoard" ,method = RequestMethod.GET)
   public void guestvoardList(Model model, Integer page, Integer perPage, HttpServletRequest req) {
      HttpSession session = req.getSession();
      String homeId = (String ) session.getAttribute("homeId");
      String loginId = (String) session.getAttribute("loginId"); 
      
      MemberVO homevo =  memberService.userInformation(homeId);
      model.addAttribute("homevo",homevo);
      
      PageCriteria c = new PageCriteria();
      GuestboardPaging p;
      logger.info("page : " +page +" perPage : " +  perPage );
         
      if (page != null) {
         c.setPage(page);
      }
      if (perPage != null) {
         c.setNumsPerPage(perPage);
      }
      logger.info("board 濡� �뱾�뼱�샂 ");
      c.setNumsPerPage(5);
      p = new GuestboardPaging(c.getStart(), c.getEnd(), homeId);
      List<GuestBoardVO> guestlist = guestboardservice.read(p);
      model.addAttribute("guestlist", guestlist); 
      memberService.userInformation(loginId);
      PageMaker maker = new PageMaker();
      maker.setCriteria(c);
      maker.setTotalCount(guestboardservice.getTotalCnt(p));
      maker.setPageData();
      model.addAttribute("maker", maker);
 
      
      
      
      logger.info(loginId);
      MemberVO vo = memberService.userInformation(loginId);
      model.addAttribute("loginvo", vo);
      model.addAttribute("gbtotalCnt", guestboardservice.getTotalCnt(p));
   }
   
   @ResponseBody
   @RequestMapping(value = "/{no}", 
         method = RequestMethod.PUT)
   public ResponseEntity<String> updateboard(
         @PathVariable("no") int rno, 
         @RequestBody GuestBoardVO vo) {
      vo.setG_bno(rno);
      int result = guestboardservice.update(vo);
      ResponseEntity<String> entity = null;
      if (result == 1) {
         entity = new ResponseEntity<String>("success", HttpStatus.OK);
      } else {
         entity = new ResponseEntity<String>("fail", HttpStatus.OK);
      }
      return entity;         
   }   
   
   @ResponseBody
   @RequestMapping(value = "/reply", 
         method = RequestMethod.PUT)
   public ResponseEntity<String> updateboardreply(
      @RequestBody GuestBoardVO vo) {
   
      int result = guestboardservice.replyupdate(vo);
      
      ResponseEntity<String> entity = null;
      if (result == 1) {
         entity = new ResponseEntity<String>("success", HttpStatus.OK);
      } else {
         entity = new ResponseEntity<String>("fail", HttpStatus.OK);
      }
      return entity;         
   }   
   @ResponseBody
   @RequestMapping(value = "/{no}", 
         method = RequestMethod.DELETE)
   public ResponseEntity<String> deleteReply(
         @PathVariable("no") int g_bno) {
      logger.info(g_bno+ "");
      try {
         guestboardservice.delete(g_bno);
         return new ResponseEntity<String>("success", HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<String>("fail", HttpStatus.OK);
      }
   }
   @RequestMapping(value = "/gbRegister" ,method = RequestMethod.POST)
   public String  GuestBoardCreate(GuestBoardVO vo , HttpServletRequest request) {
      logger.info("GuestBoardCreate()�샇異� ");
      HttpSession session = request.getSession();
      String homeId = (String) session.getAttribute("homeId");
      String loginId = (String) session.getAttribute("loginId");
      logger.info("GuestBoardCreate() loginId" +loginId);
      MemberVO mvo = memberService.userInformation(loginId);
      logger.info("vo.content get "+ vo.getG_content());
      
      vo.setUserid(loginId);
      vo.setUser_name(mvo.getUser_name());
      vo.setUser_photo(mvo.getUser_photo());
      vo.setHome_id(homeId);

      if(vo.getG_secret() == null) {
         vo.setG_secret("N");
         
      }
      
      
      guestboardservice.create(vo);
      
      
      return "redirect:/world/gBoard"; // /board
   }
   
   @ResponseBody
   @RequestMapping(value = "/displayFile")
   public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

      InputStream in = null;
      ResponseEntity<byte[]> entity = null;

      logger.info("FILE NAME: " + fileName);

      try {

         String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

         MediaType mType = MediaUtil.getMediaType(formatName);

         HttpHeaders headers = new HttpHeaders();
         try {

            in = new FileInputStream(profileuploadPath + fileName);
         } catch (Exception e) {
            in = new FileInputStream(profileuploadPath + "default.jpg");
         }

         if (mType != null) {
            headers.setContentType(mType);
         } else {

            fileName = fileName.substring(fileName.indexOf("_") + 1);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.add("Content-Disposition",
                  "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
         }
         try {
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
            
         } catch (Exception e) {
            // TODO: handle exception
         }
         
         
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
      } finally {

      }
      return entity;
   }

}