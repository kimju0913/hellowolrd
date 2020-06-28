package com.spring.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.helloworld.domain.DiaryBoardFolderChangeVO;
import com.spring.helloworld.domain.DiaryBoardFolderDeleteVO;
import com.spring.helloworld.domain.DiaryBoardPagingVO;
import com.spring.helloworld.domain.DiaryBoardVO;
import com.spring.helloworld.util.PageCriteria;
import com.spring.helloworld.util.PageMaker;
import com.spring.helloworld.service.DiaryBoardService;

@Controller
@RequestMapping(value = "/diaryboard") //
public class DiaryBoardController {
	private static final Logger logger = LoggerFactory.getLogger(DiaryBoardController.class);
//	
	@Autowired
	private DiaryBoardService DiaryBoardService;

	// ��ü ����
	@RequestMapping(value = "/diarylist", method = RequestMethod.GET)
	public void list(Model model, Integer page, Integer perPage, String folder_name, HttpServletRequest req,
			String d_date , HttpSession session) {
		logger.info("list() ȣ��");
		
		String homeId = (String)session.getAttribute("homeId");
		
		// ����¡
		DiaryBoardPagingVO p;

		// Paging ó��
		PageCriteria c = new PageCriteria();
		c.setNumsPerPage(3);
		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}

		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		


		p = new DiaryBoardPagingVO(homeId, folder_name, c.getStart(), c.getEnd());
		logger.info("p_userid : " + p.getUserid());
		logger.info("p_folder_name : " + folder_name);

		if (folder_name == null || folder_name == "") {
	         logger.info("d_date : " + d_date);
	         // d_date �� ���� null �� �ƴ� ���
	         if (d_date == null || d_date == "") {
	            List<DiaryBoardVO> list = DiaryBoardService.readAll(p);
	            logger.info("readAll_p : " + p);
	            model.addAttribute("diary_board", list);
	            maker.setTotalCount(DiaryBoardService.getTotalNumsOfPagingAll(p)); // ��ü ������ ������
	            maker.setPageData();
	            
	            logger.info("maker : " + maker);
	            model.addAttribute("pageMaker", maker);
	            model.addAttribute("folder", folder_name);
	            
	            // folderList �� split ���� �ɰ���
	            String folderList = DiaryBoardService.readFolderList(homeId);
	            String[] DiaryFolderList = folderList.split(",");
	            logger.info("DiaryFolderList : " + DiaryFolderList);
	            model.addAttribute("DiaryFolderList", DiaryFolderList);

	         } else {
	            logger.info("���� �� d_date : " + d_date);
	            String finalDate = d_date.replace('-', '/').substring(2); // �޾ƿ� String ��¥ ������ �� "-" �� "/" �� replace ���ġ, substring���� ���� 2020 ���� �տ� 20 �� ����
	            p = new DiaryBoardPagingVO(homeId, folder_name, finalDate, c.getStart(), c.getEnd());
	            List<DiaryBoardVO> list = DiaryBoardService.select_date(p);
	            logger.info("d_date : " + d_date);
	            model.addAttribute("diary_board", list);
	            maker.setTotalCount(DiaryBoardService.datePaging(p)); // d_date ���� ����¡����
	            maker.setPageData();

	            logger.info("maker : " + maker);
	            model.addAttribute("pageMaker", maker);
	            model.addAttribute("folder", folder_name);
	            model.addAttribute("d_date", d_date);
	            
	            // folderList �� split ���� �ɰ���
	            String folderList = DiaryBoardService.readFolderList(homeId);
	            String[] DiaryFolderList = folderList.split(",");
	            logger.info("DiaryFolderList : " + DiaryFolderList);
	            model.addAttribute("DiaryFolderList", DiaryFolderList);
	            
	         }
	         
	      } else if (folder_name != null || folder_name != "") {
	         List<DiaryBoardVO> list = DiaryBoardService.readByFolder(p);
	         logger.info("readByFolder_p : " + p);
	         model.addAttribute("diary_board", list);
	         maker.setTotalCount(DiaryBoardService.getTotalNumsOfPaging(p));
	         maker.setPageData();

	         logger.info("maker : " + maker);
	         model.addAttribute("pageMaker", maker);
	         model.addAttribute("folder", folder_name);
	         
	         // folderList �� split ���� �ɰ���
	         String folderList = DiaryBoardService.readFolderList(homeId);
	         String[] DiaryFolderList = folderList.split(",");
	         logger.info("DiaryFolderList : " + DiaryFolderList);
	         model.addAttribute("DiaryFolderList", DiaryFolderList);
	      }

		

	} // end list()

	

	@RequestMapping(value = "/diaryregister", method = RequestMethod.GET)
	public void registerGET(Model model, HttpServletRequest req , HttpSession session) {
		logger.info("registerGET() ȣ��");

		String homeId = (String)session.getAttribute("homeId");

		String folderList = DiaryBoardService.readFolderList(homeId);
		String[] DiaryFolderList = folderList.split(",");

		logger.info("DiaryFolderList : " + DiaryFolderList);
		model.addAttribute("DiaryFolderList", DiaryFolderList);

	} // end registerGET()

	@RequestMapping(value = "/diaryregister", method = RequestMethod.POST)
	public String registerPOST(DiaryBoardVO vo, RedirectAttributes reAttr, Model model, HttpServletRequest req , HttpSession session) {


		String userid = (String)session.getAttribute("loginId");
		String user_name = (String)session.getAttribute("loginName");

		vo = new DiaryBoardVO(vo.getD_bno(), userid, user_name, vo.getD_folder(), vo.getD_content(), vo.getD_date());

		logger.info("registerPOST() ȣ��");
		logger.info("�ۼ��� : " + vo.getUser_name());
		logger.info("���� : " + vo.getD_content());
		logger.info(" userid: " + vo.getUserid());
		logger.info("d_folder : " + vo.getD_folder());

		int result = DiaryBoardService.create(vo);

		logger.info(" " + result);
		if (result == 1) { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "success");
		} else { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "fail");
		}

		return "redirect:/diaryboard/diarylist"; // /board/list ��η� �̵�(get���)
	} // end registerPOST()

	// ������Ʈ
	@RequestMapping(value = "/diaryupdate", method = RequestMethod.GET)
	public void update(int d_bno, Model model , HttpSession session) {
		logger.info("udpateGET() ȣ��");
		DiaryBoardVO vo = DiaryBoardService.read(d_bno);
		logger.info("controller_update_d_bno : " + d_bno);
		logger.info("controller_update_vo : " + vo);
		model.addAttribute("DiaryBoardVO", vo);

		String userid = (String)session.getAttribute("homeId");
		String folderList = DiaryBoardService.readFolderList(userid);
		String[] DiaryFolderList = folderList.split(",");

		logger.info("DiaryFolderList : " + DiaryFolderList);
		model.addAttribute("DiaryFolderList", DiaryFolderList);

	}

	@RequestMapping(value = "/diaryupdate", method = RequestMethod.POST)
	public String update(DiaryBoardVO vo, RedirectAttributes reAttr) {
		logger.info("diaryUpdate POST() ȣ�� ");
		
		int result = DiaryBoardService.update(vo);
		logger.info("update folder = " + vo.getD_folder());
		logger.info("result : " + result);
		logger.info("contoller_diaryupdate_vo : " + vo);
		if (result == 1) {
			reAttr.addFlashAttribute("update_result", "success");
		} else {
			reAttr.addFlashAttribute("update_reslut", "fail");
		}

		return "redirect:/diaryboard/diarylist";

	}

	@RequestMapping(value = "/diarydelete", method = RequestMethod.POST)
	public String delete(int d_bno) {

		int result = DiaryBoardService.delete(d_bno);
		logger.info("delete_result : " + result);
		logger.info("controller_delete_d_bno" + Integer.toString(d_bno));

		return "redirect:/diaryboard/diarylist";
	}

	// ���� ����
	@RequestMapping(value = "/managingFolder", method = RequestMethod.GET)
	public void manageFolder(Model model, HttpSession session) {

		String userid = (String)session.getAttribute("loginId");
		String folderList = DiaryBoardService.readFolderList(userid);
		String[] DiaryFolderList = folderList.split(",");

		model.addAttribute("DiaryFolderList", DiaryFolderList);

	} // end managingFolder.GET

	@RequestMapping(value = "/managingFolder", method = RequestMethod.POST)
	public void updateFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model,
			HttpSession session) {
		logger.info(beforeChangeF + "-> ??" + afterChangeF + "-> ??");

		String userid = (String)session.getAttribute("loginId");
		String folder_List = String.join(",", changedFolder);

		DiaryBoardFolderChangeVO fn;
		if (beforeChangeF != null && afterChangeF != null) {
			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new DiaryBoardFolderChangeVO(userid, folder_List, beforeChangeF, afterChangeF);
			DiaryBoardService.update(fn);
		} else {
			fn = new DiaryBoardFolderChangeVO(userid, folder_List, beforeChangeF, afterChangeF);
		}

		DiaryBoardService.updateFList(fn);

		logger.info("Controller_managingFolder : " + folder_List);
		String DiaryFolderList[] = folder_List.split(",");
		model.addAttribute("DiaryFolderList", DiaryFolderList);

	} // end updateFolder.POST

	@RequestMapping(value = "/MngFolderdelete", method = RequestMethod.POST)
	public String deleteFolder(String beforeChangeF, String afterChangeF, String[] changedFolder, Model model,
			String[] deletedFolder, HttpSession session) {
		String folder_List = String.join(",", changedFolder);
		// String homeId = (String)session.getAttribute("homeId");
		String userid = (String)session.getAttribute("loginId");

		for (String x : deletedFolder) {
			DiaryBoardFolderDeleteVO fd = new DiaryBoardFolderDeleteVO(userid, x);
			DiaryBoardService.delete_f(fd);
		}

		DiaryBoardFolderChangeVO fn;

		if (beforeChangeF != null && beforeChangeF != "" && afterChangeF != null && afterChangeF != "") {

			folder_List = folder_List.replace(beforeChangeF, afterChangeF);
			fn = new DiaryBoardFolderChangeVO(userid, folder_List, beforeChangeF, afterChangeF);
			DiaryBoardService.update(fn);
		} else {
			fn = new DiaryBoardFolderChangeVO(userid, folder_List, beforeChangeF, afterChangeF);
		}

		DiaryBoardService.updateFList(fn);

		logger.info("controller_MngFolder_delete : " + folder_List);

		String DiaryFolderList[] = folder_List.split(",");
		model.addAttribute("DiaryFolderList", DiaryFolderList);

		return "redirect:/diaryboard/managingFolder";
	} // end deleteFolder ()

} // end BoardController
