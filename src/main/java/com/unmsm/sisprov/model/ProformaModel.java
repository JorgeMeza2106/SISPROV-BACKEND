package com.unmsm.sisprov.model;

import java.util.Date;

public class ProformaModel {
	private int idProforma;
	private String cliente;
	private Date fecha;
	private float montoTotal;
	
	public int getIdProforma() {
		return idProforma;
	}
	public void setIdProforma(int idProforma) {
		this.idProforma = idProforma;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
}
