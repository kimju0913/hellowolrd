package com.spring.helloworld.domain;

public class GalleryBoardPaging {
	
	
	private String folder_name ; 
	private String userid ; 
	private int start;
	private int end;
	
	public GalleryBoardPaging() {}

	public GalleryBoardPaging(String folder_name, String userid, int start, int end) {
		super();
		this.folder_name = folder_name;
		this.userid = userid;
		this.start = start;
		this.end = end;
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	
	
}
