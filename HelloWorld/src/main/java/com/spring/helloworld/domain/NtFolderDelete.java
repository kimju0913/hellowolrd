package com.spring.helloworld.domain;

public class NtFolderDelete {
	private String userid;
	private String nt_folder;
	
	public NtFolderDelete(String userid, String nt_folder) {
		super();
		this.userid = userid;
		this.nt_folder = nt_folder;
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
