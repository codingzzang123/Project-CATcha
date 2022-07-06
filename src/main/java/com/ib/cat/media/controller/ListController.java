package com.ib.cat.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ib.cat.media.SortCriteria;
import com.ib.cat.media.service.ContentsUtil;
import com.ib.cat.media.vo.ContentsVO;

@Controller
public class ListController {
//	주석을 추가함
	
	private ContentsUtil contentsUtil;
	@Autowired
	public void setContentsUtil(ContentsUtil contentsUtil) {
		this.contentsUtil = contentsUtil;
	}
	
	@RequestMapping(value="/movie/list")
	public ModelAndView main(Model model, SortCriteria cri, 
			@RequestParam(value="type", defaultValue="movie")String contentsType,
			@RequestParam(value="page", defaultValue="1")Integer page) {
		
		System.out.println("cat:" + cri.getCategory());
		
		//기본값 인기도 내림차순
		String category;
		category = cri.getCategory(); //cri.getCategory -> String sortBy
		if (category==null) {
			category="popularity.desc";
			System.out.println("Controller 첫단 category: "+category);
			System.out.println("Controller page: " + page);
		}
//		else if (category.equals("popularity.asc")) {
//			category = "popularity.asc";
//		} else if(category.equals("vote_average.desc")) {
//			category = "vote_average.desc";
//		} else {
//			category = "vote_average.asc";
//		}

		List<ContentsVO> movieList = null;
		movieList = contentsUtil.getInfoPageList(contentsType, category, page);
		System.out.println("Ctrl - contentsType: "+contentsType);
		System.out.println("Ctrl - category: "+category);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movie/list");
		
		mav.addObject("movieList", movieList);
		mav.addObject("category", category);
		mav.addObject("scmd", cri);
		mav.addObject("page", page);
		//1페이지가 아닐 때 sortBy 확인해서 재정렬

		return mav;
	}

}
