package com.project.saludLegal.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.saludLegal.models.Agenda;

/**

 * Repositorio para obtener informacion de las agendas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
	
	/**
	   * Query para saber si ya existe una agenda para un médico en determinada fecha
	   * @param fechaBuscar. Fecha del dia que se quiere comprobar.
	   * @param idMedico. Id del medico del que se busca comprobar la agenda
	   * @return booleano indicando si existe la cita
	*/
	// La tabla Sl_agendas, tiene un indice compuesto en los campos id_medico y fecha_agenda
	boolean existsByfechaAgendaAndIdMedico_IdMedico(LocalDate fechaBuscar, Long idMedico);
	
	/**
	   * Query para encontrar una agenda dado el id del medico
	   * @param idMedico. Id del medico del que se busca comprobar la agenda
	   * @return lista de agendas del medico
	*/
	// El indice agendas_medico es un indice compuesto por 2 columnas, id_medico y fecha
	@Query(nativeQuery = true , value="select /*+ index(sl_agendas agendas_medico_index) */ * from SL_agendas s where s.id_medico = ?1 and fecha_agenda >= sysdate order by fecha_agenda asc")
	List<Agenda> findByidMedico(Long idMedico);
	
	
}
