package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

	/*
	 * restrict access using authority
	 */
	public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {

		http.httpBasic(Customizer.withDefaults());
		/*
		 * using hasAnyAuthority()
		 */
		http.authorizeHttpRequests(c -> c.anyRequest().hasAnyAuthority("write", "read"));

		/*
		 * using access()
		 */
//		var expression = """
//				hasAuthority('read') and hasAuthority('write')
//				""";
//		
//		http.authorizeHttpRequests(c -> c.anyRequest()
//				.access(new WebExpressionAuthorizationManager(expression)));

		return http.build();
	}

	/*
	 * restrict access using role
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.httpBasic(Customizer.withDefaults());
		/*
		 * using hasAnyRole()
		 */
		http.authorizeHttpRequests(c -> c.anyRequest().hasAnyRole("MANAGER","ADMIN"));

		return http.build();
	}
}
