package com.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HelloWorldWihtRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldWihtRabbitApplication.class, args);
	}

}
