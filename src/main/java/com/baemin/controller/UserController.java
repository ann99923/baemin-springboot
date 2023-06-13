package com.baemin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baemin.dto.Join;
import com.baemin.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	
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
	
	// 회원가입 페이지 이동
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	// 회원가입 실행
	@PostMapping("/join")
	public String joinProc(@Valid Join join, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			System.out.println("에러");
			
			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<String, String>();
			
			for(int i=0; i<list.size(); i++) {
				String field = list.get(i).getField();
				String message = list.get(i).getDefaultMessage();
				
//				System.out.println("필드: " + field);
//				System.out.println("메세지: " + message);
				
				errorMsg.put(field, message);
			}		
			model.addAttribute("errorMsg", errorMsg);
			return "user/join";
		}
		
		String encPwd = pwdEncoder.encode(join.getPassword());
		join.setPassword(encPwd);
		userService.join(join);
		
		return "redirect:/login";
	}
	
	@ResponseBody
	@GetMapping("/overlapCheck")
	public int overlapCheck(String value, String valueType) {
		// value = 중복체크할 값
		// valueType = username, nickname
		
		System.out.println(value);
		System.out.println(valueType);
		int count = userService.overlapCheck(value, valueType);
		
		System.out.println(count);
		return count;
	}

}
