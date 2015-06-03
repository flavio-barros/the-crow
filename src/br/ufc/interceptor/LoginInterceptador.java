package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptador extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		
		if (uri.endsWith("loginForm") || uri.endsWith("efetuarLogin")) {
			return true;
		}
		if (request.getSession().getAttribute("logadoEditor") != null) {
			return true;
		}
		response.sendRedirect("loginForm");
		return false;
	}

}
