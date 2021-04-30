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

import com.project.saludLegal.DTOS.CentroMedicoDTO;
import com.project.saludLegal.DTOS.MedicoDTO;
import com.project.saludLegal.mappers.CentroMapper;
import com.project.saludLegal.services.MedicoService;

import io.swagger.annotations.ApiOperation;

/**

 * Controlador para manejar peticiones referentes a las medicos

 * @author: Manuel Alejandro Verjan Robles

 */
@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins= {"*"})
public class MedicoController {
	
	@Autowired
	MedicoService medicoService;
	@Autowired
	CentroMapper centroMapper;
	
	/**
	   * End Point obtener centros medicos
	  * @return Response entity con lista de DTO's de centros medicos
	 * @throws Exception 
	 */
	@ApiOperation(
	        value = "Metodo para obtener la lista de centros medicos"
	)
	@GetMapping("/centros")
	public ResponseEntity<List<CentroMedicoDTO>> getCentros(){
		return new ResponseEntity<List<CentroMedicoDTO>>(medicoService.getCentros(), HttpStatus.OK);
	}
	/**
	   * End Point obtener medicos de un centro medico
	   * @param idCentro. Path Variable con el id del centro del cual se solicitan los medicos
	   * @return Response entity con lista de DTO's de centros medicos
	 * @throws Exception 
	 */
	@ApiOperation(
	        value = "Metodo para obtener medicos de un centro medico. Retorna lista de los medicos"
	)
	@GetMapping("/porCentro/{idCentro}")
	public ResponseEntity<List<MedicoDTO>> getMedicosCentro(@PathVariable Long idCentro){
		return new ResponseEntity<List<MedicoDTO>>(medicoService.getMedicosCentro(idCentro), HttpStatus.OK);
	}
}
