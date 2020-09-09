package com.unmsm.sisprov.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.ProductoInfoModel;
import com.unmsm.sisprov.model.ProductoModel;
import com.unmsm.sisprov.repository.IProductoRepo;
import com.unmsm.sisprov.service.impl.ProductoInfoService;
import com.unmsm.sisprov.service.impl.ProductoService;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	ProductoInfoService productoInfoService;
	
	@GetMapping("/listar")
	public List<ProductoModel> listarProductos(){
		return productoService.listarProductos();
	}
	
	@GetMapping("/listarinfo")
	public List<ProductoInfoModel> listarProductosInfoBasica(){
		return productoInfoService.listar();
	}
	
	@GetMapping("/buscar/{idProd}")
	public ProductoModel buscarProducto(
			@PathVariable("idProd") int idProd
			){
		return productoService.buscarProducto(idProd, true);
	}
	
	@PostMapping("/registrar")
	public void registrarProducto(@RequestBody ProductoModel prodNuevo) {
		productoService.registrarProducto(prodNuevo);
	}
	
	@PutMapping("/actualizar")
	public void actualizarProducto(@RequestBody ProductoModel prodNuevo) {
		productoService.actualizarProducto(prodNuevo);
	}
	
}
