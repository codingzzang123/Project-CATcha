package com.ib.cat.main.model;

import java.util.List;

public interface MainDao {
	public abstract List<MainDTO> getTopFive();
	
	public abstract int getToday();
	
	public abstract int getTotal();
	
	public abstract void insert();
}
