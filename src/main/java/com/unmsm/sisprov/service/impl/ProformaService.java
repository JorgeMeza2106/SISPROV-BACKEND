package com.unmsm.sisprov.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.entity.Proforma;
import com.unmsm.sisprov.entity.ProformadetalleId;
import com.unmsm.sisprov.model.ProformaModel;
import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;
import com.unmsm.sisprov.repository.IProformaRepo;
import com.unmsm.sisprov.service.interf.IProformaService;
import com.unmsm.sisprov.transform.ProformaTransform;

@Service
public class ProformaService implements IProformaService{

	@Autowired
	IProformaRepo proformaRepo;
	
	@Autowired
	ProformaTransform proformaTransform;
	
	@Override
	public List<ProformaModel> listar() {
		List<Proforma> proformas = proformaRepo.findAll();
		if(proformas != null) {
			System.out.println("entre a if en servuce");
			return proformaTransform.transformEM(proformas, true);
		}
		return null;
	}

	@Override
	public void registrar(ProformaModel proforma) {
		proformaRepo.save(proformaTransform.transformME(proforma));
	}
	
	public ProformaModel calcularTotal(ProformadetalleModel[] profs) {
		ProformaModel proforma = new ProformaModel();
		float montoTotal = 0;
		for(int i = 0; i<profs.length ; i++) {
			System.out.println("idprod: "+profs[i].getProductId());
			System.out.println("appoitid: "+ profs[i].getAppointmentId());
			montoTotal += profs[i].getSubmonto();
		}
		proforma.setCliente("Clinica Dental");
		Date fechaActual = new Date();
		proforma.setFecha(fechaActual);
		proforma.setIdProforma(profs[0].getAppointmentId());
		proforma.setMontoTotal(montoTotal);
		
		return proforma;
	}

}
