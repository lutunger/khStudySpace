package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/result")
	public String selectId(Model model,
							String userId) {
		
		String path ="";
		
		User userInfo = service.selectUser(userId);
		
		if(userInfo == null) {
			path = "searchFail";
			
		}else {
			path = "searchSuccess";
			model.addAttribute("user", userInfo);
		}
		
		return path;
	}
	
}