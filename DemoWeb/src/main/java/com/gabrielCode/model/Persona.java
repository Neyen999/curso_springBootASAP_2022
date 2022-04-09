package com.gabrielCode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	// atributos
	
	@Id
	@Column(name="PER_ID", length = 11)
	private int codigo;
	@Column(name="PER_NOMBRE", length = 50)
	private String nombre;
	
	// constructores
	
	public Persona() {}
	
	public Persona(int pCod, String pNom) {
		codigo = pCod;
		nombre = pNom;
	}
	
	
	// accesors
	
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
	
}
