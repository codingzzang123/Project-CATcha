package com.ib.cat.board.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;


public class BoardVo {


	
	private int no;
	@NotEmpty(message="작성자를 입력하세요.")
	private String name;
	private String cate;
	@NotEmpty(message="제목을 입력하세요.")
	private String title;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private Timestamp regdate;
	private int views;
	private int likes;
	private String imgo;
	private String imgs;
	private String replys;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
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
	public String getReplys() {
		return replys;
	}
	public void setReplys(String replys) {
		this.replys = replys;
	}

	
}
