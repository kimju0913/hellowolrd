package com.spring.helloworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HomeSessionInterceptor extends HandlerInterceptorAdapter{
	Logger logger = LoggerFactory.getLogger(HomeSessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =request.getSession();
		
		logger.info(request.getRequestURL().toString());
		String homeId = (String)session.getAttribute("homeId");
		String homeParameter = (String) request.getParameter("homeId");
		logger.info( "=============홈파라미터 : " + homeParameter + "=========홈세션 :"+ homeId);
		//  Ķ     jsp    value      home id                         
		
		String loginId = (String)request.getSession().getAttribute("loginId");
		
		if(loginId == null ) {
			response.sendRedirect("/helloworld/user/login");
			logger.info("    ̷ ? ");
			return false;
		}
		
		if(homeParameter != null   ) {
			session.setAttribute("homeId", homeParameter);
			logger.info("homeParameter"+(String) session.getAttribute("homeId"));
			
			if(homeId != null) {
			if(!homeId.equals(homeParameter) && homeParameter != null) {
			logger.info("   ǰ   Ķ   Ͱ   ٸ    ");
				request.getSession().setAttribute("homeId", homeParameter);
			}
			}
			
		}else if( homeId ==  null ) {
			session.setAttribute("homeId", loginId);
			logger.info("homeId"+(String) session.getAttribute("homeId"));
			
			
		}

		
//		if(homeSession == null && homeParameter == null) {
//			
//			response.sendRedirect("/helloworld/user/login");
//			logger.info("    ̷ ? ");
//			
//		}
//		
//		
//		if(homeSession != null ) {
//			request.getSession().setAttribute("homeId", homeSession);
//			logger.info("   ͼ         ׽ Ʈ" + request.getSession().getAttribute("homeId"));
//			
//			if(!homeSession.equals(homeParameter) && homeParameter != null) {
//				logger.info("   ǰ   Ķ   Ͱ   ٸ    ");
//				request.getSession().setAttribute("homeId", homeParameter);
//			}
//			
//		} else if(homeSession == null) {
//			logger.info("   ǰ   Ķ   Ͱ   ٸ    ");
//			request.getSession().setAttribute("homeId", homeParameter);
//		}
		
		
		return true;
	}

	
	

}