package com.project.saludLegal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.EspecialidadDTO;
import com.project.saludLegal.mappers.EspecialidadMapper;
import com.project.saludLegal.models.Especialidad;
import com.project.saludLegal.repositories.EspecialidadRepository;

/**

 * Service para logica relacionado a las especialidades

 * @author: Manuel Alejandro Verjan Robles

 */
@Service
public class EspecialidadService {
	@Autowired
	EspecialidadRepository especialidadRepository;
	@Autowired
	EspecialidadMapper especialidadMapper;
	
	/**
	   * Servicio para obtener especialidades
	   * @return Lista de DTO's de especialidades
	*/
	public List<EspecialidadDTO> getEspecialidades(){
		return especialidadMapper.toListEspecialidadDTO((List<Especialidad>)especialidadRepository.findAll());
	}
	
	
	

}
