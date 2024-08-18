package com.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private DocumentPermissionEvaculator documentPermissionEvaculator;
	
	@Bean
	public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
		var expressionHandler = new DefaultMethodSecurityExpressionHandler();
		
		 expressionHandler.setPermissionEvaluator(documentPermissionEvaculator);
		 
		 return expressionHandler;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf( c -> c.disable());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests( a -> a.anyRequest().authenticated());
		
		return http.build();
	}
}
