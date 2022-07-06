package com.ib.cat.acc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ib.cat.acc.member.MemberDto;

@Controller
public class LoginController {
	

	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login() {

		return "member/login";
	}
	
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String sign(HttpServletRequest req, @Valid MemberDto md, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "member/sign";
//		}
		
		MultipartFile mfile = md.getFile();
		md.setImgo(md.getFile().getOriginalFilename());
		System.out.println(md.getImgo());
		
		System.out.println(req.getServletContext().getRealPath("/"));
		System.out.println(md.getId());
		System.out.println(md.getPw());
		System.out.println(md.getName());
		System.out.println(md.getEmail());
		
		return "member/login";
	}
	

}
