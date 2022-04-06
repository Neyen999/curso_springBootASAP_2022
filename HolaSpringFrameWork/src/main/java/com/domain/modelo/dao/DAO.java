package com.domain.modelo.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Modal;

public interface DAO {
	public void agregar(Modal pModal) throws ClassNotFoundException, SQLException;
	public void modificar(Modal pModal) throws SQLException;
	public void eliminar(Modal pModal) throws SQLException;
	public List<Modal> leer(Modal pModal) throws SQLException;

}
