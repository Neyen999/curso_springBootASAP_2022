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
		//StringBuilder sql = new StringBuilder("select ALU_NOMBRE from alumnos");
		Statement stmt = conexion.createStatement();
		ResultSet rs = stmt.executeQuery("select ALU_ID, ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT from alumnos");
		
		List<Modal> listado = new ArrayList();
		
		while(rs.next()) {
			Alumno alumno = new Alumno();
			alumno.setCodigo(rs.getInt("ALU_ID"));
			alumno.setNombre(rs.getString("ALU_NOMBRE"));
			alumno.setApellido(rs.getString("ALU_APELLIDO"));
			alumno.setEmail(rs.getString("ALU_EMAIL"));
			alumno.setEstudios(rs.getString("ALU_CONOCIMIENTOS"));
			alumno.setLinkARepositorio(rs.getString("ALU_GIT"));
			listado.add(alumno);
		}
		
		
		for (Modal obj : listado) {
	         System.out.print("Codigo: "+ ((Alumno) obj).getCodigo()+", ");
	         System.out.print("Nombre: "+ ((Alumno) obj).getNombre()+", ");
	         System.out.print("Apellido: "+ ((Alumno) obj).getApellido()+", ");
	         System.out.print("Email: "+ ((Alumno) obj).getEmail()+", ");
	         System.out.print("Estudios: "+ ((Alumno) obj).getEstudios()+", ");
	         System.out.print("Repositorio: "+ ((Alumno) obj).getLinkARepositorio());
	         System.out.println();
	     }
		
		try {
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return listado;
		
	}

}
