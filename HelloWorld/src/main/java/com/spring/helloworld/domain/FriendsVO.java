package com.spring.helloworld.domain;

public class FriendsVO {
	private String userid;
	private String fr_id;
	private String fr_user_name;
	private String nickname;
	
	public FriendsVO() {}

	public FriendsVO(String userid, String fr_id, String fr_user_name, String nickname) {
		super();
		this.userid = userid;
		this.fr_id = fr_id;
		this.fr_user_name = fr_user_name;
		this.nickname = nickname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFr_id() {
		return fr_id;
	}

	public void setFr_id(String fr_id) {
		this.fr_id = fr_id;
	}

	public String getFr_user_name() {
		return fr_user_name;
	}

	public void setFr_user_name(String fr_user_name) {
		this.fr_user_name = fr_user_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
}
