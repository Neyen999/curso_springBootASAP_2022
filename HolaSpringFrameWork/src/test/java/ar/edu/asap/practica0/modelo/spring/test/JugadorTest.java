package ar.edu.asap.practica0.modelo.spring.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.asap.practica0.modelo.Auditoria;
import ar.edu.asap.practica0.modelo.Jugada;
import ar.edu.asap.practica0.modelo.Jugador;

public class JugadorTest {
	
	ClassPathXmlApplicationContext context = null, context2 = null, context3 = null;
	Jugador jg1 = null, jg2 = null;
	Jugada jugada = null;
	Auditoria auditoria = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("META-INF/juego/Jugador.xml");
		context2 = new ClassPathXmlApplicationContext("META-INF/juego/Jugador2.xml");
		//context3 = new ClassPathXmlApplicationContext("META-INF/juego/jugada.xml");
		
		jg1 = context.getBean(Jugador.class);
		jg2 = context2.getBean(Jugador.class);
		//jugada = context3.getBean(Jugada.class);
		
		//auditoria = context3.getBean(Auditoria.class);
		
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		context2 = null;
		jg1 = null;
		jg2 = null;
		
		auditoria = null;
	}

	@Test
	public void testGetBeanAttributes() {
		assertEquals(1, jg1.getCodigo());
		assertEquals("Gabriel", jg1.getNombre());
		assertEquals("papacho", jg1.getNickname());
		assertEquals("Piedra", jg1.getJugadaElegida().getNombre());
	}
	
	@Test
	public void testGetBeanAttributes2() {
		assertEquals(2, jg2.getCodigo());
		assertEquals("Carlos", jg2.getNombre());
		assertEquals("pc", jg2.getNickname());
		assertEquals("Spock", jg2.getJugadaElegida().getNombre());
	}
	/*
	@Test
	public void testAuditoriaGetCantidad() {
		jugada.getDescripcionDeResultado();
		jugada.getDescripcionDeResultado();
		jugada.getDescripcionDeResultado();
		
		assertEquals(3, auditoria.getCantidadDeJugadas());
	}*/

}
