package com.ib.cat.main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ib.cat.main.dto.MainDTO;
import com.ib.cat.main.dto.MovieDTO;
import com.ib.cat.main.dto.SearchCountDTO;
import com.ib.cat.main.dto.TvDTO;
import com.ib.cat.main.service.PagingService;
import com.ib.cat.main.service.SearchService;
import com.ib.cat.main.util.SortMovieByVote;
import com.ib.cat.main.util.SortTvByVote;

@Controller
public class SearchController {

	@Autowired
	private SearchService search;
	
	@Autowired
	private PagingService paging;
	
	private SearchCountDTO scd;

	@RequestMapping(value={"/search", "/search/movie"})
	public String searchform1(Model model, HttpServletRequest request) {
		String query = request.getParameter("query");
		String pageNum = request.getParameter("page");
		int page;
		
		if(pageNum==null)
			page=1;
		else
			page = Integer.parseInt(pageNum);
		
		scd = search.scd(query);
		int blocks = scd.getMovie();
		
		paging.startPaging(page, blocks);
			
    	List<MovieDTO> movieList = search.movie(page,query);
    	Collections.sort(movieList, new SortMovieByVote());
    	
    	model.addAttribute("contents", movieList);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("scd", scd);
		
		/* 페이징 attribute 추가 */
	    model.addAttribute("blockStartNum",paging.getBlockStartNum()); //블럭 시작 넘버 ,
	    model.addAttribute("blockLastNum",paging.getBlockLastNum()); //추가한것1.
	    model.addAttribute("now",paging.getCurPage()); //현재 페이지 위치 
	    model.addAttribute("end",paging.getLastPageNum()); //블럭 마지막 번호	
	    model.addAttribute("type","m");
		
		return "main/search";
	}
	
	@RequestMapping(value="/search/tv")
	public String searchform2(Model model, HttpServletRequest request) {
		String query = request.getParameter("query");
		String pageNum = request.getParameter("page");
		int page;
		
		if(pageNum==null)
			page=1;
		else
			page = Integer.parseInt(pageNum);
		
		scd = search.scd(query);
		int blocks = scd.getTv();
		paging.startPaging(page, blocks);
		
    	List<TvDTO> tvList = search.tv(page,query);
    	Collections.sort(tvList, new SortTvByVote());
    	
    	model.addAttribute("contents", tvList);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("scd", scd);
		
		/* 페이징 attribute 추가 */
		model.addAttribute("blockStartNum",paging.getBlockStartNum()); //블럭 시작 넘버 ,
	    model.addAttribute("blockLastNum",paging.getBlockLastNum()); //추가한것1.
	    model.addAttribute("now",paging.getCurPage()); //현재 페이지 위치 
	    model.addAttribute("end",paging.getLastPageNum()); //블럭 마지막 번호	
		model.addAttribute("type","t");
		return "main/search";
	}
	
	@RequestMapping(value="/search/board")
	public String searchform3(Model model, HttpServletRequest request) {
		String query = request.getParameter("query");
		String pageNum = request.getParameter("page");
		int page;
		
		if(pageNum==null)
			page=1;
		else
			page = Integer.parseInt(pageNum);
		
		scd = search.scd(query);
		int blocks = scd.getBoard();
		paging.startPaging(page, blocks);
		
		List<MainDTO> boardList = search.board(page, query);
		model.addAttribute("content", boardList);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("scd", scd);
		
		/* 페이징 attribute 추가 */
		model.addAttribute("blockStartNum",paging.getBlockStartNum()); //블럭 시작 넘버 ,
		model.addAttribute("blockLastNum",paging.getBlockLastNum()); //추가한것1.
		model.addAttribute("now",paging.getCurPage()); //현재 페이지 위치 
		model.addAttribute("end",paging.getLastPageNum()); //블럭 마지막 번호	
		model.addAttribute("type","b");
		return "main/search";
	}
}
