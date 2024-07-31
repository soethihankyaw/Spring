package com.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ImplementAuthenticationSecurityContextApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementAuthenticationSecurityContextApplication.class, args);
	}

}
