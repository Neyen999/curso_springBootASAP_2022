package com.domain.modelo.dao.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modal;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConectionManager;

public class AlumnoDAOTest {
	
	AlumnoDAO alumnoDAO;
	
	Alumno alumnoAgregar;
	Alumno alumnoAModificar;
	Alumno alumnoAEliminar;
	Alumno alumnoLeerCod;
	Alumno alumnoLeerNombre;
	
	// dejo conexion de uso public
	Connection con;
	Statement stm;
	ResultSet rs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//voy a armar un lote de pruebas que tenga 
		//1 alumno para eliminar en la base de datos
		//1- alumno para modificar
		//1- alumno para leer.
		ConectionManager.conectar();
		Connection con = ConectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosCrear.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConectionManager.desConectar();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ConectionManager.conectar();
		Connection con = ConectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosEliminar.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConectionManager.desConectar();
		
	}

	
	

	@Before
	public void setUp() throws Exception {
		alumnoDAO = new AlumnoDAO();
		
		// Este es el alumno a agregar
		alumnoAgregar = new Alumno(0, "Gabriel_test", "Casas_test", "gcasas@gmail.test", "universitarios_test", "http://gitlab/gcasas1972/repo.git");
		
		ConectionManager.conectar();
		
		con = ConectionManager.getConection();
		
		// El alumno a modificar
		Statement stm = con.createStatement();
		StringBuilder sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE , ALU_APELLIDO ,ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT ");
					  sql.append("FROM alumnos ");
					  sql.append("WHERE ALU_NOMBRE='Marina_Test' ");
					  
		rs = stm.executeQuery(sql.toString());
		if(rs.next()) {
			alumnoAModificar = new Alumno(rs.getInt("ALU_ID"), 
					  					  rs.getString("ALU_NOMBRE"), 
					  					  rs.getString("ALU_APELLIDO"), 
					  					  rs.getString("ALU_EMAIL"), 
					  					  rs.getString("ALU_CONOCIMIENTOS"), 
					  					  rs.getString("ALU_GIT"));
		}
		
		// El alumno a eliminar
		
		sql = new StringBuilder("SELECT ALU_ID FROM alumnos WHERE ALU_NOMBRE= 'Monsef_Test' ");
		
		rs = stm.executeQuery(sql.toString());
		if(rs.next()) {
			alumnoAEliminar = new Alumno(rs.getInt("ALU_ID"));
		}
		
		// Leer por codigo
		
		sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append("FROM alumnos ");
		sql.append("WHERE ALU_NOMBRE= 'Aarn_test' ");
		
		rs = stm.executeQuery(sql.toString());
		rs.next();
		
		alumnoLeerCod = new Alumno(rs.getInt("ALU_ID"), 
				  				   rs.getString("ALU_NOMBRE"), 
				  				   rs.getString("ALU_APELLIDO"), 
				  				   rs.getString("ALU_EMAIL"), 
				  				   rs.getString("ALU_CONOCIMIENTOS"), 
				  				   rs.getString("ALU_GIT"));
		
		// Leer por nombre
		sql = new StringBuilder("SELECT ALU_NOMBRE, ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT ");
		sql.append("FROM alumnos ");
		sql.append("WHERE ALU_NOMBRE= 'Ivn_test' ");
		
		rs = stm.executeQuery(sql.toString());
		rs.next();
		
		alumnoLeerNombre = new Alumno(0, 
				  				   rs.getString("ALU_NOMBRE"), 
				  				   rs.getString("ALU_APELLIDO"), 
				  				   rs.getString("ALU_EMAIL"), 
				  				   rs.getString("ALU_CONOCIMIENTOS"), 
				  				   rs.getString("ALU_GIT"));
		
		
	}

	@After
	public void tearDown() throws Exception {
		alumnoDAO = null;
		
		alumnoAgregar = null;
		alumnoAModificar = null;
		alumnoAEliminar = null;
		alumnoLeerCod = null;
		alumnoLeerNombre = null;
		
		con = null;
		stm = null;
		rs = null;
	}
	
	
	@Test
	public void testLeerTodosLosAlumnos() {
		System.out.println("Alumno a agregar=" + alumnoAgregar);
		System.out.println("Alumno a eliminar=" + alumnoAEliminar);
		System.out.println("Alumno a modificar=" + alumnoAModificar);
		System.out.println("Alumno a leer cod=" + alumnoLeerCod);
		System.out.println("Alumno a leer nombre=" + alumnoLeerNombre);
		assertNotNull(alumnoAgregar);
		assertNotNull(alumnoAEliminar);
		assertNotNull(alumnoAModificar);
		assertNotNull(alumnoLeerCod);
		assertNotNull(alumnoLeerNombre);
	}

	@Test
	public void testAgregar() {
		try {
			alumnoDAO.agregar(alumnoAgregar);
			Alumno alumnoLeido = null;
			
			Statement stm = con.createStatement();
			
			StringBuilder sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append("FROM alumnos ");
			sql.append("WHERE ALU_NOMBRE= 'Gabriel_test' ");
			
			rs = stm.executeQuery(sql.toString());
			if(rs.next()) {
				alumnoLeido = new Alumno(rs.getInt("ALU_ID"), 
		  				   				 rs.getString("ALU_NOMBRE"), 
		  				   				 rs.getString("ALU_APELLIDO"), 
		  				   				 rs.getString("ALU_EMAIL"), 
		  				   				 rs.getString("ALU_CONOCIMIENTOS"), 
		  				   				 rs.getString("ALU_GIT"));
			}
			
			assertEquals(alumnoAgregar.getNombre(), alumnoLeido.getNombre());
			assertEquals(alumnoAgregar.getApellido(), alumnoLeido.getApellido());
			assertEquals(alumnoAgregar.getEmail(), alumnoLeido.getEmail());
			assertEquals(alumnoAgregar.getEstudios(), alumnoLeido.getEstudios());
			assertEquals(alumnoAgregar.getLinkARepositorio(), alumnoLeido.getLinkARepositorio());
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	
	@Test
	public void testModificar() throws ClassNotFoundException {

		try {
		alumnoAModificar.setNombre("MarinaModif_test");
		alumnoAModificar.setApellido("Calvo PereaModif_test");
		alumnoAModificar.setEmail("email@gmailModif_test");
		alumnoAModificar.setEstudios("Grado en FsicaModif_test");
		alumnoAModificar.setLinkARepositorio("https://gitlab.com/marinacalvo/cursoJava2021.gitModif_test");
		alumnoDAO.modificar(alumnoAModificar);
		
		Alumno alumnoLeido = null;
		
		Statement stm = con.createStatement();
		
		StringBuilder sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append("FROM alumnos ");
		sql.append("WHERE ALU_NOMBRE= 'MarinaModif_test' ");
		
		rs = stm.executeQuery(sql.toString());
		if(rs.next()) {
			alumnoLeido = new Alumno(rs.getInt("ALU_ID"), 
	  				   				 rs.getString("ALU_NOMBRE"), 
	  				   				 rs.getString("ALU_APELLIDO"), 
	  				   				 rs.getString("ALU_EMAIL"), 
	  				   				 rs.getString("ALU_CONOCIMIENTOS"), 
	  				   				 rs.getString("ALU_GIT"));
		}
		
		assertTrue(true);
		assertEquals(alumnoAModificar.getNombre(), alumnoLeido.getNombre());
		assertEquals(alumnoAModificar.getApellido(), alumnoLeido.getApellido());
		assertEquals(alumnoAModificar.getEmail(), alumnoLeido.getEmail());
		assertEquals(alumnoAModificar.getEstudios(), alumnoLeido.getEstudios());
		assertEquals(alumnoAModificar.getLinkARepositorio(), alumnoLeido.getLinkARepositorio());
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}


	@Test
	public void testEliminar() throws ClassNotFoundException {
		try {
			alumnoDAO.eliminar(alumnoAEliminar);
			
			Alumno alumnoLeido = null;
			
			Statement stm = con.createStatement();
			
			StringBuilder sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append("FROM alumnos ");
			sql.append("WHERE ALU_NOMBRE= 'Monsef_test' ");
			
			rs = stm.executeQuery(sql.toString());
			assertFalse(rs.next());
			
			} catch (SQLException e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	public void testLeerPorCodigo() throws ClassNotFoundException {
		try {
			
			List<Modal>alumnos = alumnoDAO.leer(alumnoLeerCod);
			Alumno alumnoLeido = (Alumno)alumnos.get(0);
			
			assertEquals(1, alumnos.size());
			assertEquals(alumnoLeerCod.getNombre(), alumnoLeido.getNombre());
			assertEquals(alumnoLeerCod.getApellido(), alumnoLeido.getApellido());
			assertEquals(alumnoLeerCod.getEmail(), alumnoLeido.getEmail());
			assertEquals(alumnoLeerCod.getEstudios(), alumnoLeido.getEstudios());
			assertEquals(alumnoLeerCod.getLinkARepositorio(), alumnoLeido.getLinkARepositorio());
			
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}
	
	@Test
	public void testLeerPorNombre() throws ClassNotFoundException {
		try {
			
			List<Modal>alumnos = alumnoDAO.leer(alumnoLeerNombre);
			Alumno alumnoLeido = (Alumno)alumnos.get(0);
			
			assertEquals(1, alumnos.size());
			assertEquals(alumnoLeerNombre.getNombre(), alumnoLeido.getNombre());
			assertEquals(alumnoLeerNombre.getApellido(), alumnoLeido.getApellido());
			assertEquals(alumnoLeerNombre.getEmail(), alumnoLeido.getEmail());
			assertEquals(alumnoLeerNombre.getEstudios(), alumnoLeido.getEstudios());
			assertEquals(alumnoLeerNombre.getLinkARepositorio(), alumnoLeido.getLinkARepositorio());
			
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}
	
	@Test
	public void testLeerTodosNULL() {
		try {
			
			List<Modal> alumnos = alumnoDAO.leer(null);
			
						//tengo que ller de la base de datos lo que acabo de agregar

			System.out.println("alumnos=" + alumnos);
			
			assertTrue(alumnos.size()>1);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	public void testLeerTodos_VACIO() {
		try {
			
			List<Modal> alumnos = alumnoDAO.leer(new Alumno());
			
						//tengo que ller de la base de datos lo que acabo de agregar

			System.out.println("alumnos=" + alumnos);
			
			assertTrue(alumnos.size()>1);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}


	
	
}