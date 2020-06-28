package com.spring.helloworld.util;

public class AnBoardMenuPage {

	private String q_menu;
	private String userid;
	private int start;
	private int end;
	public AnBoardMenuPage() {}
	public AnBoardMenuPage( String userid, int start, int end) {

		
		this.userid = userid;
		this.start = start;
		this.end = end;
	}
	
	
	public AnBoardMenuPage(String q_menu, String userid, int start, int end) {

		this.q_menu = q_menu;
		this.userid = userid;
		this.start = start;
		this.end = end;
	}
	public String getQ_menu() {
		return q_menu;
	}
	public void setQ_menu(String q_menu) {
		this.q_menu = q_menu;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}