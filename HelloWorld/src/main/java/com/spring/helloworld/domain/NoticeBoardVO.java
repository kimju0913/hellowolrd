package com.spring.helloworld.domain;

import java.util.Date;

public class NoticeBoardVO {

	private int nt_bno;
	private String nt_folder;
	private String userid;
	private String user_name;
	private String nt_title;
	private String nt_content;
	private Date nt_date;
	private int nt_rno_cnt;
	private int nt_cnt;
	private String nt_file;

	public NoticeBoardVO() {
	}

	public NoticeBoardVO(int nt_bno, String nt_folder, String userid, String user_name, String nt_title,
			String nt_content, Date nt_date, int nt_rno_cnt, int nt_cnt, String nt_file) {
		super();
		this.nt_bno = nt_bno;
		this.nt_folder = nt_folder;
		this.userid = userid;
		this.user_name = user_name;
		this.nt_title = nt_title;
		this.nt_content = nt_content;
		this.nt_date = nt_date;
		this.nt_rno_cnt = nt_rno_cnt;
		this.nt_cnt = nt_cnt;
		this.nt_file = nt_file;
	}

	public int getNt_rno_cnt() {
		return nt_rno_cnt;
	}

	public void setNt_rno_cnt(int nt_rno_cnt) {
		this.nt_rno_cnt = nt_rno_cnt;
	}

	public int getNt_cnt() {
		return nt_cnt;
	}

	public void setNt_cnt(int nt_cnt) {
		this.nt_cnt = nt_cnt;
	}

	public String getNt_file() {
		return nt_file;
	}

	public void setNt_file(String nt_file) {
		this.nt_file = nt_file;
	}

	public int getNt_bno() {
		return nt_bno;
	}

	public void setNt_bno(int nt_bno) {
		this.nt_bno = nt_bno;
	}

	public String getNt_folder() {
		return nt_folder;
	}

	public void setNt_folder(String nt_folder) {
		this.nt_folder = nt_folder;
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

	public String getNt_title() {
		return nt_title;
	}

	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}

	public String getNt_content() {
		return nt_content;
	}

	public void setNt_content(String nt_content) {
		this.nt_content = nt_content;
	}

	public Date getNt_date() {
		return nt_date;
	}

	public void setNt_date(Date nt_date) {
		this.nt_date = nt_date;
	}

} // end NoticeBoardVO {}
