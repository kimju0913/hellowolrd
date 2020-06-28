package com.spring.helloworld.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class GLFileUploadUtil {

	private static final Logger logger =
			LoggerFactory.getLogger(FileUploadUtil.class);
	
	public static String saveUploadedFile(String uploadPath, 
			String fileName, byte[] data , String homeId ) throws IOException {
		
		UUID uuid = UUID.randomUUID();
		
		String saveName = uuid.toString() + "_" + fileName;
		
		String savePath = getUploadPath(uploadPath , homeId);
		File target = new File(uploadPath + File.separator + savePath , saveName);
		FileCopyUtils.copy(data, target);
		
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		String result = null;
		if (MediaUtil.getMediaType(extension) != null) {
			result = createIcon(uploadPath,savePath,saveName);
		} else {
			result = createIcon(uploadPath, savePath, saveName);
		}
		
		return result;
	}
	
	
	private static String getUploadPath(String uploadPath , String homeId ) {
		
		String idPath = homeId;
		String gallery = "Photoalbum";
		makeDir(uploadPath, idPath);
		
		String photoPath = homeId + File.separator + gallery ;
		makeDir(uploadPath, photoPath);
		
		
		

		return photoPath;
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

	
	private static String createIcon(String uploadPath,
			String savePath, String fileName) {
		
		String iconName = uploadPath + File.separator 
				+ savePath + File.separator + fileName;
		
		return iconName
				.substring(uploadPath.length())
				.replace(File.separatorChar, '/');
		
	}

	
}
