package com.spring.helloworld.domain;

public class GuestboardPaging {
	private int start;
	private int end;
	private String home_id;
	public GuestboardPaging(int start, int end, String home_id) {
		
		this.start = start;
		this.end = end;
		this.home_id = home_id;
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
	public String getHome_id() {
		return home_id;
	}
	public void setHome_id(String home_id) {
		this.home_id = home_id;
	}

	
	
	
}

	
	