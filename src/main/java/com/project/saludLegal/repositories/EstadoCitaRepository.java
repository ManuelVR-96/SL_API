package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.EstadoCita;

/**

 * Repositorio para obtener informacion de los estados de citas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface EstadoCitaRepository extends CrudRepository<EstadoCita, Long>{

}
