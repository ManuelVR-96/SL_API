package com.project.saludLegal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.saludLegal.models.Medico;


/**

 * Repositorio para obtener informacion de los medicos desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

public interface MedicoRepository extends CrudRepository<Medico,Long>{
	/**
	   * Query para obtener medicos relacionados a un centro medico
	   * @param idCentroMedico. id del centro medico del cual se solicitan los medicos
	   * @return Lista de medicos relacionados a dicho centro medico
	*/
	// La tabla SL_Medicos asociada a la entidad Medico, contiene un índice en el campo id_centro_medico
	@Query("select medicos FROM Medico medicos where medicos.centroMedico.idCentroMedico = ?1")
	List<Medico> findByCentroMedico_idCentroMedico(Long idCentroMedico);

}
