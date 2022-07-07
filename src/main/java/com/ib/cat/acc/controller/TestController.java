package com.ib.cat.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ib.cat.acc.service.MailService;

@Controller
public class TestController {
	@Autowired
	MailService ms;
	
	@RequestMapping("/test")
	public void sendEmail() {
		ms.emailSend("jiseong1028@naver.com");
	}
}
