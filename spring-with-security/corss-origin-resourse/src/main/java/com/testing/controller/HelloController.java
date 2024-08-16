package com.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		log.info("Hello Method is Called");
		return "main.html";
	}
	
	@PostMapping("/test")
//	@CrossOrigin("http://localhost:8080") //Using @CrossOrigin Annotation
	@ResponseBody
	public String test() {
		log.info("Test Method is Called");
		return "Testing";
	}
	
	
}
