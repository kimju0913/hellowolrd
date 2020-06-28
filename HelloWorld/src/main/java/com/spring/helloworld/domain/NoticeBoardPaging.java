package com.spring.helloworld.domain;

public class NoticeBoardPaging {
	private int start;
	private int end;
	private String userid;
	private String nt_folder;
	
	public NoticeBoardPaging() {}
	
	
	public NoticeBoardPaging(int start, int end, String userid) {
		this.start = start;
		this.end = end;
		this.userid = userid;
	}

	public NoticeBoardPaging(int start, int end, String userid, String nt_folder) {
		super();
		this.start = start;
		this.end = end;
		this.userid = userid;
		this.nt_folder = nt_folder;
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNt_folder() {
		return nt_folder;
	}

	public void setNt_folder(String nt_folder) {
		this.nt_folder = nt_folder;
	}
	
	

}
