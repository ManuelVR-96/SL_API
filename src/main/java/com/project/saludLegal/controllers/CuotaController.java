package com.project.saludLegal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.saludLegal.DTOS.CuotaDTO;
import com.project.saludLegal.DTOS.TipoCitaDTO;
import com.project.saludLegal.DTOS.TipoContratoDTO;
import com.project.saludLegal.exceptions.BadValueException;
import com.project.saludLegal.services.ConfiguracionService;

import io.swagger.annotations.ApiOperation;

/**

 * Controlador para manejar peticiones referentes a las cuotas moderadoras

 * @author: Manuel Alejandro Verjan Robles

 */
@RestController
@RequestMapping("/cuotas")
@CrossOrigin(origins= {"*"})
public class CuotaController {
	
	// Inyeccion de dependencia del service de configuracion
	@Autowired
	ConfiguracionService configuracionService;
	
	/**
	   * End Point para editar una cuota moderadora
	   * @param cuotaData. DTO con informacion de la cuota moderadora que se busca modificar y el nuevo valor de la misma
	   * @Exception 404 NOT FOUND, INTERNAL SERVER ERROR
	   * @return Response entity indicando si la operacion fue exitosa
	 * @throws BadValueException 
	 * @throws Exception 
	 */

	@ApiOperation(
	        value = "Metodo para editar cuota moderadora. Retorna un entero indicando si la cuota se actualizo"
	        )
	@PutMapping("/{idOperario}")
	public ResponseEntity<Integer> editarCuota (@RequestBody @Valid CuotaDTO cuotaData, @PathVariable Long idOperario) throws BadValueException{
		System.out.print("entrando");
		return new ResponseEntity<Integer>(configuracionService.modificarCuota(cuotaData.getIdTipoCita(), cuotaData.getIdTipoContrato(), cuotaData.getValorCuotaModeradora(), idOperario), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener los tipos de cita y visualizarlos en el front a la hora de modificar la cuota
	   * @return Lista con los DTO de los tipo de cita
	 */
	@ApiOperation(
	        value = "Metodo para cargar los tipos de cita. Retorna response entity con la lista de tipos de cita"
	)
	@GetMapping("/tiposCita")
	public ResponseEntity<List<TipoCitaDTO>> getTiposCita(){
		return new ResponseEntity<List<TipoCitaDTO>>(configuracionService.getTiposCita(), HttpStatus.OK);
	}
	
	/**
	   * End Point para obtener los tipos de contratos y visualizarlos en el front a la hora de modificar la cuota
	   * @return Lista con los DTO de los tipo de contrato
	 */
	@ApiOperation(
	        value = "Metodo para cargar los tipos de contrato. Retorna response entity con la lista de tipos de contrato"
	)
	@GetMapping("/tiposContrato")
	public ResponseEntity<List<TipoContratoDTO>> getTiposContrato(){
		return new ResponseEntity<List<TipoContratoDTO>>(configuracionService.getTiposContrato(), HttpStatus.OK);
	}
}
