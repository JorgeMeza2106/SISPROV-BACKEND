package com.unmsm.sisprov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.service.impl.RabbitMQSender;

@RestController
@CrossOrigin
@RequestMapping("/rabbitmq")
public class RabbitMQController {

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@GetMapping(value = "/producer")
	public String producer() {
		ProformaReceiveModel proformas[] = new ProformaReceiveModel[2];
		proformas[0]  = new ProformaReceiveModel();
		proformas[0].setProductId(0);
		proformas[0].setQuantity(3);
		proformas[0].setAppointmentId(101);
		
		proformas[1]  = new ProformaReceiveModel();
		proformas[1].setProductId(1);
		proformas[1].setQuantity(2);
		proformas[1].setAppointmentId(101);
		
		rabbitMQSender.send(proformas);
		return "Message sent to the RabbitMQ Successfully: "+proformas.toString();
	}
}
