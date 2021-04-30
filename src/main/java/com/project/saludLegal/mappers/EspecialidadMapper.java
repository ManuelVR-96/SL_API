package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.saludLegal.DTOS.EspecialidadDTO;
import com.project.saludLegal.models.Especialidad;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Especialidad en instancia de EspecialidadDTO
 */
@Mapper(componentModel = "spring")
public interface EspecialidadMapper {
	
	EspecialidadDTO especialidadToEspecialidadDTO(Especialidad especialidad);
	
	List<EspecialidadDTO> toListEspecialidadDTO(List<Especialidad> especialidades);
}
