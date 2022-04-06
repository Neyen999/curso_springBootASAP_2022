package com.domain.modelo;

import java.util.Objects;

public class Alumno implements Modal, Vaciable {

	private int codigo;
	private String nombre;
	private String apellido;
	private String email;
	private String estudios;
	private String linkARepositorio;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Alumno(String email) {
		super();
		this.email = email;
	}


	public Alumno(int codigo, String nombre, String apellido, String email, String estudios, String linkARepositorio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estudios = estudios;
		this.linkARepositorio = linkARepositorio;
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




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getEstudios() {
		return estudios;
	}




	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}




	public String getLinkARepositorio() {
		return linkARepositorio;
	}




	public void setLinkARepositorio(String linkARepositorio) {
		this.linkARepositorio = linkARepositorio;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo, nombre);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && codigo == other.codigo
				&& Objects.equals(nombre, other.nombre);
	}

	


	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", estudios=" + estudios + ", linkARepositorio=" + linkARepositorio + "]";
	}




	@Override
	public boolean isEmpty() {
		return codigo 			== 0 						   		&& 
			  (nombre 			== null || nombre.isEmpty()) 		&& 
			  (apellido 		== null || apellido.isEmpty())		&&
			  (email 			== null || email.isEmpty())			&&
			  (estudios 		== null || estudios.isEmpty())  	&&
			  (linkARepositorio == null || linkARepositorio.isEmpty());
		
	}

}
