package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.saludLegal.DTOS.CentroMedicoDTO;
import com.project.saludLegal.models.CentroMedico;

@Mapper(componentModel = "spring")
public interface CentroMapper {
	
	CentroMedicoDTO centroToCentroDTO(CentroMedico centro);
	
	List<CentroMedicoDTO> ToListCentroDTO(List<CentroMedico> centro);
}
