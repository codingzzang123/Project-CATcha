package com.ib.cat.main.dto;

public class SearchBoardDTO {
	private int start;
	private int end;
	private String query;
	
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public SearchBoardDTO() {}
	
	public SearchBoardDTO(int start, int end, String query) {
		super();
		this.start = start;
		this.end = end;
		this.query = query;
	}
	
	
}
