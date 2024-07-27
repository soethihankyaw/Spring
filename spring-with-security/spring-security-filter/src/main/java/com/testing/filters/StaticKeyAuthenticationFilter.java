package com.testing.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StaticKeyAuthenticationFilter implements Filter{
	
	/*	
	 * 	this return with http status 200
	 *  curl -v -H "Authorization:SD9cICjl1e" http://localhost:8080/hello
	 *  this return with http status 401
	 *  curl -v http://localhost:8080/hello
	 */
	@Value("${authorization.key}")
	private String authorizationKey;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var httpRequest = (HttpServletRequest) request;
		var httpResponse = (HttpServletResponse) response;
		
		String authorization = httpRequest.getHeader("Authorization");
		
		if(authorizationKey.equals(authorization)) {
			chain.doFilter(request, response);
		} else {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
	
	
}
