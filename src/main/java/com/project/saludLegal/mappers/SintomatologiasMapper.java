package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.project.saludLegal.DTOS.PrioridadSintomaDTO;
import com.project.saludLegal.DTOS.SintomatologiaDTO;
import com.project.saludLegal.models.PrioridadSintoma;
import com.project.saludLegal.models.Sintomatologia;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Sintomatologia en instancia de SintomatologiaDTO
 */
@Mapper(componentModel = "spring")
public interface SintomatologiasMapper {

	public SintomatologiaDTO sintomatoSintomaDTO(Sintomatologia sintoma);
	
	public List<SintomatologiaDTO> toListSintomaDTO(List<Sintomatologia> sintomas);
	
	
}
