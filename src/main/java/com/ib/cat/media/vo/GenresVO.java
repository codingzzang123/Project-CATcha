package com.ib.cat.media.vo;

public class GenresVO {
	int genreId;
	String genreName;
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "GenresVO [genreId=" + genreId + ", genreName=" + genreName + "]";
	}
	
	

}
