package com.project.saludLegal.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.TipoCitaDTO;
import com.project.saludLegal.DTOS.TipoContratoDTO;
import com.project.saludLegal.exceptions.BadValueException;
import com.project.saludLegal.mappers.TiposMapper;
import com.project.saludLegal.models.TipoCita;
import com.project.saludLegal.models.TipoContrato;
import com.project.saludLegal.repositories.CuotaRepository;
import com.project.saludLegal.repositories.TipoCitaRepository;
import com.project.saludLegal.repositories.TipoContratoRepository;

/**

 * Service para logica relacionado a tareas de configuracion como modificar cuotas moderadoras 

 * @author: Manuel Alejandro Verjan Robles

 */
@Service
public class ConfiguracionService {
	
	@Autowired
	CuotaRepository cuotaRepository;
	@Autowired 
	TipoContratoRepository tipoContratoRepository;
	@Autowired 
	TipoCitaRepository tipoCitaRepository;
	@Autowired
	TiposMapper tiposMapper;
	
	/**
	   * Servicio modificar una cuota moderadora
	   * @param idTipoCita. Id del tipo de cita relacionado a la cuota moderadora
	   * @param idContrato. Id del tipo de contrato relacionado a la cuota moderadora
	   * @Param nuevoValor. Nuevo valor de la cuota moderadora
	   * @Param idPaciente. Id del operario que realizó el cambio
	   * @return Entero indicando si se actualizó el estado de la cita, es decir, si se cancelo
	 * @throws BadValueException 
	*/
	@Transactional
	public int modificarCuota(Long idTipoCita, Long idContrato, Long nuevoValor, Long idOperario) throws BadValueException {
		if(nuevoValor<0) {
			throw new BadValueException("El valor no puede ser menor a cero");
		}
		this.addLogCuota(idTipoCita, idContrato, nuevoValor, idOperario);
		return cuotaRepository.setValorCuotaModeradoraforCuotaModeradora(idTipoCita, idContrato, nuevoValor);
	}
	
	
	
	/**
	   * Servicio agregar log de la modificación de una cuota moderadora
	   * @param idTipoCita. Id del tipo de cita relacionado a la cuota moderadora
	   * @param idContrato. Id del tipo de contrato relacionado a la cuota moderadora
	   * @Param nuevoValor. Nuevo valor de la cuota moderadora
	   * @Param idPaciente. Id del operario que realizó el cambio
	*/
	public void addLogCuota(Long idTipoCita, Long idContrato, Long nuevoValor, Long idOperario) {
		cuotaRepository.logCambioCuota(idTipoCita, idContrato, nuevoValor, idOperario);
	}
	
	/**
	   * Servicio para obtener tipos de contrato
	   * @return Lista de DTO's de tipos de contrato
	*/
	public List<TipoContratoDTO> getTiposContrato (){
		return tiposMapper.toListTipoContratoDTO((List<TipoContrato>)tipoContratoRepository.findAll());
	}
	
	/**
	   * Servicio para obtener tipos de contrato
	   * @return Lista de DTO's de tipos de cita
	*/
	public List<TipoCitaDTO> getTiposCita (){
		return tiposMapper.toListTipoCitaDTO((List<TipoCita>)tipoCitaRepository.findAll());
	}
}
