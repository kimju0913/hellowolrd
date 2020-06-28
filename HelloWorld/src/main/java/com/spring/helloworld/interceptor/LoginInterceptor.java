	package com.spring.helloworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.helloworld.domain.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("====== preHandle 호출");
		// targetUrl이 요청 매개변수(request parameter)가 있는 경우는
		// 세션에 그 정보를 저장
		String url = request.getParameter("targetUrl");
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}// end preHandle
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("====== postHandle 호출");
		// Model 객체의 login_result 속성을 확인
		// null 아니면(로그인 성공) session 객체에 login_id 속성 추가, 페이지 이동
		// null 이면(로그인 실패) 메인 페이지로 이동
		
		// MemberVO 객체 확인
		MemberVO vo = (MemberVO) modelAndView.getModel()
				.get("login_result");
		
		logger.info("vo 객체값 : " + vo);
		if(vo != null) {
			logger.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginId", vo.getUserid()); // 세션에 login_id 속성 추가
			session.setAttribute("loginName", vo.getUser_name());
			
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			}else {
				response.sendRedirect("/helloworld");
			}
		}else {
			logger.info("로그인 실패");
			HttpSession session = request.getSession();
			session.setAttribute("login_fail", "fail");
			response.sendRedirect("/helloworld/user/login");
		}
		
	} // end postHandle()

} // end LoginInterceptor
