package com.project.saludLegal.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.saludLegal.DTOS.OperarioLoginDTO;
import com.project.saludLegal.DTOS.OperarioSessionDTO;
import com.project.saludLegal.models.Paciente;
import com.project.saludLegal.repositories.OperarioRepository;
import com.project.saludLegal.repositories.PacienteRepository;
import com.project.saludLegal.services.OperarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins= {"*"})
@RequestMapping("/")

/**

 * Controlador para controlar peticiones de los operarios del sistema

 * @author: Manuel Alejandro Verjan Robles

 */

public class OperarioController {
	@Autowired
	OperarioService operarioService;
	
	   /**
	   * End Point para login de operarios
	   * @param credenciales. DTO que contiene cedula y contrasenia del operario que intenta ingresar
	   * @Exception 404 NOT FOUND
	   * @return Response entity de un DTO que contiene la info de session del usuario.
	 * @throws Exception 
	   */
	@ApiOperation(
	        value = "Metodo para manejar el login de los usuarios. Devuelve la informacion de sesion del usuario",
	        notes = "Devuelve error 404 si no se encontro usuario con las credenciales ingresadas"
	)
	@PostMapping("login")
	public ResponseEntity<OperarioSessionDTO> login (@RequestBody @Valid OperarioLoginDTO credenciales) throws Exception{
		
		// Se trata de obtener la información del usuario y retonarlas en un response entity
		
		OperarioSessionDTO operarioReturn = operarioService.validarCredenciales(credenciales);
		System.out.println(operarioReturn);
		return new ResponseEntity<OperarioSessionDTO>(operarioReturn, HttpStatus.OK);
		// Si no se consigue, se captura la excepción y se retorna un error 404
		//} catch (Exception e) {
			//return new ResponseEntity("Credenciales no válidas", HttpStatus.NOT_FOUND);
		//}		
	}
	
}
