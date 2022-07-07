package com.ib.cat.media.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;

import com.ib.cat.media.vo.ContentsVO;
import com.ib.cat.media.vo.CreditsVO;
import com.ib.cat.media.vo.GenresVO;


@Controller
public class ContentsUtil {
	
	private final String KEY="e8b937d602d4a3d3bda9a5be4c9a6a44";
	//API를 통해 추출한 json 형태의 결과값을 저장할 변수
	private String result ="";

	public int getTotalResults(String type, String sortBy) {

		int pages = 10;

		int getTotalResults=0;
		
		try {
			for (int i = 1; i <= pages ; i++) {
				String apiURL = "https://api.themoviedb.org/3/discover/" + type + "?api_key=" + KEY
						+ "&language=ko&sort_by="+sortBy+"&page=" + i;
				URL url = new URL(apiURL);
				
				BufferedReader bf;
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				result = bf.readLine();
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
				getTotalResults = Integer.parseInt(String.valueOf(jsonObject.get("total_results")));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return getTotalResults;
	}

	public ContentsVO getSpecificContent(String type, int contentsNum) {
		System.out.println("getSpecificContent Util 작동 중");
		ContentsVO sContent = null;
		List<String> genreList = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = "0001-01-01";
		try {
			sContent = new ContentsVO();
			
			URL url = new URL("https://api.themoviedb.org/3/"+type+"/"+contentsNum+"?api_key="+KEY+"&language=ko");
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				
			result = bf.readLine();
				
			JSONParser jsonParser = new JSONParser();
			JSONObject contents = (JSONObject)jsonParser.parse(result);

				ContentsVO vo = new ContentsVO();
				vo.setContentsNum(Integer.parseInt(String.valueOf(contents.get("id"))));
				vo.setContentsType(type);
				vo.setOverview(contents.get("overview").toString());
				
				//컨텐츠 타입에 따라 파싱 방법 다르게 설정
				if(type.equals("movie")) {
					//시리즈일 경우 release_date를 key로 데이터 파싱
					if(contents.get("release_date") == null || contents.get("release_date").equals("")) {
						vo.setReleaseDate(dateFormat.parse(date));
					} else {
						Date releaseDate = dateFormat.parse((String)contents.get("release_date"));
						vo.setReleaseDate(releaseDate);
					}
					vo.setTitle(contents.get("title").toString());
				} else if (type.equals("tv")) {
					//시리즈인 경우 releaseAirDate를 key로 데이터 파싱
					if(contents.get("first_air_date") == null || contents.get("first_air_date").equals("")) {
						vo.setReleaseDate(dateFormat.parse(date));
					} else {
						Date firstAirDate = dateFormat.parse((String)contents.get("first_air_date"));
						vo.setReleaseDate(firstAirDate);
					}
					//시리즈일 경우 title이 아닌 name을 key로 데이터 파싱
					vo.setTitle(contents.get("name").toString());
				}
				if(contents.get("poster_path") == null || contents.get("poster_path").toString().equals("")) {
					vo.setPosterPath("");
				} else {
					vo.setPosterPath(contents.get("poster_path").toString());
				}
				
				//runtime
				String runtime = String.valueOf(contents.get("runtime"));
//				int runtime = Integer.parseInt((String) contents.get("runtime"));
//				int hour = runtime/60;
//				int minute = runtime%60;
//				vo.setHour(hour);
//				vo.setMinute(minute);
				vo.setRuntime(runtime);
				
				JSONArray genreListJ = (JSONArray)contents.get("genres"); 
				List<GenresVO> tmpls = new ArrayList<>();
				for (int k = 0 ; k < genreListJ.size() ; k++) {		 
					JSONObject tmp = (JSONObject)genreListJ.get(k);
					int tempId = (Integer.parseInt(tmp.get("id").toString()));
					String tempName = tmp.get("name").toString();
					GenresVO gvo =  new GenresVO();
					gvo.setGenreId(tempId);
					gvo.setGenreName(tempName);
					tmpls.add(gvo);
					
//					GenresVO genresVO = new GenresVO();
//					JSONObject tmp = (JSONObject)genreListJ.get(k); //JSONObject : {"id": ,"name": } 하나!
//					genresVO.setGenreId(Integer.parseInt(tmp.get("id").toString()));
//					genresVO.setGenreName(tmp.get("name").toString());
//					System.out.println(genresVO);
//					vo.setGenresVO(genresVO);
				}
				vo.setLs(tmpls);
				System.out.println(vo.getLs().size());
				for(GenresVO g : vo.getLs())
					System.out.println("id: "+g.getGenreId()+"\n"
							+"name : "+g.getGenreName());
				System.out.println();
				sContent = vo;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sContent;
	}
	
	//특정 페이지의 List 가져오기
	public List<ContentsVO> getInfoPageList(String type, String sortBy, int page) {
		//int pages = getPages(type, sortBy);	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = "0001-01-01";
		
		List<ContentsVO> infoList = null;
		List<Integer> genreList = null;
		
		try {
			infoList = new ArrayList<ContentsVO>();
			URL url = new URL("https://api.themoviedb.org/3/discover/"+type+"?api_key="+KEY
						+"&language=ko&sort_by="+sortBy+"&page="+page);
				System.out.println("MovieData - sortBy: " + sortBy);
				System.out.println("MovieData - type: "+type);
				System.out.println("MovieData - page: "+page);
			BufferedReader bf;
				
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				
			result = bf.readLine();
				
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);

			JSONArray list = (JSONArray)jsonObject.get("results");
			
			int totalPages = Integer.parseInt(String.valueOf(jsonObject.get("total_pages")));
			int totalResults = Integer.parseInt(String.valueOf(jsonObject.get("total_results")));
								
			for (int j = 0 ; j < list.size() ; j++) {
				ContentsVO vo = new ContentsVO();
				JSONObject contents = (JSONObject)list.get(j);
					
				vo.setContentsNum(Integer.parseInt(String.valueOf(contents.get("id"))));
				vo.setContentsType(type);
				vo.setOverview(contents.get("overview").toString());
				vo.setVoteAverage(Float.parseFloat(String.valueOf(contents.get("vote_average"))));
				vo.setPopularity(Float.parseFloat(String.valueOf(contents.get("popularity"))));
					
				//컨텐츠 타입에 따라 파싱 방법 다르게 설정
					if(type.equals("movie")) {
						//시리즈일 경우 release_date를 key로 데이터 파싱
						if(contents.get("release_date") == null || contents.get("release_date").equals("")) {
							vo.setReleaseDate(dateFormat.parse(date));
						} else {
							Date releaseDate = dateFormat.parse((String)contents.get("release_date"));
							vo.setReleaseDate(releaseDate);
						}
						vo.setTitle(contents.get("title").toString());
					} else if (type.equals("tv")) {
						//시리즈인 경우 releaseAirDate를 key로 데이터 파싱
						if(contents.get("first_air_date") == null || contents.get("first_air_date").equals("")) {
							vo.setReleaseDate(dateFormat.parse(date));
						} else {
							Date firstAirDate = dateFormat.parse((String)contents.get("first_air_date"));
							vo.setReleaseDate(firstAirDate);
						}
						//시리즈일 경우 title이 아닌 name을 key로 데이터 파싱
						vo.setTitle(contents.get("name").toString());
					}
					if(contents.get("poster_path") == null || contents.get("poster_path").toString().equals("")) {
						vo.setPosterPath("");
					} else {
						vo.setPosterPath(contents.get("poster_path").toString());
					}
					//장르 id를 List<Integer>형태로 저장 -> 장르 비교를 위한 작업
					JSONArray genreListJ = (JSONArray)contents.get("genre_ids");
					genreList = new ArrayList<Integer>();
					for (int k = 0 ; k < genreListJ.size() ; k++) {
						genreList.add(Integer.parseInt(String.valueOf(genreListJ.get(k))));
					}
					vo.setGenres(genreList);
					vo.setTotalPages(totalPages);
					vo.setTotalResults(totalResults);
					infoList.add(vo);
				}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return infoList;
		
	}
	//전체 List 가져오기
	public List<ContentsVO> getInfoList(String type, String sortBy) {
		
		int pages = getPages(type, sortBy);	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = "0001-01-01";
		
		List<ContentsVO> infoList = null;
		List<Integer> genreList = null;
		
		try {
			infoList = new ArrayList<ContentsVO>();
			
			for (int i = 1; i <= pages ; i++) {
				
				URL url = new URL("https://api.themoviedb.org/3/discover/"+type+"?api_key="+KEY
						+"&language=ko&sort_by="+sortBy+"&page="+i);
				
				BufferedReader bf;
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				
				result = bf.readLine();
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
				JSONArray list = (JSONArray)jsonObject.get("results");
								
				for (int j = 0 ; j < list.size() ; j++) {
					ContentsVO vo = new ContentsVO();
					JSONObject contents = (JSONObject)list.get(j);
					
					vo.setContentsNum(Integer.parseInt(String.valueOf(contents.get("id"))));
					vo.setContentsType(type);
					vo.setOverview(contents.get("overview").toString());
					vo.setVoteAverage(Float.parseFloat(String.valueOf(contents.get("vote_average"))));
					vo.setPopularity(Float.parseFloat(String.valueOf(contents.get("popularity"))));
					
					//컨텐츠 타입에 따라 파싱 방법 다르게 설정
					if(type.equals("movie")) {
						//시리즈일 경우 release_date를 key로 데이터 파싱
						if(contents.get("release_date") == null || contents.get("release_date").equals("")) {
							vo.setReleaseDate(dateFormat.parse(date));
						} else {
							Date releaseDate = dateFormat.parse((String)contents.get("release_date"));
							vo.setReleaseDate(releaseDate);
						}
						vo.setTitle(contents.get("title").toString());
					} else if (type.equals("tv")) {
						//시리즈인 경우 releaseAirDate를 key로 데이터 파싱
						if(contents.get("first_air_date") == null || contents.get("first_air_date").equals("")) {
							vo.setReleaseDate(dateFormat.parse(date));
						} else {
							Date firstAirDate = dateFormat.parse((String)contents.get("first_air_date"));
							vo.setReleaseDate(firstAirDate);
						}
						//시리즈일 경우 title이 아닌 name을 key로 데이터 파싱
						vo.setTitle(contents.get("name").toString());
					}
					if(contents.get("poster_path") == null || contents.get("poster_path").toString().equals("")) {
						vo.setPosterPath("");
					} else {
						vo.setPosterPath(contents.get("poster_path").toString());
					}
//					vo.setPage(Integer.parseInt((String)jsonObject.get("page")));
					vo.setPage(i);
					
					//장르 id를 List<Integer>형태로 저장 -> 장르 비교를 위한 작업
					JSONArray genreListJ = (JSONArray)contents.get("genre_ids");
					genreList = new ArrayList<Integer>();
					for (int k = 0 ; k < genreListJ.size() ; k++) {
						genreList.add(Integer.parseInt(String.valueOf(genreListJ.get(k))));
					}
					vo.setGenres(genreList);
					infoList.add(vo);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return infoList;
	}
	
	public int getPage(String type) {
		int page = 0;
		
		try {
			URL url = new URL("https://api.themoviedb.org/3/discover/"+type+"?api_key="+KEY
					+"&language=ko&sort_by=popularity.desc");
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			result = bf.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			String pageS = jsonObject.get("page").toString();
			page = Integer.parseInt(pageS);
			
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		
		return page;	
		
	}
	
	public int getPages(String type, String sortBy) {
		int pages = 0;
		
		try {
			URL url = new URL("https://api.themoviedb.org/3/discover/"+type+"?api_key="+KEY
					+"&language=ko&sort_by="+sortBy);
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			result = bf.readLine();
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			String pagesS = jsonObject.get("total_pages").toString();
			pages = Integer.parseInt(pagesS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	public List<String> getImages(String type, int id) {
		//이미지 주소 - String
		List<String> imageList = null;
		
		try {
		imageList = new ArrayList<String>();
		String apiURL = "https://api.themoviedb.org/3/" + type + "/" + id + "/images?api_key=" + KEY;
		URL url = new URL(apiURL);
		BufferedReader bf;
		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
		result = bf.readLine();
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
		JSONArray list = (JSONArray)jsonObject.get("backdrops");
		
		for (int j = 0 ; j < list.size() ; j++) {
			String filePath = new String();
			JSONObject images = (JSONObject)list.get(j);
			filePath = images.get("file_path").toString();
			imageList.add(filePath);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageList;
	}
	
	public List<CreditsVO> getCredits(String type, int id, String kind) {
		List<CreditsVO> creditList = null;
		
		try {
			creditList = new ArrayList<CreditsVO>();
			String apiURL = "https://api.themoviedb.org/3/" + type + "/" + id + "/credits?api_key=" + KEY;
			URL url = new URL(apiURL);
			
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			result = bf.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			JSONArray list = (JSONArray)jsonObject.get(kind);
			
			/*배우 목록*/
			if(kind.equals("cast")) {
				for (int i = 0 ; i < list.size() ; i++) {
					JSONObject credits = (JSONObject)list.get(i);
					CreditsVO vo = new CreditsVO();
					if (credits.get("known_for_department").equals("Acting")) {
						vo.setName(credits.get("name").toString());
						if(credits.get("profile_path") == null) {
							vo.setProfilePath("");
						} else {
							vo.setProfilePath(credits.get("profile_path").toString());
						}
						creditList.add(vo);
					}
				}
				/*감독 목록*/
			} else if (kind.equals("crew")) {
				for (int i = 0 ; i < list.size() ; i++) {
					JSONObject credits = (JSONObject)list.get(i);
					CreditsVO vo = new CreditsVO();
					if (credits.get("known_for_department").equals("Directing")) {
						vo.setName(credits.get("name").toString());
						if(credits.get("profile_path") == null) {
							vo.setProfilePath("");
						} else {
							vo.setProfilePath(credits.get("profile_path").toString());
						}
						creditList.add(vo);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creditList;
	}

}
