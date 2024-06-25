package io.bards.testing.config.custom.authprovider;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//customize Authentication provider and authentication logic
//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		var username = authentication.getName();
		var password = String.valueOf(authentication.getCredentials());
		if("soethi".equals(username) && "12345".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Authentication is not found!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
	}

}
