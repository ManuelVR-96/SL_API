package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Operario;

/**

 * Repositorio para obtener informacion de operarios

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface OperarioRepository extends CrudRepository<Operario, Long>{
	
	/**
	   * Query para obtener un operario dado su email
	   * @param email. String con el email del operario que se busca
	   * @return instancia de operario
	*/
	public Operario findByEmail(String emailOperario);
	
	/**
	   * Query para obtener un operario dado su cedula
	   * @param cedula. String con la cedula del operario que se busca
	   * @return instancia de operario
	*/
	// La tabla operario tiene un indice unique en el campo cedula
	public Operario findByCedula(String cedula);

}
