package com.unmsm.sisprov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.service.impl.CategoriaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public List<CategoriaModel> listarCategorias(){
		return categoriaService.listarCategorias();
	}
}
