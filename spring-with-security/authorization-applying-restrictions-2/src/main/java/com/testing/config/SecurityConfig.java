package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(c -> c.disable());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(
				c -> c.requestMatchers(HttpMethod.GET, "/a")
						.authenticated()
						.requestMatchers(HttpMethod.POST, "/a")
						.permitAll()
						.requestMatchers("/a/b/**")
						.permitAll()
						.requestMatchers("/video/{email:.*(?:.+@.+\\\\.com)}").permitAll()
						.anyRequest().denyAll()
				);
		return http.build();
	}
}
