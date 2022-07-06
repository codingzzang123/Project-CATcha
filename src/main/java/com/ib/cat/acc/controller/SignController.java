package com.ib.cat.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ib.cat.acc.member.MemberDao;

@Controller
public class SignController {
	
	@Autowired
	MemberDao md;
	
	@RequestMapping("member/sign")
	public String sign() {
		return "member/sign";
	}
	
	@RequestMapping(value="/member/idCheck", method = {RequestMethod.POST})
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		return md.idCheck(id);
	}
	
	@RequestMapping(value="/member/nameCheck", method = {RequestMethod.POST})
	@ResponseBody
	public int nameCheck(@RequestParam("name") String name) {
		return md.nameCheck(name);
	}
	
}
