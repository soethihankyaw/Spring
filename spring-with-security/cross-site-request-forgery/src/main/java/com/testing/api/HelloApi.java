package com.testing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello GET CSRF";
	}
	
	/*
	 *  
	 *  
	 *   
	 *   curl -X POST http://localhost:8080/hello \
     -H 'Cookie: JSESSIONID=6CE9C7959241A17D7B8E238A598A86D7' \  Get from header after calling 
     -H 'X-CSRF-TOKEN: Syhs0hGcusVkMlwpFe4rkMghEVxrCP1ZcNZm9RLthPUm1b8ffEkN6nOq3qFJVGQbccMfpf9DPD0OMct0SbAFk3CIspAW5Igm'
*/
	@PostMapping("/hello")
	public String postHello() {
		return "Hello POST CSRF";
	}
}
