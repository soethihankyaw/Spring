package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class BeanConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PlainPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var userDetailsService = new InMemoryUserDetailsManager();
		
		var user1 = User.withUsername("soethi")
						.password("12345")
						.roles("MANAGER")
						.build();
		
		var user2 = User.withUsername("hankyaw")
				.password("12345")
				.roles("ADMIN")
				.build();
		
		var user3 = User.withUsername("kyaw")
				.password("12345")
				.roles("USER")
				.build();
		
		userDetailsService.createUser(user1);
		userDetailsService.createUser(user2);
		userDetailsService.createUser(user3);
		
		return userDetailsService;

	}
}
