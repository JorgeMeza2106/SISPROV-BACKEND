package com.unmsm.sisprov.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;

@Service
public class RabbitMQConsumer {

	@Autowired
	ProformaDetalleService profService;
	
	@Autowired
	RabbitMQSender rabbitSender;
	
	@RabbitListener(queues = "${consumer.rabbitmq.queue}")
	public void recievedMessage(ProformaReceiveModel[] mensaje) {
		System.out.println("data: "+ mensaje[0].getProductId());
		System.out.println("data: "+ mensaje[0].getQuantity());
		ProformadetalleModel[] proformas = profService.cotizarProductos(mensaje);
		
		System.out.println("res 1 coti: "+ proformas[0].getSubmonto()); 
		System.out.println("res 2coti: "+ proformas[0].getSubmonto());

		rabbitSender.send(proformas);
	}
	
}
