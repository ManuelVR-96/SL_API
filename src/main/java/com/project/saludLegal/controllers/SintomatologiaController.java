package com.project.saludLegal.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.saludLegal.DTOS.PrioridadSintomaDTO;
import com.project.saludLegal.DTOS.RegistroSintomaDTO;
import com.project.saludLegal.DTOS.SintomatologiaDTO;
import com.project.saludLegal.exceptions.SintomaAlreadyExistsException;
import com.project.saludLegal.models.Sintomatologia;
import com.project.saludLegal.services.SintomatologiaService;

import io.swagger.annotations.ApiOperation;

/**

 * Controlador para controlar peticiones de los sintomas
 * @author: Manuel Alejandro Verjan Robles

 */

@RestController
@CrossOrigin(origins= {"*"})
@RequestMapping("/sintomatologias")
public class SintomatologiaController {
	
	// Inyeccion de dependencia de servicio de sintomatologias
	@Autowired
	SintomatologiaService sintomatologiaService;
	
	/**
	   * End Point para obtener sintomatologias
	   * @return Response entity de lista de dto's de los sintomas
	  */
	@ApiOperation(
	        value = "Metodo para obtener listado de sintomas. Retorna response entity con la lista de sintomas"
	)
	@GetMapping("") 
	public ResponseEntity<List<SintomatologiaDTO>>getSintomatologias(){
		System.out.println(sintomatologiaService.getSintomas());
		return new ResponseEntity<List<SintomatologiaDTO>>(sintomatologiaService.getSintomas(), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener prioridad de los sintomas
	   * @return Response entity de lista de dto's de prioridad de sintomas
	  */
	@ApiOperation(
	        value = "Metodo para obtener listado de prioridades. Devuelve response entity con la lista de prioridades"
	)
	@GetMapping("/prioridades") 
	public ResponseEntity<List<PrioridadSintomaDTO>>getPrioridades(){
		System.out.println(sintomatologiaService.getSintomas());
		return new ResponseEntity<List<PrioridadSintomaDTO>>(sintomatologiaService.getPrioridadesSintoma(), HttpStatus.OK);
	}
	
	/**
	   * End Point para añadir nuevo sintoma
	   * @param sintomatologiaData. DTO que contiene data del sintoma que se busca registrar
	   * @Exception 404 NOT FOUND
	   * @return Response entity de un DTO que contiene la info de session del usuario.
	 * @throws SintomaAlreadyExistsException 
	 * @throws Exception 
	   */
	@ApiOperation(
	        value = "Metodo par agregar un nuevo sintoma. Recibe la data del nuevo sintoma, como lo es su nombre, especialides asociadas y su prioridad",
	        notes = "Retornar Error 409 si el sintoma ya existia"
	)
	@PostMapping("/") 
	public ResponseEntity<SintomatologiaDTO>addSintomatologias(@RequestBody @Valid RegistroSintomaDTO sintomatologiaData) throws SintomaAlreadyExistsException{
		System.out.println("Entraaaaaaaaaaando");
		return new ResponseEntity<SintomatologiaDTO>(sintomatologiaService.addSintoma(sintomatologiaData), HttpStatus.OK);

	}
}
