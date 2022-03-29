package ar.edu.asap.practica0.modelo;

public class Spock extends PiedraPapelTijeraFactory {

	public Spock() {
		// TODO Auto-generated constructor stub
		this("Spock", PiedraPapelTijeraFactory.SPOCK);
	}
	
	public Spock(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean itsMe(int pNum) {
		// TODO Auto-generated method stub
		return pNum == PiedraPapelTijeraFactory.SPOCK;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPTF) {
		// TODO Auto-generated method stub
		int result = 0;
		
		switch (pPTF.getNumero()) {
			case PiedraPapelTijeraFactory.TIJERA:
				result = 1;
				this.descripcionResultado = nombre + " gana a " + pPTF.getNombre();
				break;
			case PiedraPapelTijeraFactory.PIEDRA:
				result = 2;
				this.descripcionResultado = nombre + " gana a " + pPTF.getNombre();
				break;
			case (PiedraPapelTijeraFactory.LAGARTO):
				result = -1;
				this.descripcionResultado = nombre + " pierde con " + pPTF.getNombre();
				break;	
			case (PiedraPapelTijeraFactory.PAPEL):
				result = -2;
				this.descripcionResultado = nombre + " pierde con " + pPTF.getNombre();
				break;	
			default:
				this.descripcionResultado = nombre + " empata con " + pPTF.getNombre();
				break;
		}	
		
		return result;
	}

}
