package com.testing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.testing.filters.StaticKeyAuthenticationFilter;

@Configuration
public class ProjectConfig {
	
	private final StaticKeyAuthenticationFilter filter;
	
	public ProjectConfig(StaticKeyAuthenticationFilter filter) {
		super();
		this.filter = filter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
//		http.addFilterBefore(new RequestValidatorFilter(), BasicAuthenticationFilter.class)
//			.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
		http.addFilterAt(filter, BasicAuthenticationFilter.class)
			.authorizeHttpRequests(c -> c.anyRequest().permitAll());
		
		return http.build();
	}
}
