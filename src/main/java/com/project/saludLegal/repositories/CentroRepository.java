package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.CentroMedico;

/**

 * Repositorio para obtener informacion de las centros medicos desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface CentroRepository extends CrudRepository <CentroMedico, Long>{

}
