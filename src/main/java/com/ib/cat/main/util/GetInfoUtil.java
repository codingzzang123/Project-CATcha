package com.ib.cat.main.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class GetInfoUtil {
	private static final String KEY = "e8b937d602d4a3d3bda9a5be4c9a6a44";
	private static final String API_URL = "https://api.themoviedb.org/3/";
	
	public List<MovieDTO> getMovieList(int type){
		String apiURL = null;
		List<MovieDTO> test = null;
		
		/*
		 * case 1 = 현재 상영중인 영화 
		 * case 2 = 인기있는 영화
		 * case 3 = 평점이 높은 영화
		 * */
		
		switch(type){
		case 1: apiURL=API_URL+ "movie/now_playing"  + "?api_key=" + KEY 
				+ "&language=ko-KR&region=KR"; break;
		case 2: apiURL=API_URL+ "movie/popular"  + "?api_key=" + KEY
				+ "&language=ko-KR&region=KR"; break;
		case 3: apiURL=API_URL+ "movie/top_rated"  + "?api_key=" + KEY
				+ "&language=ko-KR"; break;
		}
		
		try {
			URL url = new URL(apiURL);
			System.out.println("URL url = "+ url);
			BufferedReader bf;

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			
			String result = bf.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			JSONArray list = (JSONArray) jsonObject.get("results");
			
			test = new ArrayList<MovieDTO>();
			for (int j = 0; j < list.size(); j++) {
				MovieDTO vo = new MovieDTO();
				JSONObject contents = (JSONObject) list.get(j);
				
				vo.setId(contents.get("id").toString());
				vo.setOverview(contents.get("overview").toString());
				vo.setRelease_date(contents.get("release_date").toString());
				vo.setTitle(contents.get("title").toString());
				vo.setVote_average(Float.parseFloat(String.valueOf(contents.get("vote_average"))));
				vo.setPoster_path(contents.get("poster_path").toString());

				test.add(vo);
			}
		}catch(Exception e) {
			
		}
		return test;
	}
}
