package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(
				/*
				 * using requestMatchers
				 */
				c -> c.requestMatchers("/hello").hasRole("ADMIN")
					 .requestMatchers("/hola").hasAnyRole("MANAGER", "ADMIN")
					 .anyRequest().authenticated()
				);
		
		return http.build();
	}
}
