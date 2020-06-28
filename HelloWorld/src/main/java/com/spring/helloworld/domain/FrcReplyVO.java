package com.spring.helloworld.domain;

import java.util.Date;

public class FrcReplyVO {

	private int frc_rno; // 일촌평 댓글
	private int frc_bno;  // 일촌평 번호
	private String nickname; //댓글 작성자 닉네임
	private String userid; // 댓글 작성자 아이디
	private String user_name; // 댓글 작성자 이름
	private String frc_reply_content; // 댓글내용
	private String home_id; // 홈피주인아이디
	private Date frc_reply_date; // 댓글 작성/수정시간
	
	
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
				+ "FrcReplyVO - 댓글 번호 : " + frc_rno + "\n"
				+ "FrcReplyVO - 게시글 번호 : " + frc_bno + "\n"
				+ "FrcReplyVO - 댓글 내용 : " + frc_reply_content + "\n"
				+ "FrcReplyVO - 댓글 작성자 아이디 : " + userid + "\n"
				+ "FrcReplyVO - 댓글 작성 시간 : " + frc_reply_date;
		return str;
	}
	
	
}// end FrcReplyVO
