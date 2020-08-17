package com.unmsm.sisprov.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.ProductoModel;
import com.unmsm.sisprov.repository.IProductoRepo;
import com.unmsm.sisprov.service.interf.IProductoService;
import com.unmsm.sisprov.transform.ProductoTransform;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	IProductoRepo productoRepo;
	
	@Autowired
	ProductoTransform prodTransform;
	
	@Override
	public List<ProductoModel> listarProductos() {
		return prodTransform.transformEM(productoRepo.findAll());
	}

	@Override
	public ProductoModel buscarProducto(int id) {
		Optional<Producto> prodEntity = productoRepo.findById(id);
		if(prodEntity.isPresent()) {
			return prodTransform.transformEM(prodEntity.get());	
		}else {
			return null;
		}
	}

	@Override
	public void registrarProducto(ProductoModel prod) {
		if(prod != null) {
			productoRepo.save(prodTransform.transformME(prod));
		}
	}

	@Override
	public void actualizarProducto(ProductoModel prod) {
		if(prod != null) {
			productoRepo.save(prodTransform.transformME(prod));
		}
	}

}
