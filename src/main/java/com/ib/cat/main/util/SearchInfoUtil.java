package com.ib.cat.main.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ib.cat.main.dto.MainDTO;
import com.ib.cat.main.dto.MovieDTO;
import com.ib.cat.main.dto.SearchBoardDTO;
import com.ib.cat.main.dto.SearchCountDTO;
import com.ib.cat.main.dto.TvDTO;
import com.ib.cat.main.model.MainDao;

@Component
public class SearchInfoUtil {
	private static final String KEY = "e8b937d602d4a3d3bda9a5be4c9a6a44";
	private static final String API_URL = "https://api.themoviedb.org/3/";
	
	@Autowired
	private MainDao dao;
	
	@Autowired
	private SearchCountDTO scd;
	
	public List<MovieDTO> getMovieList(int page,String query){
		String apiURL =API_URL+ "search/movie?api_key=" + KEY +"&language=ko-KR&query="+query+"&page="+page;
		List<MovieDTO> movieList = null;

		try {
			URL url = new URL(apiURL);
			System.out.println("URL url = "+ url);
			BufferedReader bf;

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			
			String result = bf.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			JSONArray list = (JSONArray) jsonObject.get("results");
			
			movieList = new ArrayList<MovieDTO>();
			for (int j = 0; j < list.size(); j++) {
				MovieDTO vo = new MovieDTO();
				JSONObject contents = (JSONObject) list.get(j);
				
				vo.setId(contents.get("id").toString());
				vo.setOverview(contents.get("overview").toString());
				vo.setRelease_date(contents.get("release_date").toString());
				vo.setTitle(contents.get("title").toString());
				vo.setVote_average(Float.parseFloat(String.valueOf(contents.get("vote_average"))));
				if (contents.get("poster_path") == null || contents.get("poster_path").toString().equals("")) {
					vo.setPoster_path("");
				} else {
					vo.setPoster_path(contents.get("poster_path").toString());
				}
				movieList.add(vo);
			}
		}catch(Exception e) {
			
		}
		return movieList;
	}
	
	public List<TvDTO> getTvList(int page,String query){
		String apiURL =API_URL+ "search/tv?api_key=" + KEY +"&language=ko-KR&query="+query+"&page="+page;
		List<TvDTO> tvList = null;

		try {
			URL url = new URL(apiURL);
			System.out.println("URL url = "+ url);
			BufferedReader bf;

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			
			String result = bf.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			JSONArray list = (JSONArray) jsonObject.get("results");
			
			tvList = new ArrayList<TvDTO>();
			for (int j = 0; j < list.size(); j++) {
				TvDTO vo = new TvDTO();
				JSONObject contents = (JSONObject) list.get(j);
				
				vo.setId(contents.get("id").toString());
				vo.setOverview(contents.get("overview").toString());
				vo.setRelease_date(contents.get("first_air_date").toString());
				vo.setTitle(contents.get("name").toString());
				vo.setVote_average(Float.parseFloat(String.valueOf(contents.get("vote_average"))));
				if (contents.get("poster_path") == null || contents.get("poster_path").toString().equals("")) {
					vo.setPoster_path("");
				} else {
					vo.setPoster_path(contents.get("poster_path").toString());
				}

				tvList.add(vo);
			}
		}catch(Exception e) {
			
		}
		return tvList;
	}
	
	public List<MainDTO> getBoardList(int page,String query){
		int start = (page-1) * 20 + 1;
		int end = page * 20;
		
		SearchBoardDTO sbd = new SearchBoardDTO(start,end,query);
		
		List<MainDTO> boardList = dao.searchBoard(sbd);
		
		return boardList;
	}
	
	public SearchCountDTO contents(String query){
		String apiMovieURL =API_URL+ "search/movie?api_key=" + KEY +"&language=ko-KR&query="+query;
		String apiTvURL =API_URL+ "search/tv?api_key=" + KEY +"&language=ko-KR&query="+query;

		try {
			URL url = new URL(apiMovieURL);
			BufferedReader bf;

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			String result = bf.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			scd.setMovie(Integer.parseInt(jsonObject.get("total_results").toString()));
			
			url = new URL(apiTvURL);

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			result = bf.readLine();
			jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(result);
			scd.setTv(Integer.parseInt(jsonObject.get("total_results").toString()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		scd.setBoard(dao.searchBoardCount(query));
		return scd;
	}
}
