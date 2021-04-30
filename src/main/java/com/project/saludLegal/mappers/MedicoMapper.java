package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.project.saludLegal.DTOS.MedicoDTO;
import com.project.saludLegal.models.Medico;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Medico en instancia de MedicoDTO
 */
@Mapper(componentModel = "spring")
public interface MedicoMapper {
	
	@Mappings({
		  
		@Mapping(target="nombreEspecialidad", source="especialdad.descripcionEspecialidad"),// Se extrae el nombre de la especialidad del medico
		 
	})
	MedicoDTO medicoToMedicoDTO (Medico medico);
	
	public List<MedicoDTO> toListMedicoDTO (List<Medico> listasMedico);
}
