package com.unmsm.sisprov.service.interf;

import java.util.List;

import com.unmsm.sisprov.model.ProductoModel;

public interface IProductoService {

	public List<ProductoModel> listarProductos();
	public ProductoModel buscarProducto(int id);
	public void registrarProducto(ProductoModel prod);
	public void actualizarProducto(ProductoModel prod);
	
}
