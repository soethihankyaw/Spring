package com.testing.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class MessageSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	private AtomicInteger dots = new AtomicInteger(0);
	private AtomicInteger count = new AtomicInteger(0);
	
	@Scheduled(fixedRate = 1000)
	public void send() {
		
		var messageBuilder1 = new StringBuffer("Hello RabbitMQ From Message One");
		var messageBuilder2 = new StringBuffer("Hello RabbitMQ From Message Two");
		
		if(dots.incrementAndGet() == 4) {
			dots.set(1);
		}
		
		for(var i = 0; i < dots.get(); i ++) {
			messageBuilder1.append(". ");
		}
		messageBuilder1.append(count.incrementAndGet());
		
		for(var i = 0; i < dots.get(); i ++) {
			messageBuilder2.append(". ");
		}
		messageBuilder2.append(count.incrementAndGet());
		
		rabbitTemplate.convertAndSend(queue.getName(), messageBuilder1.toString());
		rabbitTemplate.convertAndSend(queue.getName(), messageBuilder2.toString());		
	}
}
