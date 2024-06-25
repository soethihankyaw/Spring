package io.bards.testing.config;

import org.springframework.security.crypto.password.PasswordEncoder;

//using for Password encoder with no password
public class PlainPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
