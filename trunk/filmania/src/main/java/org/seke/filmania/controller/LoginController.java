package org.seke.filmania.controller;

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
	public String loadLoginerrorPage(){
		return "login";
	}
	
	@RequestMapping("/denied")
	public String loadDeniedPage(){
		return "/denied";
	}
}
