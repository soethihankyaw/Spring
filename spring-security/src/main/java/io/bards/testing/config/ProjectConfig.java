package io.bards.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
		
		var user = User.withUsername("soethi")
				.password("12345")
				.authorities("read")
				.build();
		
		var userDetails = new InMemoryUserDetailsManager(user);
		http.userDetailsService(userDetails);
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new PlainPasswordEncoder();
	}
}
