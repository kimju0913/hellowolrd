package com.spring.helloworld.domain;

import java.util.Date;

public class FrcReplyVO {

	private int frc_rno; // ������ ���
	private int frc_bno;  // ������ ��ȣ
	private String nickname; //��� �ۼ��� �г���
	private String userid; // ��� �ۼ��� ���̵�
	private String user_name; // ��� �ۼ��� �̸�
	private String frc_reply_content; // ��۳���
	private String home_id; // Ȩ�����ξ��̵�
	private Date frc_reply_date; // ��� �ۼ�/�����ð�
	
	
	public FrcReplyVO () {}



	public FrcReplyVO(int frc_rno, int frc_bno, String nickname, String userid, String user_name,
			String frc_reply_content, String home_id, Date frc_reply_date) {
		super();
		this.frc_rno = frc_rno;
		this.frc_bno = frc_bno;
		this.nickname = nickname;
		this.userid = userid;
		this.user_name = user_name;
		this.frc_reply_content = frc_reply_content;
		this.home_id = home_id;
		this.frc_reply_date = frc_reply_date;
	}



	public int getFrc_rno() {
		return frc_rno;
	}



	public void setFrc_rno(int frc_rno) {
		this.frc_rno = frc_rno;
	}



	public int getFrc_bno() {
		return frc_bno;
	}



	public void setFrc_bno(int frc_bno) {
		this.frc_bno = frc_bno;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
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



	public String getFrc_reply_content() {
		return frc_reply_content;
	}



	public void setFrc_reply_content(String frc_reply_content) {
		this.frc_reply_content = frc_reply_content;
	}



	public String getHome_id() {
		return home_id;
	}



	public void setHome_id(String home_id) {
		this.home_id = home_id;
	}



	public Date getFrc_reply_date() {
		return frc_reply_date;
	}



	public void setFrc_reply_date(Date frc_reply_date) {
		this.frc_reply_date = frc_reply_date;
	}



	@Override
	public String toString() {
		String str ="\n"
				+ "FrcReplyVO - ��� ��ȣ : " + frc_rno + "\n"
				+ "FrcReplyVO - �Խñ� ��ȣ : " + frc_bno + "\n"
				+ "FrcReplyVO - ��� ���� : " + frc_reply_content + "\n"
				+ "FrcReplyVO - ��� �ۼ��� ���̵� : " + userid + "\n"
				+ "FrcReplyVO - ��� �ۼ� �ð� : " + frc_reply_date;
		return str;
	}
	
	
}// end FrcReplyVO
