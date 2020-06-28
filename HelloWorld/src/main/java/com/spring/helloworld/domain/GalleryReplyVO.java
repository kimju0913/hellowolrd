package com.spring.helloworld.domain;

import java.util.Date;

public class GalleryReplyVO {
	
	private int gl_rno ;
	private int gl_bno ;
	private String userid;
	private String user_name;
	private Date gl_reply_date;
	private String gl_reply_content ;
	
	public GalleryReplyVO() {}

	
	public GalleryReplyVO(int gl_rno, int gl_bno, String userid, String user_name , Date gl_reply_date , String gl_reply_content) {
		super();
		this.gl_rno = gl_rno;
		this.gl_bno = gl_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.gl_reply_date = gl_reply_date;
		this.gl_reply_content = gl_reply_content;
	}
	
	
	public int getGl_rno() {
		return gl_rno;
	}

	public void setGl_rno(int gl_rno) {
		this.gl_rno = gl_rno;
	}

	public int getGl_bno() {
		return gl_bno;
	}

	public void setGl_bno(int gl_bno) {
		this.gl_bno = gl_bno;
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

	public Date getGl_reply_date() {
		return gl_reply_date;
	}

	public void setGl_reply_date(Date gl_reply_date) {
		this.gl_reply_date = gl_reply_date;
	}
	
	public String getGl_reply_content() {
		return gl_reply_content;
	}
	
	public void setGl_reply_content(String gl_reply_content) {
		this.gl_reply_content = gl_reply_content;
	}
	
}
