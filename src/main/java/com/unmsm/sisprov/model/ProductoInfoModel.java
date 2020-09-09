package com.unmsm.sisprov.model;

public class ProductoInfoModel {
	private int id_prod;
	private String nombre;
	private String descrip;
	private int id_cat;
	private String nomb_cat;
	private String descrip_cat;
	
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getNomb_cat() {
		return nomb_cat;
	}
	public void setNomb_cat(String nomb_cat) {
		this.nomb_cat = nomb_cat;
	}
	public String getDescrip_cat() {
		return descrip_cat;
	}
	public void setDescrip_cat(String descrip_cat) {
		this.descrip_cat = descrip_cat;
	}
	public int getId_prod() {
		return id_prod;
	}
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
}
