package com.project.saludLegal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Cita;

/**

 * Repositorio para obtener informacion de las citas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface CitasRepository extends CrudRepository<Cita, Long> {
	
	/**
	   * JPQL query para modificar el estado de una cita a cancelada
	   * @param id de la cita a cancelar
	   * @return integer indicando si se actualizo correctamente el estado de la cita
	*/
	
	@Modifying
	@Query("update Cita c set c.estadoCita = 3, c.turno = null where c.idCita = ?1 ")
	int setEstadoCitaForCita(Long id);
	
	/**
	   * Query para obtener citas dado un estado 
	   * @param idEstadoCita. id del estado del cual se buscan las citas
	   * @return Lista de las citas encontradas
	*/
	// La tabla SL_citas relacionada a la entidad Cita, contiene un indice en la columna estado_cita
	//@Query("SELECT/*+ index(Cita citas.estadoCita)*/ citas FROM Cita citas where citas.estadoCita.idEstadoCita = 2 ")
	List<Cita> findByEstadoCita_idEstadoCita(Long idEstadoCita);
	
	
	/**
	   * Query para obtener citas agendadas de un paciente dado su id
	   * @param idPaciente. id del paciente del cual se buscan las citas
	   * @param estadoCita. Estado de cita que no será incluido en las busqueda. Desde el service se envia el valor 3 quemado, para no buscar citas canceladas
	   * @return Lista de las citas encontradas
	*/
	// la tabla SL_citas relacionada a la entidad Cita, contiene un indice en la columna estado_cita
	@Query(value="SELECT /*+ index(sl_citas citas_estado_index) */ * FROM sl_citas c where c.id_paciente = ?1 and c.id_estado_cita != ?2 order by c.fecha_cita", nativeQuery=true)
	//@Query("SELECT citas FROM Cita citas where citas.paciente.cedula = ?1")
	List<Cita> findByPaciente_idPacienteAndEstadoCita_idEstadoCita(Long idPaciente, Long estadoCita);
	
	/**
	   * Query para saber si un paciente tiene una cita pendiente
	   * @param idPaciente. Id del paciente del cual se buscan las citas
	   * @param idEspecialidad. Id de la especialidad de la cual se busca la cita
	   * @param idEstadoCita. Id del estado de la cita
	   * @return Booleano indicando si existe una cita pendiente
	*/
	// La tabla SL_citas relacionada a la entidad Cita, contiene un indice en la columna estado_cita
	@Query(value = "select case when count(c)> 0 then true else false end from Cita c where c.especialidad.idEspecialidad = ?1 and c.paciente.idPaciente =?2 and estadoCita.idEstadoCita = ?3")
	boolean tiene_pendientes(Long idEspecialidad, Long idPaciente, Long idEstadoCita);
	
	@Query("select  citas from Cita citas where citas.especialidad.idEspecialidad = ?1 and citas.fechaCita > sysdate order by citas.fechaCita")
	List<Cita> findByEspecialidad(Long idEspecialidad);
	 
}
