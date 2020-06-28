package com.spring.helloworld.domain;

import java.util.Date;


public class GalleryBoardVO {

	private int gl_bno;
	private String gl_folder;
	private String userid;
	private String gl_title;
	private String gl_img;
	private String gl_content;
	private Date gl_date;
	private String user_name;
	
	public GalleryBoardVO () {}
	

	public GalleryBoardVO(int gl_bno, String gl_folder, String userid, String gl_title, String gl_img,
			String gl_content, Date gl_date , String user_name) {
		super();
		this.gl_bno = gl_bno;
		this.gl_folder = gl_folder;
		this.userid = userid;
		this.gl_title = gl_title;
		this.gl_img = gl_img;
		this.gl_content = gl_content;
		this.gl_date = gl_date;
		this.user_name = user_name;
	}


	public int getGl_bno() {
		return gl_bno;
	}


	public void setGl_bno(int gl_bno) {
		this.gl_bno = gl_bno;
	}


	public String getGl_folder() {
		return gl_folder;
	}


	public void setGl_folder(String gl_folder) {
		this.gl_folder = gl_folder;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getGl_title() {
		return gl_title;
	}


	public void setGl_title(String gl_title) {
		this.gl_title = gl_title;
	}


	public String getGl_img() {
		return gl_img;
	}


	public void setGl_img(String gl_img) {
		this.gl_img = gl_img;
	}


	public String getGl_content() {
		return gl_content;
	}


	public void setGl_content(String gl_content) {
		this.gl_content = gl_content;
	}


	public Date getGl_date() {
		return gl_date;
	}


	public void setGl_date(Date gl_date) {
		this.gl_date = gl_date;
	}

	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	

} // end GalleryBoardVO {}
