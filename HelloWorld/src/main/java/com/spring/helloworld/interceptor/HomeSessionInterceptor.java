package com.spring.helloworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// homeId 세션 생성 인터셉터
public class HomeSessionInterceptor extends HandlerInterceptorAdapter{
	Logger logger = LoggerFactory.getLogger(HomeSessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =request.getSession();
		
		String homeId = (String)session.getAttribute("homeId");
		String homeParameter = (String) request.getParameter("homeId");
		String loginId = (String)request.getSession().getAttribute("loginId");
		
		// 로그인 세션 없을 시 로그인 화면으로 리다이렉트
		if(loginId == null ) {
			response.sendRedirect("/helloworld/user/login");
			return false;
		}
		
		// homeParameter 값을 받아 homeId Session 생성
		session.setAttribute("homeId", homeParameter);
		
		
		
		
		return true;
	}

	
	

}