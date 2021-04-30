package com.project.saludLegal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Sintomatologia;

/**

 * Repositorio para obtener informacion de los sintomas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface SintomatologiaRepository extends CrudRepository <Sintomatologia, Long>{
	
	/**
	   * Query saber si ya existe un sintoma con determinada descripcion
	   * @param descripcion. descripcion del sintoma que se busca agregar.
	   * @return Booleano indicando si ya existe un sintoma con dicha descripcion
	*/
	// La tabla sl_sintomatologias asociada a la entidad sintomatologia tiene un indice en el campo descripcion
	//@Query(value = "select case when count(s)> 0 then true else false end from Sintomatologia s where descripcion = ?1")
	boolean existsByDescripcionIgnoreCase(String descripcion);
}
