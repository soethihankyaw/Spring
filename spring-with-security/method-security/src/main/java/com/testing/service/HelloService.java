package com.testing.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String getName(Authentication authentication) {
		return authentication.getName();
	}
}
