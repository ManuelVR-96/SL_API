package com.project.saludLegal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.SintomatologiaEspecialidad;

/**

 * Repositorio para obtener informacion de la tabla pivote que relaciona sintoma y especialidades 
 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface SintomaEspecialidadRepository extends CrudRepository<SintomatologiaEspecialidad, Long> {
	/**
	   * Query para obtener especialidades relacionadas a un sintoma
	   * @param idSintoma. id del sintoma del cual se buscan las especialidades relacionadas
	   * @return Lista con las especialidades relacionadas al sintoma
	*/
	// La tabla SL_SINTOMATOLOGIAS_ESPECIALIDADES asociada a la entidad SintomatologiaEspecialidad, tiene un indice en la columna id_sintomatologia
	@Query("Select rows FROM SintomatologiaEspecialidad rows where rows.sintomatologia.idSintomatologia = ?1")
	public List<SintomatologiaEspecialidad> findBySintomatologia_idSintomatologia(Long idSintoma);
}
