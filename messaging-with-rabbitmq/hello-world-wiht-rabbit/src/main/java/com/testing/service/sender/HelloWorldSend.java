package com.testing.service.sender;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelloWorldSend {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	private AtomicInteger count = new AtomicInteger(0);
	
	@Scheduled(fixedRate = 600)
	public void send() {
		var value = count.incrementAndGet();
		rabbitTemplate.convertAndSend(queue.getName(), "Hello World %d".formatted(value));
		log.info("Sending Message %d".formatted(value));
	}
}
