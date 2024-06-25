package io.bards.testing.config.custom.authprovider;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class ConfigurationForCustomAuthenticationProvider {
	
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	public ConfigurationForCustomAuthenticationProvider(CustomAuthenticationProvider customAuthenticationProvider) {
		super();
		this.customAuthenticationProvider = customAuthenticationProvider;
	}

//	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());
		http.authenticationProvider(customAuthenticationProvider);
		http.authorizeHttpRequests(
				c -> c.anyRequest().authenticated()
	);
	return http.build();
	}
	
}
