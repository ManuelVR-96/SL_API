package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.PrioridadSintoma;

/**

 * Repositorio para obtener informacion de las prioridades de los sintomas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface PrioridadSintomaRepository extends CrudRepository <PrioridadSintoma, Long>{

}
