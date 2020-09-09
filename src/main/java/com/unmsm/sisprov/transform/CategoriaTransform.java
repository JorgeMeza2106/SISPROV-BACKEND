package com.unmsm.sisprov.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.sisprov.entity.Categoria;
import com.unmsm.sisprov.model.CategoriaModel;

@Component
public class CategoriaTransform implements Transform<CategoriaModel, Categoria>{

	@Override
	public Categoria transformME(CategoriaModel oModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> transformME(List<CategoriaModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaModel transformEM(Categoria oEntity,boolean cascada) {
		CategoriaModel categoriaModel = new CategoriaModel();
		
		categoriaModel.setId_cat(oEntity.getIdCategoria());
		categoriaModel.setNombre(oEntity.getNombreCat());
		categoriaModel.setDescrip(oEntity.getDescripCat() == null ? "" : oEntity.getDescripCat());
		
		return categoriaModel;
	}

	@Override
	public List<CategoriaModel> transformEM(List<Categoria> lEntity, boolean cascada) {
		List<CategoriaModel> categorias = new ArrayList<>();
		for(Categoria categoriaEntity : lEntity) {
			categorias.add(transformEM(categoriaEntity, cascada));
		}
		return categorias;
	}

}
