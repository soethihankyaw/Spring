package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var uds = new InMemoryUserDetailsManager();
		
		var user1 = User.withUsername("soethi")
						.password("12345")
						.authorities("write", "read")
						.build();
		
		var user2 = User.withUsername("hankyaw")
				.password("12345")
				.authorities("read")
				.build();
		
		uds.createUser(user1);
		uds.createUser(user2);
		
		return uds;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PlainPasswEncoder();
	}
}
