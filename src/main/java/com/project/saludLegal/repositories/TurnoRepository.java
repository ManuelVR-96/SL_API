package com.project.saludLegal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Turno;

/**

 * Repositorio para obtener informacion de los turnos desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface TurnoRepository extends CrudRepository <Turno,Long>{
	
	/**
	   * Query para saber si existe un turno dado un estado de turno
	   * @param idEstadoTurno. Id del estado en el cual se buscan los turnos
	   * @return Booleano para indicar si existe un turno con dicho estado
	*/

	@Query(value = "select case when count(s)> 0 then true else false end from SL_turnos s where id_estado_turno = ?1", nativeQuery=true)
	boolean existsTurnoByEstadoTurno(Long idEstadoTurno);
	
	/**
	   * Query para obtener los turnos relacionados a una agenda
	   * @param idAgenda. Id de la agenda de la cual se buscan los turnos
	   * @return Lista de los turnos relacionados a la agenda
	*/
	// La tabla sl_turnos relacionada a la entidad Turno, tiene un indice en la columna id agenda
	//@Query(value = "select turnos FROM Turno turnos where turnos.agenda.idAgenda =?1")
	List<Turno> findByAgenda_idAgenda(Long idAgenda);
	
	
	/**
	   * Query para saber, usando la vista turnos_info definida en la BD, si hay un turno disponible para la cita solicitada
	   * @param idEstadoTurno. Id del estado de turno requerido, es decir, estado 1, que indica turno disponible
	   * @param idEspecialidad. Id de la especialidad de la cual se busca un turno libre
	   * @return IdCentroMedico. Id del centro medico donde debe ser atendido el paciente
	*/
	//turnos_data hace referencia a una vista definida en la base de datos, la cual compacta información de un turno, su estado, 
	//la especialidad a la que corresponde y el centro medico donde sera atendido
	  @Query(value ="select CASE  WHEN count(*)> 0 THEN 1 ELSE 0 END from turnos_data t where t.id_especialidad = ?1 AND  t.id_estado_turno =?2 AND t.id_centro_medico =?3", nativeQuery=true ) 
	  Integer turnos_disponibles(Long idEspecialidad, Long idEstadoTurno, Long idCentroMedico);
	  
	  
	  /**
	   * JPQL query para modificar el estado de un turno, dado su id
	   * @param id del turno a modificar
	   * @return integer indicando si se actualizo correctamente el estado del turno
	*/
	  @Modifying
		@Query("update Turno t set t.estadoTurno = 2 where t.idTurno = ?1 ")
		int setEstadoTurnoForTurno(Long id);
	 


}
