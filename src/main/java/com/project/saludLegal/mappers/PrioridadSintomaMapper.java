package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.saludLegal.DTOS.PrioridadSintomaDTO;
import com.project.saludLegal.models.PrioridadSintoma;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo PrioridadSintoma en instancia de PrioridadSintomaDTO
 */
@Mapper(componentModel = "spring")
public interface PrioridadSintomaMapper {
	
	public PrioridadSintomaDTO prioridadSintomaToDTO(PrioridadSintoma prioridadSintoma);
	
	public List<PrioridadSintomaDTO> toListPrioridadSintomaDTO(List<PrioridadSintoma> prioridades);
}
