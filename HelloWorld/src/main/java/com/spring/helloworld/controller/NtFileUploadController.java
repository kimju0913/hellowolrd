package com.spring.helloworld.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/ntBoard")
public class NtFileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(NtFileUploadController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void uploadGet() {
	}
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public void uploadPost2(MultipartFile[] files, Model model) {
		
		
		String result = "";
		for(MultipartFile f : files) {
			result += saveUploadFile(f) + " ";
		}
		String [] fileNames = result.split("__");
		String savedFile = fileNames[1];
		model.addAttribute("savedFile", savedFile);
		
	}//end uploadPost2
	

	
	private String saveUploadFile(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "__" + file.getOriginalFilename();
		
		String savePath = getUploadPath(uploadPath);
		
		File target = new File(uploadPath + File.separator + savePath,
				savedName);
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			return savedName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}// saveUploadFile()
	
	private static String getUploadPath(String uploadPath) {
		Calendar calendar = Calendar.getInstance();
		
		String yearPath = String.valueOf(calendar.get(Calendar.YEAR));
		logger.info("yearPath: " + yearPath);
		makeDir(uploadPath, yearPath);
		
		String monthPath = yearPath
				+ File.separator
				+ new DecimalFormat("00")
					.format(calendar.get(Calendar.MONTH) + 1);
		logger.info("monthPath: " + monthPath);
		makeDir(uploadPath, monthPath);
		
		String datePath = monthPath
				+ File.separator
				+ new DecimalFormat("00")
					.format(calendar.get(Calendar.DATE));
		logger.info("datePath: " + datePath);
		makeDir(uploadPath, datePath);

		return datePath;
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
	
	
}// end class
