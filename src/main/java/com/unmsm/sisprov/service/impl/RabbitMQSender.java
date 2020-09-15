package com.unmsm.sisprov.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${publisher.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${publisher.rabbitmq.routingkey}")
	private String routingkey;
	
	public void send(ProformaReceiveModel[] mensaje) {
		rabbitTemplate.convertAndSend(exchange, routingkey, mensaje);
		System.out.println("Se envió mensaje a RabbitMQ");
	}
	
}
