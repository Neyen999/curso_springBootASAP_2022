package com.domain.util.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.util.ConectionManager;

public class ConectionManagerTest {
	
	Connection con;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		ConectionManager.conectar();
		con = ConectionManager.getConection();
	}

	@After
	public void tearDown() {
		con = null;
	}

	@Test
	public void testConectar() {
		try {
			ConectionManager.conectar();
			assertNotNull(ConectionManager.getConection());
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}
	
	@Test
	public void testDesconectar() throws SQLException {
		ConectionManager.desConectar();
		assertTrue(con.isClosed());
	}



}
