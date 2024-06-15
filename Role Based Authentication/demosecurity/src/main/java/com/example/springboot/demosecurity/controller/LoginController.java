package com.example.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	public String show_login(){
		//return "login";
		return "fancy-login";
	}
	@GetMapping("/access-denied")
	public String show_access_denied_page() {
		return "access-denied";
	}
}
