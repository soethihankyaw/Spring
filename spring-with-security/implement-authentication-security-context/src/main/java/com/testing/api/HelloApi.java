package com.testing.api;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
    
	/*
	 * curl -u user:{password from console} http://localhost:8080/hello
	 */
	@GetMapping("hello")
	public String hello(Authentication authentication) {
		return "Hello from SecurityContext " + authentication.getName();
	}
	
	/*
	 * without ProjectConfig @Async make new thread cos of spring MODE_THREADLOCAL
	 * when it run NullPointerException throw 
	 */
	@GetMapping("bye")
	@Async 
	public void bye() {
		var context = SecurityContextHolder.getContext();
		var username = context.getAuthentication().getName();
		
		 System.out.println("Bye from " + username);
	}
}
