package com.project.saludLegal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.OperarioLoginDTO;
import com.project.saludLegal.DTOS.OperarioSessionDTO;
import com.project.saludLegal.mappers.OperarioMapper;
import com.project.saludLegal.models.Operario;
import com.project.saludLegal.repositories.OperarioRepository;

import javassist.NotFoundException;


/**

 * Service para logica relacionada a los operadores

 * @author: Manuel Alejandro Verján Robles

 */


@Service
public class OperarioService {
	
	// Repositorio del operario
	@Autowired
	OperarioRepository operarioRepository;
	
	// Mapper para los DTO relacionados al Operario
	@Autowired
	OperarioMapper operarioMapper;
	
	   /**
	   * Método para validar credenciales ingresadas por el usuario
	   * @param credenciales, DTO que incluye cedula y contrasenia del operario que busca ingresar
	   * @return DTO con la info de sesion del usuario
	 * 	@throws NotFoundException 
	   */
	public OperarioSessionDTO validarCredenciales (OperarioLoginDTO credenciales) throws NotFoundException {
		// Se obtiene un usuario con la cedula ingresada
		Operario userRecuperado = operarioRepository.findByCedula(credenciales.getCedula());
		if(userRecuperado == null) {
			throw new NotFoundException("Las credenciales no son válidas!!!!!!!!");
		}
		// Se extraen la contrasenia ingresada y la obtenida del usuario
		String pass1 = userRecuperado.getPassword();
		String pass2 = credenciales.getPassword();
		// Se compara si coinciden. De ser asi, se regresa un DTO con la info de sesion, de lo contrario, se la lanza una excepcion de Not Found.
		if(pass1.equals(pass2)) {
			System.out.println("Iguales");
			return operarioMapper.operarioToOperarioSessionDTO(userRecuperado);
		} else {
			System.out.println("Entrando al catch");
			throw new NotFoundException("Las credenciales no son válidas!!!!!!!!");
		}
	}
}
