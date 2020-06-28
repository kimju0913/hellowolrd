package com.spring.helloworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class FileAdministration {

	public static void moveFile(String beforeFilePath, String afterFilePath) {
		
		String changeFilePath = afterFilePath ;
		String deleteFilePath = beforeFilePath ;
		List<File> dirList = getDirFileList(beforeFilePath);	
		if(dirList != null) {
		 for (int i=0; i<dirList.size(); i++)
		  {
		   //i��° ����Ǿ� �ִ� ������ �ҷ��´�.
		   String fileName = dirList.get(i).getName();
		
		   fileMove(beforeFilePath+File.separator+fileName, afterFilePath+File.separator+fileName , changeFilePath , deleteFilePath);

		  }
		}  
		
	}

	
	private static void fileMove(String beforeFilePath, String afterFilePath , String changeFilePath , String deleteFilePath) {
		  try {
			  File dir = new File(changeFilePath); 
			  if (!dir.exists()) {
				  dir.mkdirs(); 
				 }
			  

		   FileInputStream fis = new FileInputStream(beforeFilePath);
		   FileOutputStream fos = new FileOutputStream(afterFilePath);
		   
		   int data = 0;
		   while((data=fis.read())!=-1) {
		    fos.write(data);
		   }
		   fis.close();
		   fos.close();
		 
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }

	 public static  List<File> getDirFileList(String beforeFilePath) {
		 
		  List<File> dirFileList = null;
		  
		  // ���� ����� ��û�� ���丮�� ������ ���� ��ü�� ������
		  File dir = new File(beforeFilePath);
		  
		  if (dir.exists())
		  {
		   File[] files = dir.listFiles();
		   
		   dirFileList = Arrays.asList(files);
		  }
		  
		  return dirFileList;
		 

	}

	
	//���� �� ���� ���� + ���� ���� 
	public static void deleteDirectoryAndFiles(File file) {
		if (file.isDirectory()) {
			if (file.listFiles().length != 0) {
				File[] fileList = file.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					deleteDirectoryAndFiles(fileList[i]);
					System.out.println("���� ���� �޼ҵ�" + file);
					file.delete();
				}
			} else {
				file.delete();
			}
		} else {
			file.delete();
		}
	}

}
