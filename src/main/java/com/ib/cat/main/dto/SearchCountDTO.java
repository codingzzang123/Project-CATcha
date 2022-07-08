package com.ib.cat.main.dto;

import org.springframework.stereotype.Component;

@Component
public class SearchCountDTO {
	private int movie;
	private int tv;
	private int board;
	
	public int getMovie() {
		return movie;
	}
	public void setMovie(int movie) {
		this.movie = movie;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getBoard() {
		return board;
	}
	public void setBoard(int board) {
		this.board = board;
	}
}
