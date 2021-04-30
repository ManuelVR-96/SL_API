package com.project.saludLegal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.saludLegal.DTOS.EspecialidadDTO;
import com.project.saludLegal.services.CitaService;
import com.project.saludLegal.services.EspecialidadService;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

/**

 * Controlador para manejar peticiones referentes a las especialidades

 * @author: Manuel Alejandro Verjan Robles

 */
@RestController
@RequestMapping("/especialidades")
@CrossOrigin(origins= {"*"})
public class EspecialidadController {
	
	// Inyeccion de dependencias del servicio de citas
	@Autowired
	CitaService citasService;
	// Inyeccion de dependencias de especialidades
	@Autowired
	EspecialidadService especialidadService;
	
	/**
	   * End Point obtener especialidades
	   * @return Response entity con lista de DTO's de especialidades
	 * @throws Exception 
	 */
	@ApiOperation(
	        value = "Metodo para obtener lista de especialidades. Retorna una response entity con la lista"
	)
	@GetMapping("/")
	public ResponseEntity<List<EspecialidadDTO>> getEspecialidades(){
		return new ResponseEntity<List<EspecialidadDTO>>(especialidadService.getEspecialidades(), HttpStatus.OK);
	}
	
	/**
	   * End Point para editar una cuota moderadora
	   * @param idSintoma. PathVariable con el id del sintoma del cual se requieren las especialidades
	   * @return Response entity con lista de DTO's con especialidades asociadas
	   * @throws NotFoundException 
	 */
	@ApiOperation(
	        value = "Metodo para obtener lista de especialidades asociadas a un sintoma. Recibe id del sintoma y retorna la lista de especialidades",
	        notes = "Retorna error 404 si no encuentra el sintoma indicado"
	)
	@GetMapping("/asociadas/{idSintoma}")
	public ResponseEntity<List<EspecialidadDTO>> getEspecialidadesSintoma(@PathVariable Long idSintoma) throws NotFoundException{
		return new ResponseEntity<List<EspecialidadDTO>>(citasService.sintomaEspecialidad(idSintoma), HttpStatus.OK);
	}
}
