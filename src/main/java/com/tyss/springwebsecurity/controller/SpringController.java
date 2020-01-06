package com.tyss.springwebsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tyss.springwebsecurity.bean.UserBean;
import com.tyss.springwebsecurity.service.UserDetailsServiceImpl;

@Controller
public class SpringController {
	
	@Autowired
	private UserDetailsServiceImpl service;
	
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String register(UserBean bean) {
		service.register(bean);
		return "index";
	}
	
	@RequestMapping(value = "/admin", method = {RequestMethod.GET,RequestMethod.POST})
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/user", method = {RequestMethod.GET,RequestMethod.POST})
	public String user() {
		return "user";
	}

//	@GetMapping(value = "/logout")
//	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/index";
//	}
	
//	@GetMapping(value ="/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/index";
//	}
	
//	@GetMapping(value = "/logout")
//	public String logut() {
//		SecurityContextHolder.clearContext();
//		return "redirect:/index";
//	}

	
}
