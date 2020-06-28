package com.spring.helloworld.domain;

import java.util.Date;

public class AnnounceBoardVO {
	private int an_bno ;
	private String an_title;
	private String an_content;
	private Date an_date;
	private String an_menu;
	public AnnounceBoardVO() {
		
	}
	public AnnounceBoardVO(int an_bno, String an_title,
			String an_content, Date an_date, String an_menu) {
		this.an_bno = an_bno;
		this.an_title = an_title;
		this.an_content = an_content;
		this.an_date = an_date;
		this.an_menu = an_menu;
	}
	public int getAn_bno() {
		return an_bno;
	}
	public void setAn_bno(int an_bno) {
		this.an_bno = an_bno;
	}
	public String getAn_title() {
		return an_title;
	}
	public void setAn_title(String an_title) {
		this.an_title = an_title;
	}
	public String getAn_content() {
		return an_content;
	}
	public void setAn_content(String an_content) {
		this.an_content = an_content;
	}
	public Date getAn_date() {
		return an_date;
	}
	public void setAn_date(Date an_date) {
		this.an_date = an_date;
	}
	public String getAn_menu() {
		return an_menu;
	}
	public void setAn_menu(String an_menu) {
		this.an_menu = an_menu;
	}
	
	
	
	
}
