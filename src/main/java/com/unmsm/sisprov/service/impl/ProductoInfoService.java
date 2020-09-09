package com.unmsm.sisprov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.ProductoInfoModel;
import com.unmsm.sisprov.repository.IProductoRepo;
import com.unmsm.sisprov.service.interf.IProductoInfoService;
import com.unmsm.sisprov.transform.ProductoInfoTransform;

@Service
public class ProductoInfoService implements IProductoInfoService{

	@Autowired
	IProductoRepo productoRepo;
	
	@Autowired
	ProductoInfoTransform productoInfoTransform;
	
	@Override
	public List<ProductoInfoModel> listar() {
		List<Producto> productosEntity = productoRepo.findAll();
		if(productosEntity != null) {
			return productoInfoTransform.transformEM(productosEntity, true);
		}
		return null;
	}

	
}
