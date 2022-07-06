 package com.ib.cat.main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ib.cat.main.model.MainDao;
import com.ib.cat.main.sort.SortByVote;
import com.ib.cat.main.util.CheckCookie;
import com.ib.cat.main.util.GetInfoUtil;
import com.ib.cat.main.util.MovieDTO;

@Controller
public class MainController {
	
	@Autowired
	private MainDao dao;
	
	@Autowired
	private CheckCookie co;
	
	/*mybatis test*/
	@RequestMapping("/main")
	public ModelAndView mainForm(HttpServletRequest request,HttpServletResponse response) {
		GetInfoUtil util = new GetInfoUtil();
		
		List<MovieDTO> nowPlay = null;
		List<MovieDTO> popular = null;
		List<MovieDTO> highLate = null;
		
		nowPlay = util.getMovieList(1);
		popular = util.getMovieList(2);
		highLate = util.getMovieList(3);

		Collections.sort(nowPlay, new SortByVote());
		Collections.sort(popular, new SortByVote());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/main");
		mav.addObject("nowPlay", nowPlay);
		mav.addObject("popular", popular);
		mav.addObject("highLate", highLate);
		
		/* 쿠키+최근 게시물 관련 Object 추가 */
		if(!co.isCookie(request)) {
			/*쿠키가 없다면*/
			co.createCookie(response);
			System.out.println("쿠키 만들어짐 @@"+co);
			dao.insert();
		}
		mav.addObject("ls",dao.getTopFive());
		mav.addObject("today",dao.getToday());
		mav.addObject("total",dao.getTotal());
		
		return mav;
	}
}
