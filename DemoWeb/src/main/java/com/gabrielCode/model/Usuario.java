package com.gabrielCode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@Column(name = "US_CODIGO", length = 11)
	private int codigo;
	@Column(name = "US_NOMBRE", length = 255)
	private String nombre;
	private String clave;
	
	public Usuario() {}

	public Usuario(int codigo, String nombre, String clave) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.clave = clave;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
