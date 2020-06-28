package com.spring.helloworld.domain;


public class DiaryBoardPagingVO {

	private String userid;
	private String folder_name;
	private String d_date;
	private int start;
	private int end;
	
	
	public DiaryBoardPagingVO () {}


	public DiaryBoardPagingVO(String userid, String folder_name , int start, int end) {
		super();
		this.userid = userid;
		this.folder_name = folder_name;
		
		this.start = start;
		this.end = end;
	}

	

	public DiaryBoardPagingVO(String userid, String folder_name , String d_date, int start, int end) {
		super();
		this.userid = userid;
		this.folder_name = folder_name;
		this.d_date = d_date;
		this.start = start;
		this.end = end;
	}



	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getFolder_name() {
		return folder_name;
	}


	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
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


	public String getD_date() {
		return d_date;
	}


	public void setD_date(String d_date) {
		this.d_date = d_date;
	}


	

	

	
	
	
	
	
	
	
} // end DiaryBoardPagingVO
