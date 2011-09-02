package org.seke.filmania.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/index")
	public String loadIndexPage(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String loadLoginPage(){
		return "login";
	}
	
	@RequestMapping("/loginerror")
	public String loadLoginerrorPage(HttpServletRequest request){
		request.getSession().setAttribute("message", "doslo je do greske prilikom logovanja");
		return "redirect:/login";
	}
	
	@RequestMapping("/denied")
	public String loadDeniedPage(){
		return "/denied";
	}
}
