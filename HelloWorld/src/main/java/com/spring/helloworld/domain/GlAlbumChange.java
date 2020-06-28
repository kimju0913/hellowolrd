package com.spring.helloworld.domain;

public class GlAlbumChange {

	
	private String changeImgPath;
	private String gl_img;
	
	public GlAlbumChange() {}
	
	public GlAlbumChange(String changeImgPath , String gl_img) {
		
		this.changeImgPath = changeImgPath;
		this.gl_img = gl_img ;
		
	}


	public String getChangeImgPath() {
		return changeImgPath;
	}


	public void setChangeImgPath(String changeImgPath) {
		this.changeImgPath = changeImgPath;
	}


	public String getGl_img() {
		return gl_img;
	}


	public void setGl_img(String gl_img) {
		this.gl_img = gl_img;
	}


	
	
}
