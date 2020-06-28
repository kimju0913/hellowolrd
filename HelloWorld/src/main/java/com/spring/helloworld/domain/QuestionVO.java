package com.spring.helloworld.domain;

import java.util.Date;

public class QuestionVO {
	private int q_bno;
	private String userid;
	private String user_name;
	private String q_menu;
	private String q_title;
	private String q_content;
	private Date q_date;
	private String q_answer;
	private String q_secret;
	
	
	public QuestionVO() {
		
	}


	public QuestionVO(int q_bno, String userid, String user_name, String q_menu, String q_title, String q_content,
			Date q_date, String q_answer, String q_secret) {
		super();
		this.q_bno = q_bno;
		this.userid = userid;
		this.user_name = user_name;
		this.q_menu = q_menu;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_answer = q_answer;
		this.q_secret = q_secret;
	}


	public int getQ_bno() {
		return q_bno;
	}


	public void setQ_bno(int q_bno) {
		this.q_bno = q_bno;
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


	public String getQ_menu() {
		return q_menu;
	}


	public void setQ_menu(String q_menu) {
		this.q_menu = q_menu;
	}


	public String getQ_title() {
		return q_title;
	}


	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}


	public String getQ_content() {
		return q_content;
	}


	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}


	public Date getQ_date() {
		return q_date;
	}


	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}


	public String getQ_answer() {
		return q_answer;
	}


	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}


	public String getQ_secret() {
		return q_secret;
	}


	public void setQ_secret(String q_secret) {
		this.q_secret = q_secret;
	}
	
	


	
	
	
	
}