package com.testing.service.reciver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RabbitListener(queues = "Hello")
public class HelloWorldReceive {
	
	@RabbitHandler
	public void handle(String message) {
		log.info(message);
	}
}
