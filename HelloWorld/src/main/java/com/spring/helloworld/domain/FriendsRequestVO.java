package com.spring.helloworld.domain;

import java.util.Date;

public class FriendsRequestVO {
	private String send_userid;
	private String send_user_name;
	private String send_user_nickname;
	private String get_userid;
	private String get_user_name;
	private String get_user_nickname;
	private String message;
	private Date send_date;
	private String request_status;
	
	public FriendsRequestVO() {}

	

	public FriendsRequestVO(String send_userid, String send_user_name, String send_user_nickname, String get_userid,
			String get_user_name, String get_user_nickname, String message, Date send_date, String request_status) {
		super();
		this.send_userid = send_userid;
		this.send_user_name = send_user_name;
		this.send_user_nickname = send_user_nickname;
		this.get_userid = get_userid;
		this.get_user_name = get_user_name;
		this.get_user_nickname = get_user_nickname;
		this.message = message;
		this.send_date = send_date;
		this.request_status = request_status;
	}



	public String getSend_userid() {
		return send_userid;
	}

	public void setSend_userid(String send_userid) {
		this.send_userid = send_userid;
	}

	public String getSend_user_name() {
		return send_user_name;
	}

	public void setSend_user_name(String send_user_name) {
		this.send_user_name = send_user_name;
	}

	public String getSend_user_nickname() {
		return send_user_nickname;
	}

	public void setSend_user_nickname(String send_user_nickname) {
		this.send_user_nickname = send_user_nickname;
	}

	public String getGet_userid() {
		return get_userid;
	}

	public void setGet_userid(String get_userid) {
		this.get_userid = get_userid;
	}

	public String getGet_user_name() {
		return get_user_name;
	}

	public void setGet_user_name(String get_user_name) {
		this.get_user_name = get_user_name;
	}

	public String getGet_user_nickname() {
		return get_user_nickname;
	}

	public void setGet_user_nickname(String get_user_nickname) {
		this.get_user_nickname = get_user_nickname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}



	public String getRequest_status() {
		return request_status;
	}



	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}
	
	
}
