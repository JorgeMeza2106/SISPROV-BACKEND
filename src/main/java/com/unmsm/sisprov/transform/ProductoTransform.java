package com.unmsm.sisprov.transform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unmsm.sisprov.entity.Categoria;
import com.unmsm.sisprov.entity.Producto;
import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.model.ProductoModel;

@Component
public class ProductoTransform implements Transform<ProductoModel, Producto>{

	@Autowired
	CategoriaTransform categoriaTransform;
	
	@Override
	public Producto transformME(ProductoModel oModel) {
		Producto prodEntity = new Producto();
		
		prodEntity.setIdProducto(oModel.getId_prod());
		prodEntity.setNombre(oModel.getNombre());
		prodEntity.setDescripcion(oModel.getDescrip());
		prodEntity.setPrecio(new BigDecimal(oModel.getPrecio()));
		prodEntity.setStock(oModel.getStock());
		prodEntity.setImg(oModel.getImg());
		
		Categoria categoriaEntity = new Categoria();
		categoriaEntity.setIdCategoria(oModel.getId_cat());
		
		prodEntity.setCategoria(categoriaEntity);
		
		return prodEntity;
	}

	@Override
	public List<Producto> transformME(List<ProductoModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoModel transformEM(Producto oEntity, boolean cascada) {
		ProductoModel productoModel = new ProductoModel();
		
		productoModel.setId_prod(oEntity.getIdProducto());
		productoModel.setNombre(oEntity.getNombre());
		productoModel.setDescrip(oEntity.getDescripcion() == null ? "" : oEntity.getDescripcion());
		productoModel.setPrecio(oEntity.getPrecio().floatValue());
		productoModel.setStock(oEntity.getStock());
		productoModel.setImg(oEntity.getImg() == null ? "" : oEntity.getImg());
		productoModel.setId_cat(oEntity.getCategoria().getIdCategoria());
		if(cascada) {
			productoModel.setNomb_cat(oEntity.getCategoria().getNombreCat());
			productoModel.setDescrip_cat(oEntity.getCategoria().getDescripCat());
		}
		
		return productoModel;
	}

	@Override
	public List<ProductoModel> transformEM(List<Producto> lEntity, boolean cascada) {
		List<ProductoModel> productos = new ArrayList<>();
		for(Producto productoEntity : lEntity) {
			productos.add(transformEM(productoEntity, cascada));
		}
		return productos;
	}
	
}
