package com.testing.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.testing.service.HelloService;

@RestController
public class HelloApi {
	
	@Autowired
	private HelloService helloService;
	
	@PreAuthorize("hasAuthority('write')")
	@GetMapping("/hello")
	public String getName(Authentication authentication) {
		return "Hello " + helloService.getName(authentication);
	}
	
	@PreAuthorize("hasAuthority('read')")
	@GetMapping("/secret/name/{name}")
	public String getAuthority(@PathVariable String name, Authentication authentication) {
		return helloService.getName(authentication) + " have " + authentication.getAuthorities().toString() + " authority " + "and secreat name is " + name ;
	}
}


