package com.testing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.service.HelloService;

@RestController
public class HelloApi {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("hello")
	public void hello() {
		helloService.hello();
	}
	
	@GetMapping
	public String string() {
		return "Hello Spring Boot";
	}
}
