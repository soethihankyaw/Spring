package com.testing.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSubscribe {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
}
