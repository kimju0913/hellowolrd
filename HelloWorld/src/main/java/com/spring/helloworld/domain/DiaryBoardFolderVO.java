package com.spring.helloworld.domain;

public class DiaryBoardFolderVO {

	private String board_name;
	private String folder_name;
	private String userid;
	
	
	public DiaryBoardFolderVO() {}
	
	
	public DiaryBoardFolderVO(String board_name, String folder_name, String userid) {
		super();
		this.board_name = board_name;
		this.folder_name = folder_name;
		this.userid = userid;
	}


	public String getBoard_name() {
		return board_name;
	}


	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}


	public String getFolder_name() {
		return folder_name;
	}


	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	
	
	
	
	
	
	
	
	
} // end DiaryBoardFolderVO
