package com.unmsm.sisprov.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProductoInfoModel;
import com.unmsm.sisprov.model.ProductoModel;

@Component
public class ProductoInfoTransform implements Transform<ProductoInfoModel, Producto> {

	@Autowired
	CategoriaTransform categoriaTransform;

	@Override
	public Producto transformME(ProductoInfoModel oModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> transformME(List<ProductoInfoModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoInfoModel transformEM(Producto oEntity) {
		ProductoInfoModel productoInfoModel = new ProductoInfoModel();

		productoInfoModel.setId_prod(oEntity.getIdProducto());
		productoInfoModel.setNombre(oEntity.getNombre());
		productoInfoModel.setDescrip(oEntity.getDescripcion() == null ? "" : oEntity.getDescripcion());

		CategoriaModel categoria = categoriaTransform.transformEM(oEntity.getCategoria());
		productoInfoModel.setCategoria(categoria);

		return productoInfoModel;
	}

	@Override
	public List<ProductoInfoModel> transformEM(List<Producto> lEntity) {
		List<ProductoInfoModel> productos = new ArrayList<>();
		for (Producto productoEntity : lEntity) {
			productos.add(transformEM(productoEntity));
		}
		return productos;
	}

}
