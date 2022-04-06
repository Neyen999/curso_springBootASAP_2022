package com.domain.modelo.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;

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
	
	
}