package com.project.saludLegal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.Paciente;

/**

 * Repositorio para obtener informacion de los pacientes desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */
@Repository
public interface PacienteRepository extends CrudRepository <Paciente, Long>{
	
	// Busqueda de un paciente por su cedula 
	//@Query(value="SELECT * FROM SL_pacientes p WHERE p.cedula = ?1")
	/**
	   * Query para obtener un paciente dada su cedula
	   * @param cedula. Cedula del paciente que se busca
	   * @return Paciente encontrado
	*/
	// La tabla SL_pacientes asociada a la entidad Paciente, tiene un indice en el campo cedula
	Paciente findPacienteByCedula(String cedula);
}
