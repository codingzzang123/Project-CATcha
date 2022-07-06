package com.ib.cat.main.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class CheckCookie {
	private String ip;
	
	public boolean isCookie(HttpServletRequest request) {
		Cookie[] list = request.getCookies();
		for(Cookie cookie:list) {
			if(cookie.getName().equals("userIp")) {
				System.out.println("쿠키 있음");
				return true;
			}
		}
		System.out.println("쿠키 없음");
		/* ip주소 가져오는 부분 */
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		
		return false;
	}
	
	public void createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("userIp",ip);
		cookie.setDomain("localhost");
		cookie.setPath("/");
		// 30초간 저장
		cookie.setMaxAge(20);
		cookie.setSecure(true);
		System.out.println("쿠키 만들어짐 ");
		response.addCookie(cookie);
	}
}
