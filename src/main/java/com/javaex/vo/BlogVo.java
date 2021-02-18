package com.javaex.vo;

public class BlogVo {
	
	//필드
	private int id;           //식별번호 pk fk
	private String blogTitle; //블로그제목
	private String logoFile;  //블로그 이미지 경로
	
	//생성자
	public BlogVo() {}
	
	public BlogVo(int id, String blogTitle, String logoFile) {
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}
	
	//메소드 g/s
	
	//메소드

}
