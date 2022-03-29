package ar.edu.asap.practica0.modelo;

public class Papel extends PiedraPapelTijeraFactory {

	public Papel() {
		this("Papel", PiedraPapelTijeraFactory.PAPEL);
	}
	
	public Papel(String nombre, int numero) {
		super(nombre, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean itsMe(int pNum) {
		// TODO Auto-generated method stub
		return pNum == PiedraPapelTijeraFactory.PAPEL;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPTF) {
		// TODO Auto-generated method stub
		int result = 0;
		switch (pPTF.getNumero()) {
		case PiedraPapelTijeraFactory.PIEDRA:
			result = 1;
			this.descripcionResultado = nombre + " gana a " + pPTF.getNombre();
			break;
		case PiedraPapelTijeraFactory.TIJERA:
			result = -1;
			this.descripcionResultado = nombre + " pierde con " + pPTF.getNombre();
			break;		
		default:
			this.descripcionResultado = nombre + " empata con " + pPTF.getNombre();
			break;

		}
		return result;
	}

}
