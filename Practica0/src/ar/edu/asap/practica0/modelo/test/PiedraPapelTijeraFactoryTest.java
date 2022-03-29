package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Lagarto;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {

	// lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Lagarto lagarto;
	Spock spock;
	
	@BeforeEach
	void setUp() throws Exception {
		// El setup es lo que se va a correr antes de cada test
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		lagarto = new Lagarto();
		spock = new Spock();
	}

	@AfterEach
	void tearDown() throws Exception {
		// El tearDown es lo que se va a correr después de cada test
		piedra = null;
		papel = null;
		tijera = null;
		lagarto = null;
		spock = null;
	}
	
	// Test Piedra

	@Test 
	void testPiedraGanaATijera() {
		assertEquals(1, piedra.comparar(tijera));
	}
	
	@Test
	void testPiedraGanaALagarto() {
		assertEquals(2, piedra.comparar(lagarto));
	}
	
	@Test
	void testPiedraPierdeConPapel() {
		assertEquals(-1, piedra.comparar(papel));
	}
	
	@Test
	void testPiedraPierdeConSpock() {
		assertEquals(-2, piedra.comparar(spock));
	}
	
	@Test
	void testPiedraEmpataConPiedra () {
		assertEquals(0, piedra.comparar(piedra));
	}
	
	@Test
	void testPiedraGanaATijera_DescripcionResultado() {
		int result = piedra.comparar(tijera);
		assertEquals("Piedra gana a Tijera", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraGanaALagarto_DescripcionResultado() {
		int result = piedra.comparar(lagarto);
		assertEquals("Piedra gana a Lagarto", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraPierdeConPapel_DescripcionResultado() {
		int result = piedra.comparar(papel);
		assertEquals("Piedra pierde con Papel", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraPierdeConSpock_DescripcionResultado() {
		int result = piedra.comparar(spock);
		assertEquals("Piedra pierde con Spock", piedra.getDescripcionResultado());
	}

	@Test
	void testPiedraEmpataConPiedra_DescripcionResultado() {
		int result = piedra.comparar(piedra);
		assertEquals("Piedra empata con Piedra", piedra.getDescripcionResultado());
	}

	
	// Papel
	
	@Test 
	void testPapelGanaAPiedra() {
		assertEquals(1, papel.comparar(piedra));
	}

	@Test 
	void testPapelGanaASpock() {
		assertEquals(2, papel.comparar(spock));
	}
	
	@Test
	void testPapelPierdeConTijera() {
		assertEquals(-1, papel.comparar(tijera));
	}
	
	@Test
	void testPapelPierdeConLagarto() {
		assertEquals(-2, papel.comparar(lagarto));
	}
	
	@Test
	void testPapelEmpataConPapel () {
		assertEquals(0, papel.comparar(papel));
	}
	
	@Test
	void testPapelGanaAPiedra_DescripcionResultado() {
		int result = papel.comparar(piedra);
		assertEquals("Papel gana a Piedra", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelGanaASpock_DescripcionResultado() {
		int result = papel.comparar(spock);
		assertEquals("Papel gana a Spock", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelPierdeConTijera_DescripcionResultado() {
		int result = papel.comparar(tijera);
		assertEquals("Papel pierde con Tijera", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelPierdeConLagarto_DescripcionResultado() {
		int result = papel.comparar(lagarto);
		assertEquals("Papel pierde con Lagarto", papel.getDescripcionResultado());
	}

	@Test
	void testPapelEmpataConPapel_DescripcionResultado() {
		int result = papel.comparar(papel);
		assertEquals("Papel empata con Papel", papel.getDescripcionResultado());
	}
	

	// Tijera
	
	@Test 
	void testTijeraGanaAPapel() {
		assertEquals(1, tijera.comparar(papel));
	}
	
	@Test 
	void testTijeraGanaALagarto() {
		assertEquals(2, tijera.comparar(lagarto));
	}
	
	@Test
	void testTijeraPierdeConPiedra() {
		assertEquals(-1, tijera.comparar(piedra));
	}
	
	@Test
	void testTijeraPierdeConSpock() {
		assertEquals(-2, tijera.comparar(spock));
	}
	
	@Test
	void testTijeraEmpataConTijera () {
		assertEquals(0, tijera.comparar(tijera));
	}
	
	@Test
	void testTijeraGanaAPapel_DescripcionResultado() {
		int result = tijera.comparar(papel);
		assertEquals("Tijera gana a Papel", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraGanaALagarto_DescripcionResultado() {
		int result = tijera.comparar(lagarto);
		assertEquals("Tijera gana a Lagarto", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraPierdeConPiedra_DescripcionResultado() {
		int result = tijera.comparar(piedra);
		assertEquals("Tijera pierde con Piedra", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraPierdeConSpock_DescripcionResultado() {
		int result = tijera.comparar(spock);
		assertEquals("Tijera pierde con Spock", tijera.getDescripcionResultado());
	}

	@Test
	void testTijeraEmpataConTijera_DescripcionResultado() {
		int result = tijera.comparar(tijera);
		assertEquals("Tijera empata con Tijera", tijera.getDescripcionResultado());
	}
	
	// Lagarto
	
	@Test 
	void testLagartoGanaASpock() {
		assertEquals(1, lagarto.comparar(spock));
	}
	
	@Test 
	void testLagartoGanaAPapel() {
		assertEquals(2, lagarto.comparar(papel));
	}
	
	@Test
	void testLagartoPierdeConPiedra() {
		assertEquals(-1, lagarto.comparar(piedra));
	}
	
	@Test
	void testLagartoPierdeConTijera() {
		assertEquals(-2, lagarto.comparar(tijera));
	}
	
	@Test
	void testLagartoEmpataConLagarto() {
		assertEquals(0, lagarto.comparar(lagarto));
	}
	
	@Test
	void testLagartoGanaASpock_DescripcionResultado() {
		int result = lagarto.comparar(spock);
		assertEquals("Lagarto gana a Spock", lagarto.getDescripcionResultado());
	}
	
	@Test
	void testLagartoGanaAPapel_DescripcionResultado() {
		int result = lagarto.comparar(papel);
		assertEquals("Lagarto gana a Papel", lagarto.getDescripcionResultado());
	}
	
	@Test
	void testLagartoPierdeConPiedra_DescripcionResultado() {
		int result = lagarto.comparar(piedra);
		assertEquals("Lagarto pierde con Piedra", lagarto.getDescripcionResultado());
	}
	
	@Test
	void testLagartoPierdeConTijera_DescripcionResultado() {
		int result = lagarto.comparar(tijera);
		assertEquals("Lagarto pierde con Tijera", lagarto.getDescripcionResultado());
	}

	@Test
	void testLagartoEmpataConLagarto_DescripcionResultado() {
		int result = lagarto.comparar(lagarto);
		assertEquals("Lagarto empata con Lagarto", lagarto.getDescripcionResultado());
	}
	
	// Spock
	
	@Test 
	void testSpockGanaATijera() {
		assertEquals(1, spock.comparar(tijera));
	}
	
	@Test 
	void testLagartoGanaAPiedra() {
		assertEquals(2, spock.comparar(piedra));
	}
	
	@Test
	void testSpockPierdeConLagarto() {
		assertEquals(-1, lagarto.comparar(piedra));
	}
	
	@Test
	void testSpockPierdeConPapel() {
		assertEquals(-2, lagarto.comparar(tijera));
	}
	
	@Test
	void testSpockEmpataConSpock() {
		assertEquals(0, spock.comparar(spock));
	}
	
	@Test
	void testSpockGanaATijera_DescripcionResultado() {
		int result = spock.comparar(tijera);
		assertEquals("Spock gana a Tijera", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockGanaAPiedra_DescripcionResultado() {
		int result = spock.comparar(piedra);
		assertEquals("Spock gana a Piedra", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockPierdeConLagarto_DescripcionResultado() {
		int result = spock.comparar(lagarto);
		assertEquals("Spock pierde con Lagarto", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockPierdeConPapel_DescripcionResultado() {
		int result = spock.comparar(papel);
		assertEquals("Spock pierde con Papel", spock.getDescripcionResultado());
	}

	@Test
	void testSpockEmpataConSpock_DescripcionResultado() {
		int result = spock.comparar(spock);
		assertEquals("Spock empata con Spock", spock.getDescripcionResultado());
	}
	
	// get Instances
	
	@Test
	void testGetInstancePiedra() {
		assertEquals("Piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA).getNombre());
	}
	
	@Test
	void testGetInstancePapel() {
		assertEquals("Papel", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PAPEL).getNombre());
	}
	
	@Test
	void testGetInstanceTijera() {
		assertEquals("Tijera", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.TIJERA).getNombre());
	}
	
	@Test
	void testGetInstanceLagarto() {
		assertEquals("Lagarto", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.LAGARTO).getNombre());
	}
	
	void testGetInstanceSpock() {
		assertEquals("Spock", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.SPOCK).getNombre());
	}
	
}
