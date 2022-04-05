package ar.edu.asap.practica0.modelo;

import java.util.Date;

public class Auditoria {

	private Date fecha;
	private int cantidadDeJugadas;
	
	public Auditoria(Date fecha, int jugadas) {
		this.fecha = fecha;
		this.cantidadDeJugadas = jugadas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeJugadas() {
		return cantidadDeJugadas;
	}

	public void setCantidadDeJugadas(int cantidadDeJugadas) {
		this.cantidadDeJugadas = cantidadDeJugadas;
	}

	public void contarDespuesDeLaJugada() {}
	
}
