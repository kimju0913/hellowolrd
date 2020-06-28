package com.spring.helloworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println("===================auth Interceptor Test");
		String loginId = (String)session.getAttribute("loginId");
		
		if(loginId == null) {
			System.out.println("===================auth Interceptor Test : 아이디가 없을 경우");
			response.sendRedirect("/helloworld/user/login");
			session.setAttribute("loginCheck", "none");
			return false;
		}
		
		
		return true;
	}
	
}