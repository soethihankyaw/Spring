package com.testing.filters;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationLoggingFilter implements Filter{
	
	private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
	
	/*
	 * curl -v -H "Request-Id:12345" http://localhost:8080/hello
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var httpRequest = (HttpServletRequest) request;
		
		var requestId = httpRequest.getHeader("Request-Id");
		
		logger.info("Successfully authenticated with request id " + requestId);
		
		chain.doFilter(request, response);
	}
	
}
