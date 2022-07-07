package com.ib.cat.main.util;

import java.util.Comparator;

import com.ib.cat.main.dto.TvDTO;



public class SortTvByVote implements Comparator<TvDTO>{
	@Override
	public int compare(TvDTO o1, TvDTO o2) {
		float first = o1.getVote_average();
		float second = o2.getVote_average();
		if (first < second) {
			return 1;
		} else if (first > second) {
			return -1;
		} else {
			return 0;
		}
		
	}
}
