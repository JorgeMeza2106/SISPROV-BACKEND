package com.unmsm.sisprov.transform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProductoInfoModel;
import com.unmsm.sisprov.model.ProductoModel;

@Component
public class ProductoInfoTransform implements Transform<ProductoInfoModel, Producto> {

	@Override
	public Producto transformME(ProductoInfoModel oModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> transformME(List<ProductoInfoModel> lModel) {
		return null;
	}

	@Override
	public ProductoInfoModel transformEM(Producto oEntity, boolean cascada) {
		ProductoInfoModel productoInfoModel = new ProductoInfoModel();

		productoInfoModel.setId_prod(oEntity.getIdProducto());
		productoInfoModel.setNombre(oEntity.getNombre());
		productoInfoModel.setDescrip(oEntity.getDescripcion() == null ? "" : oEntity.getDescripcion());
		productoInfoModel.setId_cat(oEntity.getCategoria().getIdCategoria());
		productoInfoModel.setNomb_cat(oEntity.getCategoria().getNombreCat());
		productoInfoModel.setDescrip_cat(oEntity.getCategoria().getDescripCat());
		
		return productoInfoModel;
	}

	@Override
	public List<ProductoInfoModel> transformEM(List<Producto> lEntity, boolean cascada) {
		List<ProductoInfoModel> productos = new ArrayList<>();
		for (Producto productoEntity : lEntity) {
			productos.add(transformEM(productoEntity, cascada));
		}
		return productos;
	}

}
