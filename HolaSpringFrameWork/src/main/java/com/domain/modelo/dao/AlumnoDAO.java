package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modal;
import com.domain.util.ConectionManager;

public class AlumnoDAO implements DAO {

	private Connection conexion;
	
	public AlumnoDAO() throws ClassNotFoundException, SQLException {

		ConectionManager.conectar();
		
		conexion = ConectionManager.getConection();
	}
	
	@Override
	public void agregar(Modal pModal) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder("insert into alumnos (ALU_APELLIDO, ALU_NOMBRE, ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT) values(?,?,?,?,?)");
		
		Alumno alu = (Alumno) pModal;
	
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getApellido());
		stm.setString(2, alu.getNombre());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkARepositorio());
		
		stm.execute();
	}

	@Override
	public void modificar(Modal pModal) throws SQLException {
		StringBuilder sql = new StringBuilder("update alumnos set ALU_EMAIL=? where ALU_CONOCIMIENTOS=?");
		
		Alumno alu = (Alumno) pModal;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(2, alu.getEstudios());
		stm.setString(1, alu.getEmail());
		stm.execute();
		
	}

	@Override
	public void eliminar(Modal pModal) throws SQLException {
		StringBuilder sql = new StringBuilder("delete from alumnos where ALU_NOMBRE=?");
		
		Alumno alu = (Alumno) pModal;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getNombre());
		stm.execute();
		
	}

	@Override
	public List<Modal> leer(Modal pModal) throws SQLException {
		/*
		StringBuilder sql = new StringBuilder("select ALU_APELLIDO from alumnos where ALU_NOMBRE=?");
		Alumno alu = (Alumno) pModal;
		
		List<Modal> lista = new ArrayList();
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		//stm.setString(1, alu.getApellido());
		stm.setString(1, alu.getNombre());
		
		stm.execute();
		
		lista.add(new Alumno(alu.getEmail()));
		
		return lista;*/
		return null;
		
	}

}
