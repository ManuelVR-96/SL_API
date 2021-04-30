package com.project.saludLegal.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.saludLegal.DTOS.CitaDTO;
import com.project.saludLegal.DTOS.CitaRegistroDTO;
import com.project.saludLegal.exceptions.AppointmentAlreadyExistsException;
import com.project.saludLegal.exceptions.CantAppointException;
import com.project.saludLegal.services.CitaService;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;


/**

 * Controlador para manejar peticiones referentes a las citas

 * @author: Manuel Alejandro Verján Robles

 */

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	/**
	   * End Point para obtener citas no agendadas
	   * @return Lista de Response entities de DTO's que contienen de las citas no agendadas.
	 */
	@ApiOperation(value = "Metodo para obtener citas no agendadas. Retorna un response entity con la lista de citas")
	@GetMapping("/pendientes")
	public ResponseEntity<List<CitaDTO>> citasNoAgendadas(){
		return new ResponseEntity<List<CitaDTO>>(citaService.citasSinAgendar(), HttpStatus.OK);
	}
	
	
	 /**
	   * End Point para agregar una nueva cita
	   * @param datacita. DTO que contiene cedula del paciente que solicita cita, sintoma asociado, especialidad requerida y tipo cita
	   * @Exception 404 NOT FOUND, INTERNAL SERVER ERROR
	   * @return Response entity de un DTO que contiene la info de la cita registrada
	 * @throws Exception 
	 */
	
	@ApiOperation(
	        value = "Metodo para agregar una nueva cita. Retorna response entity con la nueva cita agregada",
	        notes = "Retorna ERROR 404 si no se encontro un paciente con la cedula ingresada, 0 409 si el paciente ya tiene una cita en espera")
	@PostMapping("/")
	public ResponseEntity<CitaDTO> addCita(@Valid @RequestBody CitaRegistroDTO dataCita) throws Exception{
		// Se intenta agregar la cita, si falla se retorna el error, el cual puede ser 500 por fallo del servidor 
		// o 404, ya sea porque no se encuentra una agenda abierta para dicha cita, o porque no se encontro un paciente con la cedula indicada
		// 0 409 si ya se ha solicitado una cita para este paciente en esta especialidad
			return new ResponseEntity<CitaDTO>(citaService.saveCita(dataCita), HttpStatus.OK);
	}
	
	
	/**
	   * End Point para cancelar una cita
	   * @param PathVariable con el id de la cita que se busca cancelar
	   * @Exception 404 NOT FOUND
	   * @return Response entity informando si la cita se cancelo exitosamente
	*/
	@ApiOperation(
	        value = "Metodo para cancelar una cita. Retorna response entity con la nueva cita cancelada",
	        notes = "Retorna ERROR 404 si no se encontro un paciente con la cedula ingresada, 0 409 si el paciente ya tiene una cita en espera")
	@PutMapping("/cancel")
	public ResponseEntity<Integer> cancelCita(@RequestBody @Valid CitaDTO forUpdate){
		Long idCita = forUpdate.getIdCita();
		Long idTurno = forUpdate.getIdTurno();
		System.out.println(idTurno);
		return new ResponseEntity<Integer>(citaService.cancelCita(idCita, idTurno), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener una cita
	   * @param PathVariable con el id de la cita que se busca
	   * @Exception 404 NOT FOUND
	   * @return Response entity informando si la cita se cancelo exitosamente
	*/
	@ApiOperation(
	        value = "Metodo para obtener una cita dado su id",
	        notes = "Retorna ERROR 404 si no se encontro la cita")
	@GetMapping("/{idCita}")
	public ResponseEntity<CitaDTO> getCita(@PathVariable Long idCita){
		CitaDTO cita = new CitaDTO();
		return new ResponseEntity<CitaDTO>(cita, HttpStatus.OK);
	}
	
	/**
	   * End Point auxiliar para agendar citas dado sintoma y especialidad
	*/
	@ApiOperation(
	        value = "Metodo auxiliar para agregar muchas citas dada un sintoma y una especialidad")
	@GetMapping("agregar_muchas_esp/{idSinto}/{idEspe}")
	public void agregar_muchas_especialidad(@PathVariable Long idSinto, @PathVariable Long idEspe) throws Exception{
		citaService.agendar_muchas_especialidad(idEspe, idSinto);
	}
	
	
	/**
	   * End Point auxiliar para agendar citas de forma masiva
	*/
	@ApiOperation(
	        value = "Metodo auxiliar para agregar citas de forma masiva")
	@GetMapping("agregar_muchas")
	public void agregar_muchas() throws Exception{
		citaService.agendar_muchas();
	}
	
	/**
	   * End Point para obtener una cita
	   * @param PathVariable con el id de la cita que se busca
	   * @Exception 404 NOT FOUND, 
	   * @return Response entity informando si la cita se cancelo exitosamente
	 * @throws Exception 
	*/

	@ApiOperation(
	        value = "Metodo para obtener todas las citas de un cliente en orden ascendente. Retorna response entity con la lista de citas",
	        notes = "Retorna error 404 si no se encontro un cliente con la cedula ingresada")
	@GetMapping("/citasPaciente/{cedulaPaciente}")
	public ResponseEntity<List<CitaDTO>> getCitasCliente(@PathVariable String cedulaPaciente) throws Exception{
		// Se intenta encontrar las citas del paciente. Si no se logra, se devuelve el correspondiente error, sea 404 por que el
		// paciente no existe, o 500 si ocurrio un error accediendo a la base de datos
		return new ResponseEntity<List<CitaDTO>>(citaService.citasPaciente(cedulaPaciente), HttpStatus.OK);
		
	}
	
	/**
	   * End Point para obtener una cita
	   * @param PathVariable con el id de la cita que se busca
	   * @Exception 404 NOT FOUND, 
	   * @return Response entity informando si la cita se cancelo exitosamente
	 * @throws Exception 
	*/

	@ApiOperation(
	        value = "Metodo para obtener citas de una especialidad dada",
			notes = "retorna error 500 si no se encontro la especialidad indicada")
	@GetMapping("/citasEspecialidad/{idEspecialidad}")
	public ResponseEntity<List<CitaDTO>> getCitasEspecialidad(@PathVariable Long idEspecialidad) throws Exception{
		// Se intenta encontrar las citas del paciente. Si no se logra, se devuelve el correspondiente error, sea 404 por que el
		// paciente no existe, o 500 si ocurrio un error accediendo a la base de datos
		return new ResponseEntity<List<CitaDTO>>(citaService.citasEspecialidad(idEspecialidad), HttpStatus.OK);
		
	}
}
