package com.spring.helloworld.domain;

public class NtFolderChange {
	
	private String userid;
	private String folder_List;
	private String old_folder;
	private String new_folder;
	
	

	public NtFolderChange(String userid, String folder_List, String old_folder, String new_folder) {
		super();
		this.userid = userid;
		this.folder_List = folder_List;
		this.old_folder = old_folder;
		this.new_folder = new_folder;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFolder_List() {
		return folder_List;
	}

	public void setFolder_List(String folder_List) {
		this.folder_List = folder_List;
	}

	public String getOld_folder() {
		return old_folder;
	}

	public void setOld_folder(String old_folder) {
		this.old_folder = old_folder;
	}

	public String getNew_folder() {
		return new_folder;
	}

	public void setNew_folder(String new_folder) {
		this.new_folder = new_folder;
	}
	
	
	
	
}
