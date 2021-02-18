package com.javaex.vo;

public class UserVo {
	
	//필드
	private int UserNo;       //회원식별번호
	private int id;           //아이디
	private String UserName;  //회원이름
	private String password;  //패스워드
	private int joinDate;     //가입일
	
	//생성자
	public UserVo() {}
		
	public UserVo(int userNo, int id, String userName, String password, int joinDate) {
		super();
		UserNo = userNo;
		this.id = id;
		UserName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}

	//메소드 g/s
	public int getUserNo() {
		return UserNo;
	}

	public void setUserNo(int userNo) {
		UserNo = userNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(int joinDate) {
		this.joinDate = joinDate;
	}

	//메소드 일반
	@Override
	public String toString() {
		return "UserVo [UserNo=" + UserNo + ", id=" + id + ", UserName=" + UserName + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}	

}
