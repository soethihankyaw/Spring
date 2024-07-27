package com.testing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldApi {
	
	@GetMapping("hello")
	public String HelloApi() {
		return "Hello Security Filter Chain";
	}
}
