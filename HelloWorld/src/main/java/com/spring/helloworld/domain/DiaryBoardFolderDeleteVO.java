package com.spring.helloworld.domain;

public class DiaryBoardFolderDeleteVO {

	private String userid;
	private String d_folder;
	
	
	public DiaryBoardFolderDeleteVO() {}


	public DiaryBoardFolderDeleteVO(String userid, String d_folder) {
		super();
		this.userid = userid;
		this.d_folder = d_folder;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getD_folder() {
		return d_folder;
	}


	public void setD_folder(String d_folder) {
		this.d_folder = d_folder;
	}


	

	
	
	
	
	
	
	
}// end DiaryBoardFolderDeleteVO {}
