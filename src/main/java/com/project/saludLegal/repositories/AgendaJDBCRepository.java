package com.project.saludLegal.repositories;

import java.sql.SQLException;
import java.util.HashMap;

public interface AgendaJDBCRepository {
	
	HashMap<String, Integer> agendar(Long idUsuario) throws SQLException;
	
	void vaciar() throws SQLException;
	
	
}
