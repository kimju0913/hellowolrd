package com.spring.helloworld.domain;

import java.util.Date;

public class DiaryReplyVO {
	private int d_rno;
	private int d_bno;
	private String userid;
	private String user_name;
	private String d_reply_content;
	private Date d_reply_date;
	
	public DiaryReplyVO() {}

	public DiaryReplyVO(int d_rno, int d_bno, String userid, String user_name, String d_reply_content,
			Date d_reply_date) {
		super();
		this.d_rno = d_rno;
		this.d_bno = d_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.d_reply_content = d_reply_content;
		this.d_reply_date = d_reply_date;
	}

	
	
	
	public int getD_rno() {
		return d_rno;
	}

	public void setD_rno(int d_rno) {
		this.d_rno = d_rno;
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

	public String getD_reply_content() {
		return d_reply_content;
	}

	public void setD_reply_content(String d_reply_content) {
		this.d_reply_content = d_reply_content;
	}

	public Date getD_reply_date() {
		return d_reply_date;
	}

	public void setD_reply_date(Date d_reply_date) {
		this.d_reply_date = d_reply_date;
	}

	
	@Override
	public String toString() {
		String str = "´ñ±Û ¹øÈ£ : " + d_rno + "\n"
				 + " °Ô½Ã±Û ¹øÈ£ : " + d_bno + "\n"
				 + " ´ñ±Û ³»¿ë : " + d_reply_content + "\n"
				 + " ´ñ±Û ÀÛ¼ºÀÚ ¾ÆÀÌµð : " + userid + "\n"
				 + " ´ñ±Û ÀÛ¼º ½Ã°£ : " + d_reply_date;
		return str;
	}
	
	

	
}