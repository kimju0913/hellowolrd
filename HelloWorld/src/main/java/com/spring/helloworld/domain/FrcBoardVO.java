package com.spring.helloworld.domain;

import java.util.Date;

public class FrcBoardVO {

	private int frc_bno; // �Խñ�(���) ��ȣ
	private String nickname; // �г���
	private String userid; // �湮�� ���̵�
	private String user_name; // ����� �̸�
	private Date frc_date; // �ۼ� �ð�
	private String frc_content; // �Խñ�(���) ����
	private String home_id; // Ȩ�� ���� ���̵�
	private int replycnt; // ��� ����
	
	
	public FrcBoardVO () {}



	public FrcBoardVO(int frc_bno, String nickname, String userid, String user_name, Date frc_date, String frc_content,
			String home_id) {
		super();
		this.frc_bno = frc_bno;
		this.nickname = nickname;
		this.userid = userid;
		this.user_name = user_name;
		this.frc_date = frc_date;
		this.frc_content = frc_content;
		this.home_id = home_id;
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



	public Date getFrc_date() {
		return frc_date;
	}



	public void setFrc_date(Date frc_date) {
		this.frc_date = frc_date;
	}



	public String getFrc_content() {
		return frc_content;
	}



	public void setFrc_content(String frc_content) {
		this.frc_content = frc_content;
	}



	public String getHome_id() {
		return home_id;
	}



	public void setHome_id(String home_id) {
		this.home_id = home_id;
	}



	public int getReplycnt() {
		return replycnt;
	}



	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	@Override
	public String toString() {
		String str = "������ ��ȣ : " + frc_bno + "\n"
				+ "������ ���� : " + frc_content + "\n"
				+ "�ۼ��� ���̵� : " + userid + "\n"
				+ "�ۼ��� �̸� : " + user_name + "\n"
				+ "�ۼ��� ���� : " + nickname + "\n"
				+ "������ �ۼ� �ð� : " + frc_date;
		return str;
	}



} // end FrcBoardVO
