package com.testing.config;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InMemoryUserDetailService implements UserDetailsService{
	
	private List<UserDetails> users;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return users.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst()
				.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
	}

}
