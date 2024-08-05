package com.testing.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloApi {
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/unable")
	public String error() {
		return "error.html";
	}
}
