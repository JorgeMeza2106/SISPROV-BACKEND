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
		return "Prueba";
	}
}
