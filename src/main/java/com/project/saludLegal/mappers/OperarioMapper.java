package com.project.saludLegal.mappers;

import org.mapstruct.Mapper;

import com.project.saludLegal.DTOS.OperarioSessionDTO;
import com.project.saludLegal.models.Operario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Operario en instancia de OperarioDTO
 */
@Mapper(componentModel = "spring")
public interface OperarioMapper {
	
	@Mappings({
		@Mapping(target="nombreOperario", source="nombre"),// Nombre del operario
		@Mapping(target="apellidosOperario", source="apellidos"),// Apellidos del operario
		@Mapping(target="idRol", source="rol.idRol")// Del rol, se extrae unicamente su id
	})
	public OperarioSessionDTO operarioToOperarioSessionDTO(Operario operario);

}
