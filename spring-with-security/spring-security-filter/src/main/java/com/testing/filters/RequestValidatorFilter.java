package com.testing.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestValidatorFilter implements Filter{
	
	
	/*
	 * return with http status 400
	 * curl -v http://localhost:8080/hello 
	 * 
	 * return with http status 200
	 * curl -v -H "Request-Id:12345" http://localhost:8080/hello
	 * 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var httpRequest = (HttpServletRequest) request;
		var httpResponse = (HttpServletResponse) response;
		
		String requestId = httpRequest.getHeader("Request-Id");
		
		if(requestId == null || requestId.isBlank()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		chain.doFilter(request, response);
	}

}
