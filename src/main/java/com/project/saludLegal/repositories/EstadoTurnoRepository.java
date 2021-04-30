package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.EstadoTurno;

/**

 * Repositorio para obtener informacion de los estados de turnos desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface EstadoTurnoRepository extends CrudRepository<EstadoTurno, Long> {

}
