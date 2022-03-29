package ar.edu.asap.practica0.modelo;

public class Tijera extends PiedraPapelTijeraFactory {

	public Tijera() {
		this("Tijera", PiedraPapelTijeraFactory.TIJERA);
	}
	
	public Tijera(String nombre, int numero) {
		super(nombre, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean itsMe(int pNum) {
		// TODO Auto-generated method stub
		// Esto va a ser verdadero cuando el parámetro sea TIJERA
		return pNum == PiedraPapelTijeraFactory.TIJERA;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPTF) {
		// TODO Auto-generated method stub
		int result = 0;
		
		switch (pPTF.getNumero()) {
			case PiedraPapelTijeraFactory.PAPEL:
				result = 1;
				this.descripcionResultado = nombre + " gana a " + pPTF.getNombre();
				break;
			case PiedraPapelTijeraFactory.LAGARTO:
				result = 2;
				this.descripcionResultado = nombre + " gana a " + pPTF.getNombre();
				break;
			case PiedraPapelTijeraFactory.PIEDRA:
				result=-1;
				this.descripcionResultado = nombre + " pierde con " + pPTF.getNombre();
				break;
			case PiedraPapelTijeraFactory.SPOCK:
				result= -2;
				this.descripcionResultado = nombre + " pierde con " + pPTF.getNombre();
				break;	
			default:
				this.descripcionResultado = nombre + " empata con " + pPTF.getNombre();
				break;
		}	
		
		return result;

	}

}
