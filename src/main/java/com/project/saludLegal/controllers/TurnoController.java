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

import com.project.saludLegal.DTOS.TurnoDTO;
import com.project.saludLegal.exceptions.SintomaAlreadyExistsException;
import com.project.saludLegal.services.AgendaService;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

/**

 * Controlador para controlar peticiones de los turnos
 * @author: Manuel Alejandro Verjan Robles

 */
@RestController()
@RequestMapping("/turnos")
@CrossOrigin(origins= {"*"})
public class TurnoController {
	
	// Inyeccion de dependencia del servicio de agenda
	@Autowired
	AgendaService agendaService;
	
	/**
	   * End Point para añadir nuevo sintoma
	   * @param PathVariable idAgenda. Id de la agenda de la cual se requieren los turnos.
	   * @return Response entity con lista de DTO´s de turnos.
	 * @throws NotFoundException 
	 */
	@ApiOperation(
	        value = "Metodo para obtener los turnos relacionados a una agenda",
	        notes = "Retornar Error 404 si no se encuentra una agenda con el id indicado"
	)
	@GetMapping("/porAgenda/{idAgenda}")
	public ResponseEntity<List<TurnoDTO>>getTurnosAgenda(@PathVariable Long idAgenda) throws NotFoundException{
		System.out.println("entrando");
		return new ResponseEntity<List<TurnoDTO>>(agendaService.getTurnosAgenda(idAgenda), HttpStatus.OK);
	} 
}
