package com.project.saludLegal.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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

import com.project.saludLegal.DTOS.AgendaDTO;
import com.project.saludLegal.DTOS.AperturaAgendasDTO;
import com.project.saludLegal.exceptions.CantAppointException;
import com.project.saludLegal.services.AgendaService;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

/**

 * Controlador para manejar peticiones referentes a las citas

 * @author: Manuel Alejandro Verjan Robles

 */
@RestController
@RequestMapping("/agendas")
@CrossOrigin(origins= {"*"})
public class AgendaController {
	
	// Inyeccion de dependencia del servicio de agendas
	@Autowired
	AgendaService agendaService;
	
	/**
	   * End Point para agregar una nueva agenda
	   * @param data. DTO que contiene el id del medico al cual se busca abrir agendas, asi como el rango de fecha en que se busca abrirlas
	   * @Exception 404 NOT FOUND, DiaryAlreadyExistsException
	   * @return Response entity informando que todo salio bien.
	 * @throws Exception 
	 */
	@ApiOperation(value = "Metodo para añadir nueva agenda. Retorna response entity con un HashMap indicando el exito de la operacion")
	@PostMapping("/")
	public  ResponseEntity<?> addAgenda(@RequestBody @Valid AperturaAgendasDTO data) throws Exception{
		// HashMap usado para devolver el mensaje de exito
		HashMap<String, String> result = new HashMap<String, String>();
		agendaService.abrirAgendas(data);	
		result.put("resultado", "Agendas agregadas");
		return new ResponseEntity<HashMap<String, String>>(result, HttpStatus.OK);
	}	
	
	/**
	   * End Point para obtener las agendas de un medico en particular
	   * @param idMedico. PathVariable que indica el id del cual se busca la agenda
	   * @return Response entity con la lista de las citas del medico
	   * @throws NotFoundException 
	 */
	@ApiOperation(
	        value = "Metodo para obtener agendas de un medico. Retorna la lista de agendas relacionadas a un medico",
	        notes = "Retorna ERROR 404 si no hay un médico con el id indicado")
	@GetMapping("agendasMedico/{idMedico}") 
	public ResponseEntity<List<AgendaDTO>> agendaMedico(@PathVariable Long idMedico) throws NotFoundException{
		System.out.println("agendas medicooooooooooooooooooooooooooo");
		return new ResponseEntity<List<AgendaDTO>>(agendaService.agendasMedico(idMedico), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener las fechas en que un médico ya tiene agenda
	   * @param idMedico. PathVariable que indica el id del cual se buscan las fechas
	   * @return Response entity con la lista de las fechas
	   * @throws NotFoundException 
	 */
	@ApiOperation(
	        value = "Metodo para obteener fechas en que el medico ya tiene agenda. Retorna una lista con las fechas en que el médico ya tiene agenda",
	        notes = "Retorna ERROR 404 si no se encontró un paciente con el id indicado")
	@GetMapping("fechasAgendadas/{idMedico}") 
	public ResponseEntity<List<String>> fechasAgendasMedico(@PathVariable Long idMedico) throws NotFoundException{
		System.out.println("agendas medicooooooooooooooooooooooooooo");
		return new ResponseEntity<List<String>>(agendaService.fechas_agendadas(idMedico), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener las agendas de un medico en particular
	   * @param idMedico. PathVariable que indica el id del cual se busca la agenda
	 * @return 
	   * @return Response entity con la lista de las citas del medico
	 * @throws SQLException 
	 * @throws CantAppointException 
	   * @throws NotFoundException 
	 */
	
	@ApiOperation(
	        value = "Metodo para agendar citas pendientes. Retorna un response entity con un HashMap indicando el éxito de la operación",
	        notes = "Retorna ERROR 500 si el proceso de agendamiento falló")
	@GetMapping("agendar/{idUsuario}") 
	public ResponseEntity<HashMap<String,Integer>> agendar(@PathVariable Long idUsuario) throws CantAppointException, SQLException {
		System.out.println("Solicitando agendar");
		HashMap<String, Integer> result = agendaService.agendar(idUsuario);
		return new ResponseEntity<HashMap<String, Integer>>(result, HttpStatus.OK);
	}
	
	/**
	   * End Point auxiliar para abrir muchas agendas a un médico de manera rápida
	 */
	@ApiOperation(
	        value = "Metodo auxiliar para abrir agendas de forma masiva")
	@GetMapping("agregar_muchas") 
	public void agendar_muchas() throws Exception{
		this.agendaService.agendar_muchas();
	}
	
	/**
	   * End Point auxiliar para para vaciar citas, agendas y turnos
	 * @throws SQLException 
	 */
	@ApiOperation(
	        value = "End Point auxiliar para para vaciar citas, agendas y turnos")
	@GetMapping("vaciar") 
	public void vaciar() throws SQLException{
		this.agendaService.vaciar();
	}
}
