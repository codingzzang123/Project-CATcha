package com.ib.cat.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.cat.main.model.MainDTO;
import com.ib.cat.main.model.MainDao;
import com.ib.cat.main.util.MovieDTO;

@Service
public class Search {

	@Autowired
	private MainDao dao;
	
	public List<MovieDTO> movie(String keyword){
		
		List<MovieDTO> list = new ArrayList<>();
		
		return list;
	}
	
//	public List<TvDTO> tv(String keyword){
//		
//		List<TvDTO> list = new ArrayList<>();
//		
//		return list;
//	}
	
	public List<MainDTO> board(String keyword){
		
		List<MainDTO> list = new ArrayList<>();
		
		return list;
	}
}
