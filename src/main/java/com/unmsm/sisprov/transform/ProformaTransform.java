package com.unmsm.sisprov.transform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.sisprov.entity.Proforma;
import com.unmsm.sisprov.model.ProformaModel;

@Component
public class ProformaTransform implements Transform<ProformaModel, Proforma>{

	@Override
	public Proforma transformME(ProformaModel oModel) {
		Proforma profEntity = new Proforma();
		profEntity.setIdProforma(oModel.getIdProforma());
		profEntity.setCliente(oModel.getCliente());
		profEntity.setFecha(oModel.getFecha());
		profEntity.setMontoTotal(new BigDecimal(oModel.getMontoTotal()));
		return profEntity;
	}

	@Override
	public List<Proforma> transformME(List<ProformaModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProformaModel transformEM(Proforma oEntity, boolean cascada) {
		ProformaModel profModel = new ProformaModel();
		profModel.setIdProforma(oEntity.getIdProforma());
		profModel.setCliente(oEntity.getCliente());
		profModel.setFecha(oEntity.getFecha());
		profModel.setMontoTotal(oEntity.getMontoTotal().floatValue());
		return profModel;
	}

	@Override
	public List<ProformaModel> transformEM(List<Proforma> lEntity, boolean cascada) {
		List<ProformaModel> proformas = new ArrayList<>();
		for(Proforma profEntity : lEntity) {
			proformas.add(transformEM(profEntity, true));
		}
		return proformas;
	}

}
