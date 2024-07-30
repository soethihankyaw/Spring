package com.testing.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Users implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String authority;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of( () -> authority);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
