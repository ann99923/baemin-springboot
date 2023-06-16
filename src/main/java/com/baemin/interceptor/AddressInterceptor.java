package com.baemin.interceptor;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;

public class AddressInterceptor implements HandlerInterceptor {
	
	/*
	 * 인터셉터를 사용하기 위해서는 HandlerInterceptor의 메서드를 구현해야 함
	 * 
	 * HandlerInterceptor의 메서드 3가지
		 * preHandle()  특정 uri을 호출했을 때 uri에 매핑된 컨트롤러의 메서드를 실행 하기 전에 실행하고 return 값이 true면 컨트롤러의 메서드를 실행, false면 실행X
		 * postHandle() 컨트롤러 메서드를 실행하고 화면으로 결과를 보여주기 전에 실행
		 * afterCompletion() 화면을 보여주고 난 뒤 실행
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Map<String, String> addMap = (Map<String, String>) session.getAttribute("BMaddress");
		
		if(addMap == null) {
			Cookie[] cookies = request.getCookies();
			System.out.println(cookies.length);
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("BMaddress")) {
					Gson gson = new Gson();
					addMap = gson.fromJson(URLDecoder.decode(cookies[i].getValue(), "UTF-8"), Map.class);
					
					session.setMaxInactiveInterval(3600 * 3);
					session.setAttribute("BMaddress", addMap);
				}
			}
		}
		return true;
	}
}
