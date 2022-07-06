 package com.ib.cat.main.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ib.cat.main.sort.SortByVote;
import com.ib.cat.main.util.GetInfoUtil;
import com.ib.cat.main.util.MovieDTO;

@Controller
public class MainController {
	/*mybatis test*/
	@RequestMapping("/main")
	public ModelAndView mainForm() {
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
		return mav;
	}
}
