package com.testing;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("com.testing");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
