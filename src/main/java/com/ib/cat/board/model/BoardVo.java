package com.ib.cat.board.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;

//@Alias("BoardVo")
public class BoardVo {

//	private int NO;
//	@NotEmpty(message="작성자를 입력하세요.")
//	private String NAME;
//	private String CATE;
//	@NotEmpty(message="제목을 입력하세요.")
//	private String TITLE;
//	@NotEmpty(message="내용을 입력하세요.")
//	private String CONTENT;
//	private Timestamp REGDATE;
//	private int VIEWS;
//	private int LIKES;
//	private String IMGO;
//	private String IMGS;
//	private String REPLYS;
//	
//	public int getNO() {
//		return NO;
//	}
//	public void setNO(int nO) {
//		NO = nO;
//	}
//	public String getNAME() {
//		return NAME;
//	}
//	public void setNAME(String nAME) {
//		NAME = nAME;
//	}
//	public String getCATE() {
//		return CATE;
//	}
//	public void setCATE(String cATE) {
//		CATE = cATE;
//	}
//	public String getTITLE() {
//		return TITLE;
//	}
//	public void setTITLE(String tITLE) {
//		TITLE = tITLE;
//	}
//	public String getCONTENT() {
//		return CONTENT;
//	}
//	public void setCONTENT(String cONTENT) {
//		CONTENT = cONTENT;
//	}
//	public Timestamp getREGDATE() {
//		return REGDATE;
//	}
//	public void setREGDATE(Timestamp rEGDATE) {
//		REGDATE = rEGDATE;
//	}
//	public int getVIEWS() {
//		return VIEWS;
//	}
//	public void setVIEWS(int vIEWS) {
//		VIEWS = vIEWS;
//	}
//	public int getLIKES() {
//		return LIKES;
//	}
//	public void setLIKES(int lIKES) {
//		LIKES = lIKES;
//	}
//	public String getIMGO() {
//		return IMGO;
//	}
//	public void setIMGO(String iMGO) {
//		IMGO = iMGO;
//	}
//	public String getIMGS() {
//		return IMGS;
//	}
//	public void setIMGS(String iMGS) {
//		IMGS = iMGS;
//	}
//	public String getREPLYS() {
//		return REPLYS;
//	}
//	public void setREPLYS(String rEPLYS) {
//		REPLYS = rEPLYS;
//	}
//	@Override
//	public String toString() {
//		return "BoardVo [NO=" + NO + ", NAME=" + NAME + ", CATE=" + CATE + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT
//				+ ", REGDATE=" + REGDATE + ", VIEWS=" + VIEWS + ", LIKES=" + LIKES + ", IMGO=" + IMGO + ", IMGS=" + IMGS
//				+ ", REPLYS=" + REPLYS + "]";
//	}
	
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
