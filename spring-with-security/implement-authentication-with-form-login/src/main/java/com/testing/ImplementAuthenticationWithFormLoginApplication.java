package com.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ImplementAuthenticationWithFormLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementAuthenticationWithFormLoginApplication.class, args);
	}

}
