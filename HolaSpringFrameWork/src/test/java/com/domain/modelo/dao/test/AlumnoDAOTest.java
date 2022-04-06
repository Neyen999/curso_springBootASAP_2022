package com.domain.modelo.dao.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modal;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConectionManager;

public class AlumnoDAOTest {
	
	AlumnoDAO alumnoDAO;
	Alumno alumno;

	@Before
	public void setUp() throws Exception {
		alumnoDAO = new AlumnoDAO();
		alumno = new Alumno(0, "Neyen", "Marinelli", "nmarinelli@gmail.com", "Universidad - Programacion", "https://gitlab.com/nmarinelli/repo.git");
	}

	@After
	public void tearDown() throws Exception {
		alumnoDAO = null;
		alumno = null;
	}

	@Test
	public void testAgregar() {
		try {
			alumnoDAO.agregar(alumno);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void testModificar() throws ClassNotFoundException {
		
		Alumno nuevoAlumno;
		try {
		nuevoAlumno = new Alumno(0, "Gabriel", "Casas", "neyen_gt@hotmail.com", "Universidad - Programacion", "https://gitlab.com/gcasas/repo.git");;
		alumnoDAO.modificar(nuevoAlumno);
		assertTrue(true);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	
	@Test
	public void testEliminar() {
		Alumno nuevoAlumno;
		try {
		nuevoAlumno = new Alumno(0, "Carlos", "Casas", "carlos@hotmail.com", "Universidad", "https://gitlab.com/gcasas/repo.git");;
		alumnoDAO.eliminar(nuevoAlumno);
		assertTrue(true);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testLeerPorCodigo() {
		try {
			//1- lectura de los datos objetivo conseguir el id
			ConectionManager.conectar();
			Connection con = ConectionManager.getConection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT ALU_ID from alumnos");
			rs.next();
			
			Alumno alu = new Alumno(rs.getInt("ALU_ID"));
			List<Modal>alumnos = alumnoDAO.leer(alu);
			
			assertEquals(5													, ((Alumno)alumnos.get(1)).getCodigo());
			assertEquals("Neyen"											, ((Alumno)alumnos.get(1)).getNombre());
			assertEquals("Marinelli"										, ((Alumno)alumnos.get(1)).getApellido());
			assertEquals("https://gitlab.com/nmarinelli/repo.git"			, ((Alumno)alumnos.get(1)).getLinkARepositorio());
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	
	
}