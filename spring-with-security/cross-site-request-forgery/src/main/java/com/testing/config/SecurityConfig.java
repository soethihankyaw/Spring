package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

import com.testing.filters.CsrfTokenLoggerFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class)
			.authorizeHttpRequests( c -> c.anyRequest().permitAll());
		
		return http.build();
	}
}
