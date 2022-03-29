package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {

	// lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	
	@BeforeEach
	void setUp() throws Exception {
		// El setup es lo que se va a correr antes de cada test
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
	}

	@AfterEach
	void tearDown() throws Exception {
		// El tearDown es lo que se va a correr después de cada test
		piedra = null;
		papel = null;
		tijera = null;
	}
	
	// Test Piedra

	@Test 
	void testPiedraGanaATijera() {
		assertEquals(1, piedra.comparar(tijera));
	}
	
	@Test
	void testPiedraPierdeConPapel() {
		assertEquals(-1, piedra.comparar(papel));
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
	void testPiedraPierdeConPapel_DescripcionResultado() {
		int result = piedra.comparar(papel);
		assertEquals("Piedra pierde con Papel", piedra.getDescripcionResultado());
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
	void testPapelPierdeConTijera() {
		assertEquals(-1, papel.comparar(tijera));
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
	void testPapelPierdeConTijera_DescripcionResultado() {
		int result = papel.comparar(tijera);
		assertEquals("Papel pierde con Tijera", papel.getDescripcionResultado());
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
	void testTijeraPierdeConPiedra() {
		assertEquals(-1, tijera.comparar(piedra));
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
	void testTijeraPierdeConPiedra_DescripcionResultado() {
		int result = tijera.comparar(piedra);
		assertEquals("Tijera pierde con Piedra", tijera.getDescripcionResultado());
	}

	@Test
	void testTijeraEmpataConTijera_DescripcionResultado() {
		int result = tijera.comparar(tijera);
		assertEquals("Tijera empata con Tijera", tijera.getDescripcionResultado());
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
}
