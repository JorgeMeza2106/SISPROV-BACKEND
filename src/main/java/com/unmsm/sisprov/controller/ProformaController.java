package com.unmsm.sisprov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.sisprov.model.ProformaModel;
import com.unmsm.sisprov.service.impl.ProformaService;

@RestController
@CrossOrigin
@RequestMapping("/proforma")
public class ProformaController {

	@Autowired
	ProformaService profService;
	
	@GetMapping("/listar")
	public List<ProformaModel> listar(){
		System.out.println("entro en controller");
		return profService.listar();
	}
}
