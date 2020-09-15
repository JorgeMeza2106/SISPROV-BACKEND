package com.unmsm.sisprov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.sisprov.model.ProductoInfoModel;
import com.unmsm.sisprov.model.ProductoModel;
import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;
import com.unmsm.sisprov.service.interf.IProformaDetalleService;

@Service
public class ProformaDetalleService implements IProformaDetalleService{

	@Autowired
	ProductoService prodService;
	
	@Override
	public ProformadetalleModel[] cotizarProductos(ProformaReceiveModel[] prof) {
		System.out.println("coti: "+ prof[0].getQuantity());
		ProformadetalleModel[] proformasCot = new ProformadetalleModel[prof.length];
		for(int i = 0; i < prof.length ; i++) {
			proformasCot[i] = new ProformadetalleModel();
			
			int idProd = prof[i].getProductId();
			int cant = prof[i].getQuantity();
			ProductoModel prodModel = prodService.buscarProducto(idProd, false);
			
			proformasCot[i].setProductId(idProd);
			proformasCot[i].setProformaId(0);
			proformasCot[i].setQuantity(cant);
			proformasCot[i].setAppointmentId(prof[i].getAppointmentId());
			proformasCot[i].setSubmonto(cant*prodModel.getPrecio());
		}
		return proformasCot;
	}

	
}
