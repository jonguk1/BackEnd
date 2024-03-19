package com.common.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.user.domain.MemberVO;

public class AdminCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession ses = request.getSession();
		MemberVO user=(MemberVO)ses.getAttribute("loginUser");
		
		if(user.getMstate() != 9) {
			request.setAttribute("msg", "�����ڸ� �̿��Ҽ� �ֽ��ϴ�");
			String loc=request.getContextPath() + "/index";
			request.setAttribute("loc", loc);
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/message.jsp");
			disp.forward(request, response);
			
			return false;
		}
		return true;
	}

}
