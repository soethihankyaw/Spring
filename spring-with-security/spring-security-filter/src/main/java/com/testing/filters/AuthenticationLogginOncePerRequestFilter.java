package com.testing.filters;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationLogginOncePerRequestFilter extends OncePerRequestFilter{
	/*
	 * using OncePerRequestFilter is better than using Filter 
	 * cos of to avoid logging the same requests multiple times. Spring Security doesn’t guarantee the filter won’t be
		called more than once
	 */
	private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestId = request.getHeader("Request-Id");
		
		logger.info("Successfully authenticated request with id " + requestId);
		filterChain.doFilter(request, response);
	}
}	
