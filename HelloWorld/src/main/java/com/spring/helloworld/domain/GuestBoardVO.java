package com.spring.helloworld.domain;

import java.util.Date;

public class GuestBoardVO {

	private int g_bno;
	private String userid;
	private String user_name;
	private String g_content;
	private Date g_date;
	private String g_secret;
	private String home_id;
	private String g_reply;
	private String user_photo;
	public GuestBoardVO() {
	}


	public int getG_bno() {
		return g_bno;
	}


	public void setG_bno(int g_bno) {
		this.g_bno = g_bno;
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


	public String getG_content() {
		return g_content;
	}


	public void setG_content(String g_content) {
		this.g_content = g_content;
	}


	public Date getG_date() {
		return g_date;
	}


	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}


	public String getG_secret() {
		return g_secret;
	}


	public void setG_secret(String g_secret) {
		this.g_secret = g_secret;
	}


	public String getHome_id() {
		return home_id;
	}


	public void setHome_id(String home_id) {
		this.home_id = home_id;
	}


	public String getG_reply() {
		return g_reply;
	}


	public void setG_reply(String g_reply) {
		this.g_reply = g_reply;
	}


	public String getUser_photo() {
		return user_photo;
	}


	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}


	public GuestBoardVO(int g_bno, String userid, String user_name, String g_content, Date g_date, String g_secret,
			String home_id, String g_reply, String user_photo) {
	
		this.g_bno = g_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.g_content = g_content;
		this.g_date = g_date;
		this.g_secret = g_secret;
		this.home_id = home_id;
		this.g_reply = g_reply;
		this.user_photo = user_photo;
	}


	@Override
	public String toString() {
		String str = "작성자 이름 : " + user_name + "게시판 번호 : " + g_bno + "게시판 내용 : " + g_content + "홈페이지 아이디 : " + home_id
				+ "작성장 아이디 :" + userid
				+ "유저 포토URL"+user_photo;
		return str;
	}

}
