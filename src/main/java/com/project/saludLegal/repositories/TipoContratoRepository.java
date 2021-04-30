package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.TipoContrato;

/**

 * Repositorio para obtener informacion de los tipos de contrato desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface TipoContratoRepository extends CrudRepository<TipoContrato, Long>{
	

}
