package com.unmsm.sisprov.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(String mensaje) {
		System.out.println("Recieved Message From RabbitMQ: " + mensaje);
	}
	
}
