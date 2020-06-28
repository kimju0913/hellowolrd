package com.spring.helloworld.domain;

import java.util.Date;

public class NoticeReplyVO {

	private int nt_rno ;
	private int nt_bno;
	private String userid;
	private String user_name;
	private Date nt_reply_date;
	private String nt_reply_content;
	
	
	public NoticeReplyVO() {}
	
	

	public NoticeReplyVO(int nt_rno, int nt_bno, String userid, String user_name, Date nt_reply_date,
			String nt_reply_content) {
		super();
		this.nt_rno = nt_rno;
		this.nt_bno = nt_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.nt_reply_date = nt_reply_date;
		this.nt_reply_content = nt_reply_content;
	}



	public int getNt_rno() {
		return nt_rno;
	}

	public void setNt_rno(int nt_rno) {
		this.nt_rno = nt_rno;
	}

	public int getNt_bno() {
		return nt_bno;
	}

	public void setNt_bno(int nt_bno) {
		this.nt_bno = nt_bno;
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

	public Date getNt_reply_date() {
		return nt_reply_date;
	}

	public void setNt_reply_date(Date nt_reply_date) {
		this.nt_reply_date = nt_reply_date;
	}

	public String getNt_reply_content() {
		return nt_reply_content;
	}

	public void setNt_reply_content(String nt_reply_content) {
		this.nt_reply_content = nt_reply_content;
	}

	

	
	
	
	
	
	
} // end NoticeReplyVO {} 
