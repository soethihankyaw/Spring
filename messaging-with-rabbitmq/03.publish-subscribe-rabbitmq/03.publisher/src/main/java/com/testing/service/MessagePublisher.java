package com.testing.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private FanoutExchange fanoutExchange;
	
	
	private AtomicInteger count = new AtomicInteger(0);
	private AtomicInteger dots = new AtomicInteger(0);
	
	@Scheduled(fixedRate = 1500)
	public void send() {
		var message = new StringBuffer("Hello World");
		
		if(dots.incrementAndGet() == 4) {
			dots.set(1);
		}
		
		for(var i = 0; i < dots.get(); i++) {
			message.append(".");
		}
		
		message.append("").append(count.toString());
		
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), null, message.toString());
	}
}
