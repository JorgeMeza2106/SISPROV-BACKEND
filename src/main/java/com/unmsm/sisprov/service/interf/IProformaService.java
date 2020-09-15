package com.unmsm.sisprov.service.interf;

import java.util.List;

import com.unmsm.sisprov.model.ProformaModel;

public interface IProformaService {
	public List<ProformaModel> listar();
	public void registrar(ProformaModel proforma);
}
