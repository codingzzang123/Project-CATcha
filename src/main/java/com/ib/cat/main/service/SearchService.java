package com.ib.cat.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.cat.main.dto.MainDTO;
import com.ib.cat.main.dto.MovieDTO;
import com.ib.cat.main.dto.SearchCountDTO;
import com.ib.cat.main.dto.TvDTO;
import com.ib.cat.main.util.SearchInfoUtil;

@Service
public class SearchService {
	
	@Autowired
	private SearchInfoUtil util;
	
	public List<MovieDTO> movie(int page, String query){
		
		List<MovieDTO> list = util.getMovieList(page, query);
		
		return list;
	}

	public List<TvDTO> tv(int page, String query){
		
		List<TvDTO> list = util.getTvList(page, query);
		
		return list;
	}

	public SearchCountDTO scd(String query) {
		return util.contents(query);
	}
	
	public List<MainDTO> board(int page,String query){
		return util.getBoardList(page, query);
	}
	
}
