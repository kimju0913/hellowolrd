package com.spring.helloworld.domain;

import java.util.Date;

public class DiaryBoardVO {
	private int d_bno;
	private String userid;
	private String user_name;
	private String d_folder;
	private String d_content;
	private Date d_date;
	
	
	public DiaryBoardVO() {} 
	
	public DiaryBoardVO(int d_bno, String userid, String user_name, String d_folder, String d_content, Date d_date) {
		super();
		this.d_bno = d_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.d_folder = d_folder;
		this.d_content = d_content;
		this.d_date = d_date;
	}

	public int getD_bno() {
		return d_bno;
	}

	public void setD_bno(int d_bno) {
		this.d_bno = d_bno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getD_folder() {
		return d_folder;
	}

	public void setD_folder(String d_folder) {
		this.d_folder = d_folder;
	}

	public String getD_content() {
		return d_content;
	}

	public void setD_content(String d_content) {
		this.d_content = d_content;
	}

	public Date getD_date() {
		return d_date;
	}

	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}

	

	
	
	
	
}
