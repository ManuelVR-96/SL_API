package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.TipoCita;

/**

 * Repositorio para obtener informacion de los tipos de citas desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */
@Repository
public interface TipoCitaRepository extends CrudRepository<TipoCita, Long>{

}
