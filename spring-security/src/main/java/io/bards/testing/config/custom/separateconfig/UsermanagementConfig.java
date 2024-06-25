package io.bards.testing.config.custom.separateconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import io.bards.testing.config.PlainPasswordEncoder;

@Configuration
public class UsermanagementConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailService = new InMemoryUserDetailsManager();
		
		var user = User.withUsername("soethi")
					.password("12345")
					.authorities("read")
					.build();
		
		userDetailService.createUser(user);
		return userDetailService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PlainPasswordEncoder();
	}
}
