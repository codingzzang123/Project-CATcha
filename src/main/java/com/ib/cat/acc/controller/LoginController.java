package com.ib.cat.acc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ib.cat.acc.member.MemberDao;
import com.ib.cat.acc.member.MemberDto;
import com.ib.cat.acc.service.FileService;

@Controller
public class LoginController {
	
	@Autowired
	FileService fs;
	@Autowired
	MemberDao memberDao;
	@Autowired
	BCryptPasswordEncoder be;

	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login() {

		return "member/login";
	}
	
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String sign(HttpServletRequest req, @Valid MemberDto md, BindingResult bindingResult) {
		if(md.getId()==null) {
			return "member/login";
		}
		if(bindingResult.hasErrors()) {
			return "member/sign";
		}
		String[] img = null;
		//프로필이 null아닐때
		if(!md.getFile().isEmpty()) {
			String path = req.getServletContext().getRealPath("/resources/image/member/");
			img = fs.fileUpload(md.getFile(), path);
			md.setImgo(img[0]);
			md.setImgs(img[1]);			
		}
		//프로필이 null일때
		else {
			img = fs.nullFileUpload();
			md.setImgo(img[0]);
			md.setImgs(img[1]);
		}
		
		//비밀번호 시큐리티
		md.setPw(be.encode(md.getPw()));
		//데이터 저장
		memberDao.insert(md);
		
				
		return "member/login";
	}
	

}
