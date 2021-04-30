package com.project.saludLegal.mappers;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.saludLegal.DTOS.CitaDTO;
import com.project.saludLegal.DTOS.TurnoDTO;
import com.project.saludLegal.models.Cita;
import com.project.saludLegal.models.Turno;

/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Turno en instancia de TurnoDTO
 */
@Mapper(componentModel = "spring", uses = { CitasMapper.class })// Se indica que se debe usar el CitasMapper para pasar el campo Cita,a CitaDTO
public interface TurnosMapper{
	
	@Mapping(source = "cita", target = "citaDTO")// Se convierte campo Cita a CitaDTO
	public TurnoDTO turnoToTurnoDTO (Turno turno);
	
	public List<TurnoDTO> toListTurnoDTO (List<Turno> listaTurnos);
	

	
}
