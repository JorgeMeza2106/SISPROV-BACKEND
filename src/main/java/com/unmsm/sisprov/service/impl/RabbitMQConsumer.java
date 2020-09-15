package com.unmsm.sisprov.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProformaModel;
import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;

@Service
public class RabbitMQConsumer {

	@Autowired
	ProformaDetalleService proformaDetailService;
	
	@Autowired
	ProformaService proformaService;
	
	@Autowired
	RabbitMQSender rabbitSender;
	
	@RabbitListener(queues = "${consumer.rabbitmq.queue}")
	public void recievedMessage(ProformaReceiveModel[] mensaje) {
		System.out.println("Numero de elementos recibidos: "+ mensaje.length);		
		ProformadetalleModel[] proformas = proformaDetailService.cotizarProductos(mensaje);
		rabbitSender.send(proformas);
		
		ProformaModel profNueva = proformaService.calcularTotal(proformas);
		proformaService.registrar(profNueva);
		System.out.println("Se registro nueva proforma");
	}
	
}
