package com.ib.cat.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ib.cat.main.model.MainDao;

@Controller
public class TestConroller {

	@Autowired
	private MainDao dao;
	
	@RequestMapping("/main/test")
	public String testForm(Model model) {
		model.addAttribute("ls",dao.getTopFive());
		return "main/test";
	}
}
