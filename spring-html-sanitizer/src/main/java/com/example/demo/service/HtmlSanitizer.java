package com.example.demo.service;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.stereotype.Service;

@Service
public class HtmlSanitizer {
	
	private final PolicyFactory policy = Sanitizers.FORMATTING
			.and(Sanitizers.LINKS)
			.and(Sanitizers.BLOCKS);
	
	public String sanitizer(String input) {
		return policy.sanitize(input);
	}
}
