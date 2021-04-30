package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.saludLegal.DTOS.PrioridadSintomaDTO;
import com.project.saludLegal.DTOS.TipoCitaDTO;
import com.project.saludLegal.DTOS.TipoContratoDTO;
import com.project.saludLegal.models.PrioridadSintoma;
import com.project.saludLegal.models.TipoCita;
import com.project.saludLegal.models.TipoContrato;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de TipoContrato en instancia de TipoContratoDTO y TipoCita en TipoCitaDTO
 */
@Mapper(componentModel = "spring")
public interface TiposMapper {
	
	public TipoCitaDTO tipoCitaToDTO(TipoCita tipoCita);
	
	public List<TipoCitaDTO> toListTipoCitaDTO(List<TipoCita> tiposCita);
	
	public TipoContratoDTO tipoContratoToDTO(TipoContrato tipoContrato);
	
	public List<TipoContratoDTO> toListTipoContratoDTO(List<TipoContrato> prioridades);
	

}
