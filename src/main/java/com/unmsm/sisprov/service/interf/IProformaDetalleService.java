package com.unmsm.sisprov.service.interf;

import com.unmsm.sisprov.model.ProformaReceiveModel;
import com.unmsm.sisprov.model.ProformadetalleModel;

public interface IProformaDetalleService {

	public ProformadetalleModel[] cotizarProductos(ProformaReceiveModel[] prof);
}
