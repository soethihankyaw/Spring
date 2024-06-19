package io.bards.testing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
	
	@GetMapping("hello")
	public String hello() {
		return "Hello Spring Security";
	}
}
