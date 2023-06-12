package com.baemin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	// 마이 페이지 이동
	@GetMapping("/myPage")
	public String myPage() {
		return "user/myPage";
	}
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

}
