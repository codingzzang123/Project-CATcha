package com.ib.cat.main.model;

import java.util.List;

import com.ib.cat.main.dto.MainDTO;
import com.ib.cat.main.dto.SearchBoardDTO;

public interface MainDao {
	public abstract List<MainDTO> getTopFive();
	
	public abstract int getToday();
	
	public abstract int getTotal();
	
	public abstract void insert();
	
	public abstract int searchBoardCount(String query);
	
	public abstract List<MainDTO> searchBoard(SearchBoardDTO sbd);
}
