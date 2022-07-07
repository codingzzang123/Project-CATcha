package com.ib.cat.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ib.cat.main.service.Search;

@Controller
public class SearchController {

	@Autowired
	private Search search;
	
	@PostMapping("/search")
	public String searchform(Model model, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		
		
		
		model.addAttribute("keyword", keyword);
		return "main/search";
	}
	/*
	 * https://api.themoviedb.org/3/search/movie?api_key=e8b937d602d4a3d3bda9a5be4c9a6a44&language=ko-KR&page=1&query="키워드"
	 * */
	@GetMapping("/search")
	public String redirectAction() {
		return "redirect:/main";
	}
}
