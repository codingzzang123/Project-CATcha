package com.ib.cat.media;

import java.util.Comparator;
import java.util.Date;

import com.ib.cat.media.vo.ContentsVO;

public class SortByDate implements Comparator<ContentsVO> {

	@Override
	public int compare(ContentsVO o1, ContentsVO o2) {
		Date first = o1.getReleaseDate();
		Date second = o2.getReleaseDate();
		return second.compareTo(first);
	}

}
