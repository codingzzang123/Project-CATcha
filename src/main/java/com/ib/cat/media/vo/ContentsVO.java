package com.ib.cat.media.vo;

import java.util.Date;
import java.util.List;

public class ContentsVO {
	
	
	private int contentsNum;//v
	private String contentsType;//v
	private String title;//v
	private String overview;//v
	private String posterPath;//v
	private Date releaseDate;//v
	private float voteAverage;//v
	private float popularity;//v
	private String genre; //컨텐츠 장르
	private List<Integer> genres;//v
	private String runtime;
//	private int hour;
//	private int minute;
	private int count;
	private Double star; //평점
//	private GenresVO genresVO;
	/**/
	private List<GenresVO> ls;
	
	public List<GenresVO> getLs() {
		return ls;
	}
	public void setLs(List<GenresVO> ls) {
		this.ls = ls;
	}
	private int totalResults;
	private int totalPages;
	private int page;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public int getContentsNum() {
		return contentsNum;
	}
	public void setContentsNum(int contentsNum) {
		this.contentsNum = contentsNum;
	}
	public String getContentsType() {
		return contentsType;
	}
	public void setContentsType(String contentsType) {
		this.contentsType = contentsType;
	}
	public float getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
	}
	public float getPopularity() {
		return popularity;
	}
	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public List<Integer> getGenres() {
		return genres;
	}
	public void setGenres(List<Integer> genreList) {
		this.genres = genreList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getStar() {
		return star;
	}
	public void setStar(Double star) {
		this.star = star;
	}
//	public int getHour() {
//		return hour;
//	}
//	public void setHour(int hour) {
//		this.hour = hour;
//	}
//	public int getMinute() {
//		return minute;
//	}
//	public void setMinute(int minute) {
//		this.minute = minute;
//	}
//	

	

}
