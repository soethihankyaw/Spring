package com.testing;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
		
	@Bean
	Queue subscriberQueue1() {
		return new Queue("subscriber1");
	}
	
	@Bean
	Queue subscriberQueue2() {
		return new Queue("subscriber2");
	}
}
