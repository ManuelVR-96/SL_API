package com.project.saludLegal.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.project.saludLegal.DTOS.AgendaDTO;
import com.project.saludLegal.models.Agenda;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Agenda en instancia de ModeloDTO
 */
@Mapper(componentModel = "spring")
public interface agendaMapper {
	
	
	  @Mappings({
		  @Mapping(target="nombreMedico", source="idMedico.nombre") // Se extrae el unicamente el nombre del medico
	  })
	 
	public AgendaDTO agendaToAgendaDTO(Agenda agenda);
	
	public List<AgendaDTO> toAgendaDtoList(List<Agenda> agendas);
}
