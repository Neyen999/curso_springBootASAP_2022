package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modal;
import com.domain.util.ConectionManager;

public class AlumnoDAO implements DAO {

	private Connection conexion;
	
	public AlumnoDAO() throws ClassNotFoundException, SQLException {}
	
	@Override
	public void agregar(Modal pModal) throws ClassNotFoundException, SQLException {
		ConectionManager.conectar();
		conexion = ConectionManager.getConection();
		
		StringBuilder sql = new StringBuilder("insert into alumnos (ALU_APELLIDO, ALU_NOMBRE, ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT) values(?,?,?,?,?)");
		
		Alumno alu = (Alumno) pModal;
	
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getApellido());
		stm.setString(2, alu.getNombre());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkARepositorio());
		
		stm.execute();
		
		ConectionManager.desConectar();
	}

	@Override
	public void modificar(Modal pModal) throws SQLException, ClassNotFoundException {
		ConectionManager.conectar();
		conexion = ConectionManager.getConection();
		
		StringBuilder sql = new StringBuilder("UPDATE alumnos SET ALU_NOMBRE=?");
					  sql.append(", ALU_APELLIDO=?");
					  sql.append(", ALU_EMAIL=?");
					  sql.append(", ALU_CONOCIMIENTOS=?");
					  sql.append(", ALU_GIT=? ");
					  sql.append("WHERE ALU_ID=?");
		Alumno alu = (Alumno) pModal;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkARepositorio());
		stm.setInt(6, alu.getCodigo());
		stm.execute();
		
		ConectionManager.desConectar();
		
	}

	@Override
	public void eliminar(Modal pModal) throws SQLException, ClassNotFoundException {
		ConectionManager.conectar();
		conexion = ConectionManager.getConection();
		
		StringBuilder sql = new StringBuilder("DELETE FROM alumnos WHERE ALU_ID=?");

		Alumno alu = (Alumno) pModal;
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		 stm.setInt(1, alu.getCodigo());
		 stm.execute();
		  
		ConectionManager.desConectar();
	}

	@Override
	public List<Modal> leer(Modal pModal) throws SQLException, ClassNotFoundException {
		ConectionManager.conectar();
		conexion = ConectionManager.getConection();

		StringBuilder sql = new StringBuilder("SELECT ALU_ID, ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT from alumnos ");
		
		
		List<Modal> listado = new ArrayList();
		
		PreparedStatement stm = null;
		
		Alumno alumno = (Alumno) pModal;
		if(alumno != null && !alumno.isEmpty()) {
			if(alumno.getCodigo() > 0) {
				sql.append("WHERE ALU_ID=?");
				stm = conexion.prepareStatement(sql.toString());
				stm.setInt(1, alumno.getCodigo());
			} else if (alumno.getNombre() != null && !alumno.getNombre().isEmpty()) {
				sql.append("WHERE ALU_NOMBRE=?");
				stm = conexion.prepareStatement(sql.toString());
				stm.setString(1, alumno.getNombre());
			}
		} else {
			stm = conexion.prepareStatement(sql.toString());
		}
		
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) {
			alumno = new Alumno(rs.getInt("ALU_ID"), rs.getString("ALU_NOMBRE"), 
					rs.getString("ALU_APELLIDO"), rs.getString("ALU_EMAIL"), 
					rs.getString("ALU_CONOCIMIENTOS"), rs.getString("ALU_GIT"));
			listado.add(alumno);
		}
		
		/*
		for (Modal obj : listado) {
	         System.out.print("Codigo: "+ ((Alumno) obj).getCodigo()+", ");
	         System.out.print("Nombre: "+ ((Alumno) obj).getNombre()+", ");
	         System.out.print("Apellido: "+ ((Alumno) obj).getApellido()+", ");
	         System.out.print("Email: "+ ((Alumno) obj).getEmail()+", ");
	         System.out.print("Estudios: "+ ((Alumno) obj).getEstudios()+", ");
	         System.out.print("Repositorio: "+ ((Alumno) obj).getLinkARepositorio());
	         System.out.println();
	     }*/
		
		try {
			rs.close();
			stm.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		ConectionManager.desConectar();
		
		return listado;
		
	}

}
