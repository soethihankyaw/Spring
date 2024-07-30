package com.testing;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.testing.config.InMemoryUserDetailService;
import com.testing.config.PlainPasswordEncoder;
import com.testing.entity.Users;

@Configuration
public class BeanConfig {
	

	@Bean
	UserDetailsService userDetailsService() {
		var user = new Users("soethi", "12345", "read");
		List<UserDetails> users = List.of(user);
		return new InMemoryUserDetailService(users);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new PlainPasswordEncoder();
	}
	
	
}
