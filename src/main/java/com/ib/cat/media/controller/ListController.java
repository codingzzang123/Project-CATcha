package com.ib.cat.media.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ib.cat.media.SortCriteria;
import com.ib.cat.media.service.ContentsUtil;
import com.ib.cat.media.service.PagingUtil;
import com.ib.cat.media.vo.ContentsVO;

@Controller
public class ListController {

	private ContentsUtil contentsUtil;
	@Autowired
	public void setContentsUtil(ContentsUtil contentsUtil) {
		this.contentsUtil = contentsUtil;
	}
	
	private PagingUtil pagingUtil;
	@Autowired
	public void setPagingUtil(PagingUtil pagingUtil) {
		this.pagingUtil = pagingUtil;
	}
	
	@RequestMapping(value="/movie/list")
	public ModelAndView main(
			HttpServletRequest request, 
			Model model, SortCriteria cri, 
			@RequestParam(value="type", defaultValue="movie")String contentsType,
			@RequestParam(value="page", defaultValue="1")Integer currentPage) {
		
		System.out.println("cat:" + cri.getCategory());
		
		String category;
		category = cri.getCategory(); //cri.getCategory -> String sortBy
		if (category==null) {		//기본값 인기도 내림차순
			category="popularity.desc";
			System.out.println("Controller 첫단 category: "+category);
			System.out.println("Controller currentPage: " + currentPage);
		}

		List<ContentsVO> movieList = null;
		movieList = contentsUtil.getInfoPageList(contentsType, category, currentPage);
		System.out.println("Ctrl - contentsType: "+contentsType);
		System.out.println("Ctrl - category: "+category);
		
		//PagingUtil작업..!!
		String paging = null;
		/*pagingUtil 생성자에 들어갈 totalPage - json 파싱 결과물에서 가져오기*/
//		int totalPage = movieList.get(0).getTotalPages();
		int totalPage = 500;//무료 API로 호출시 500page까지만 제공돼서 그냥 500으로 기재
		if(currentPage > totalPage) {
			currentPage = totalPage;
		}
		String listUrl = request.getContextPath()+"/movie/list";
		
		paging = pagingUtil.paging(currentPage, totalPage, listUrl); 
		paging = paging.replaceAll("#####",  category); //url에 들어있는 특수문자${가 해석이 안 돼서 바꿈
		System.out.println(paging);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movie/list");
		mav.addObject("movieList", movieList);
		mav.addObject("category", category);
		mav.addObject("scmd", cri);
		mav.addObject("page", currentPage);
		mav.addObject("paging", paging);

		return mav;
	}

}
