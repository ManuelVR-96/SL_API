package com.project.saludLegal.mappers;


/**
 * @author Manuel Alejandro Verjan
 * Mapper para convertir instancias de modelo Agenda en instancia de ModeloDTO
 */
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.project.saludLegal.DTOS.CitaDTO;
import com.project.saludLegal.models.Cita;

@Mapper(componentModel = "spring")
public interface CitasMapper {
	
	
	
	  @Mappings({
	  
	  @Mapping(target="nombreMedico", source="turno.agenda.idMedico.nombre"),// Se extrae el nombre del medico relacionado
	  
	  @Mapping(target="apellidosMedico", source="turno.agenda.idMedico.apellidos"),// Se extraen los apellidos del medico relacionado
	  
	  @Mapping(target="nombrePaciente", source="paciente.nombre"),// Se extrae el nombre del paciente relacionado
	  
	  @Mapping(target="apellidosPaciente", source="paciente.apellidos"),// Se extraen apellidos del paciente relacionado
	  
	  @Mapping(target="valorCuota", source="cuotaModeradora.valorCuotaModeradora"),// Se extrae el valor de la cita
	  
	  @Mapping(target="centroMedicoNombre", source="centroMedico.nombreCentroMedico"),// Del centro medico se extrae unicamente su nombre
	  
	  @Mapping(target="sintomaDesc", source="sintomatologia.descripcion"),// De la sintomatologia se extrae unicamente su descripcion
	  
	  @Mapping(target="especialidadDesc", source="especialidad.descripcionEspecialidad"),// De la especialidad se extrae unicamente su descripcion
	  
	  @Mapping(target="tipoCita", source="tipoCita.descTipoCita"),// Del tipo de cita de extrae unicamente su descripcion
	  
	  @Mapping(target = "nombreCompleto", ignore = true),// El campo nombreCompleto no se mapea inicialmente
	  
	  @Mapping(target="idTurno", source="turno.idTurno"),// Del tipo de cita de extrae unicamente su descripcion

	  
	  })
	  
	  CitaDTO citaToCitaDTO(Cita cita);
	  
	  // Despues del mapear los otros campos, se calcula el campo nombreCompleto
	  @AfterMapping // or @BeforeMapping
	    default void nombreCompleto(@MappingTarget CitaDTO citaDTO) {
	        citaDTO.setNombreCompleto(citaDTO.getNombreMedico()+ " " + citaDTO.getApellidosMedico());
	    }
	
	List<CitaDTO> toCitaDtoList(List<Cita> citas);
}
