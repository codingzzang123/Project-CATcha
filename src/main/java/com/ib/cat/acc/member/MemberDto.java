package com.ib.cat.acc.member;

import org.springframework.web.multipart.MultipartFile;

public class MemberDto {
	//@Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message="에러")
	private String id;
	//@NotEmpty
	private String pw;
	private String name;
	private String email;
	private String imgo;
	private String imgs;
	private boolean auth;
	
	private MultipartFile file;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String pw, String name, String email, String imgo, String imgs) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.imgo = imgo;
		this.imgs = imgs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgo() {
		return imgo;
	}

	public void setImgo(String imgo) {
		this.imgo = imgo;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
