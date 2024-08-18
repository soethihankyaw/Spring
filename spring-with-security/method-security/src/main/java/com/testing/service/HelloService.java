package com.testing.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloService {
	
	
	
	public String getName(Authentication authentication) {
		return authentication.getName();
	}
}
