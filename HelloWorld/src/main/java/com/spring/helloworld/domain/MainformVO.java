package com.spring.helloworld.domain;

import java.util.Date;

public class MainformVO {
	private String userid;
	private String theme;
	private int total_cnt;
	private int today_cnt;
	private String main_title;
	private String profile_photo;
	private String profile_content;
	private String tap_menu;
	private Date cnt_date;
	
	public MainformVO() {}
	
	

	public MainformVO(String userid, String theme, int total_cnt, int today_cnt, String main_title,
			String profile_photo, String profile_content, String tap_menu, Date cnt_date) {
		super();
		this.userid = userid;
		this.theme = theme;
		this.total_cnt = total_cnt;
		this.today_cnt = today_cnt;
		this.main_title = main_title;
		this.profile_photo = profile_photo;
		this.profile_content = profile_content;
		this.tap_menu = tap_menu;
		this.cnt_date = cnt_date;
	}



	public String getProfile_content() {
		return profile_content;
	}



	public void setProfile_content(String profile_content) {
		this.profile_content = profile_content;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}

	public int getToday_cnt() {
		return today_cnt;
	}

	public void setToday_cnt(int today_cnt) {
		this.today_cnt = today_cnt;
	}

	public String getMain_title() {
		return main_title;
	}

	public void setMain_title(String main_title) {
		this.main_title = main_title;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getTap_menu() {
		return tap_menu;
	}

	public void setTap_menu(String tap_menu) {
		this.tap_menu = tap_menu;
	}

	public Date getCnt_date() {
		return cnt_date;
	}

	public void setCnt_date(Date cnt_date) {
		this.cnt_date = cnt_date;
	}
		
}
