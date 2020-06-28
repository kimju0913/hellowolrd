package com.spring.helloworld.domain;

public class GlFolderDelete {
	private String homeId;
	private String gl_folder;
	
	public GlFolderDelete(String homeId, String gl_folder) {
		super();
		this.homeId = homeId;
		this.gl_folder = gl_folder;
	}

	public String getHomeid() {
		return homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getGl_folder() {
		return gl_folder;
	}

	public void setGl_folder(String gl_folder) {
		this.gl_folder = gl_folder;
	}
	
	
}
