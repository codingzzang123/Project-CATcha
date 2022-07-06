package com.ib.cat.acc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignController {
	
	
	@RequestMapping("member/sign")
	public String sign() {
		return "member/sign";
	}
	
	
}
