package com.testing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/hola")
	public String hola() {
		return "hola";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}
}
