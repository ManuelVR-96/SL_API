package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Especialidad;

/**

 * Repositorio para obtener informacion de las especialidades desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */
@Repository
public interface EspecialidadRepository extends CrudRepository <Especialidad,Long>{

}
