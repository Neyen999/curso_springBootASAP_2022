package ar.edu.asap.practica0.modelo;

public class Tijera extends PiedraPapelTijeraFactory {

	public Tijera(String nombre, int numero) {
		super(nombre, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean itsMe(int pNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPTF) {
		// TODO Auto-generated method stub
		return 0;
	}

}
