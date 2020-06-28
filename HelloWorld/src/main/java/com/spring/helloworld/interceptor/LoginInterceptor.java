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
		logger.info("====== preHandle ȣ��");
		// targetUrl�� ��û �Ű�����(request parameter)�� �ִ� ����
		// ���ǿ� �� ������ ����
		String url = request.getParameter("targetUrl");
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}// end preHandle
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("====== postHandle ȣ��");
		// Model ��ü�� login_result �Ӽ��� Ȯ��
		// null �ƴϸ�(�α��� ����) session ��ü�� login_id �Ӽ� �߰�, ������ �̵�
		// null �̸�(�α��� ����) ���� �������� �̵�
		
		// MemberVO ��ü Ȯ��
		MemberVO vo = (MemberVO) modelAndView.getModel()
				.get("login_result");
		
		logger.info("vo ��ü�� : " + vo);
		if(vo != null) {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("loginId", vo.getUserid()); // ���ǿ� login_id �Ӽ� �߰�
			session.setAttribute("loginName", vo.getUser_name());
			
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			}else {
				response.sendRedirect("/helloworld");
			}
		}else {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("login_fail", "fail");
			response.sendRedirect("/helloworld/user/login");
		}
		
	} // end postHandle()

} // end LoginInterceptor
