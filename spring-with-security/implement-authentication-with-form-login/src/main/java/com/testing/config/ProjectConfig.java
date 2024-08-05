package com.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    /*
     * handle form login with defaultSuccessUrl 
     */
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		
//		http.formLogin(c -> c.defaultSuccessUrl("/home", true));
//		
//		http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
//		
//		return http.build();
//	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsManager = new InMemoryUserDetailsManager();
		
		userDetailsManager.createUser(
				User.withDefaultPasswordEncoder()
					.username("soethi")
					.password("12345")
					.authorities("read")
					.build()
					);
		
		return userDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.httpBasic(Customizer.withDefaults());
		
		http.formLogin(c -> 
				c.successHandler(customAuthenticationSuccessHandler)
				 .failureHandler(customAuthenticationFailureHandler)
				);
		
		http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
		
		return http.build();
	}
}
