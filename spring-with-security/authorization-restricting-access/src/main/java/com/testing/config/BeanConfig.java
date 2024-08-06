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
	public UserDetailsService userDetailsService() {
		
		var userDetailsManager = new InMemoryUserDetailsManager();
		
		var user1 = User.withUsername("soethi")
						.password("12345")
						.authorities("read")
						.roles("MANAGER")
						.build();
		
		var user2 = User.withUsername("bobo")
				.password("12345")
				.authorities("write")
				.roles("ADMIN")
				.build();
		
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
		
		return userDetailsManager;
				
	}
	
	@Bean
	public PasswordEncoder passsEncoder() {
		return new PlainPasswordEncoder();
	}
}
