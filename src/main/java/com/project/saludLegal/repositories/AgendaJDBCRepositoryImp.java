package com.project.saludLegal.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


/**

 * Implementacion de repositorio para lanzamiento del proceso masivo de agendamiento. Se utiliza JDBC para la conexión.

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public class AgendaJDBCRepositoryImp implements AgendaJDBCRepository{
	
	@Value("${spring.datasource.url}")
	private String dbURL;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
				
	public AgendaJDBCRepositoryImp() {
	}
	
	/**
	   * Funcion para lanzar el proceso de agendamiento de citas usando JDBC
	   * @return HashMap que contiene la cantidad de citas que fueron asignadas, y las que quedaron sin asignar por falta de agenda (Si es el caso)
	 * @throws SQLException 
	*/
	
	public Connection connect() throws SQLException {
		Connection conn = null;
		try {
            conn = DriverManager.getConnection(this.dbURL, this.username, this.password);
           } catch (SQLException e) {
            throw e;
        }
		return conn;
	}
	
	public HashMap<String, Integer> agendar(Long idUsuario) throws SQLException {
		
		Connection conn = this.connect();
		HashMap<String,Integer> resultados = new HashMap<String, Integer>();
		try {
			
			if (conn != null) {
				
				int idOperario = idUsuario.intValue();
				CallableStatement cStmt = conn.prepareCall("call procesos_pk.asignar(?, ?,?)");
				cStmt.setInt("usuario", idOperario);
				System.out.println(idOperario);
				cStmt.registerOutParameter("faltan", Types.INTEGER);
				cStmt.registerOutParameter("asignadas", Types.INTEGER);
				cStmt.execute();
				int faltan = cStmt.getInt("faltan");
				int asignadas = cStmt.getInt("asignadas");
				System.out.println("Entrando");
				System.out.println(asignadas);
				resultados.put("Asignadas", asignadas);
				resultados.put("Faltan", faltan);
			}
		} catch(Exception e) {
			System.out.println("Error agendando");
			System.out.println(e);
		}
	  return resultados;
    }

	
	public void vaciar() throws SQLException {
		Connection conn = this.connect();
		System.out.println("Acá");
		if(conn != null) {
			CallableStatement cStmt = conn.prepareCall("{call procesos_pk.vaciar()}");
            cStmt.execute();
		}
		
	}

}
