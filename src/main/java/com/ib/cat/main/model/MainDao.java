package com.ib.cat.main.model;

import java.util.List;

public interface MainDao {
	public abstract List<MainDTO> getTopFive();
}
