package com.example.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/leaders")
	public String showleader() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String showsystem() {
		return "systems";
	}
}
