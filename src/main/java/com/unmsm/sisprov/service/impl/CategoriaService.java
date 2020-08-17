package com.unmsm.sisprov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.entity.Categoria;
import com.unmsm.sisprov.model.CategoriaModel;
import com.unmsm.sisprov.repository.ICategoriaRepo;
import com.unmsm.sisprov.service.interf.ICategoriaService;
import com.unmsm.sisprov.transform.CategoriaTransform;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	ICategoriaRepo categoriaRepo;
	
	@Autowired
	CategoriaTransform categoriaTransform;
	
	@Override
	public List<CategoriaModel> listarCategorias() {
		List<Categoria> categoriasEntity = categoriaRepo.findAll();
		if(categoriasEntity != null) {
			return categoriaTransform.transformEM(categoriasEntity);
		}else {
			return null;
		}
	}

}
