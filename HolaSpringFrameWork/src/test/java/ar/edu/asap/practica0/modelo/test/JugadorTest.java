package ar.edu.asap.practica0.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.asap.practica0.modelo.Jugador;

public class JugadorTest {
	
	ClassPathXmlApplicationContext context = null;
	Jugador jg1 = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("META-INF/juego/Jugador.xml");
		jg1 = context.getBean(Jugador.class);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		jg1 = null;
	}

	@Test
	public void testGetBeanAttributes() {
		assertEquals(1, jg1.getCodigo());
		assertEquals("Gabriel", jg1.getNombre());
		assertEquals("papacho", jg1.getNickname());
		assertEquals("Piedra", jg1.getJugadaElegida().getNombre());
	}

}
