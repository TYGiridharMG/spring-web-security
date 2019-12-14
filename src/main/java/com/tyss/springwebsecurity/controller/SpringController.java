package com.tyss.springwebsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/admin", method = {RequestMethod.GET,RequestMethod.POST})
	public String admin() {
		return "admin";
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
