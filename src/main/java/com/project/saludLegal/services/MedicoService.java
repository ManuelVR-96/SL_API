package com.project.saludLegal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.CentroMedicoDTO;
import com.project.saludLegal.DTOS.MedicoDTO;
import com.project.saludLegal.mappers.CentroMapper;
import com.project.saludLegal.mappers.MedicoMapper;
import com.project.saludLegal.models.CentroMedico;
import com.project.saludLegal.repositories.CentroRepository;
import com.project.saludLegal.repositories.MedicoRepository;

/**

 * Service para logica relacionado a los medicos

 * @author: Manuel Alejandro Verjan Robles

 */
@Service
public class MedicoService {
	
	// Inyeccion de dependencia de los repositorios requeridos en el servicio
	@Autowired
	MedicoRepository medicoRepository;	
	@Autowired
	CentroRepository centroRepository;	
	// Inyeccion de dependencia de los mappers para los DTO's de centros medicos y medicos
	@Autowired
	CentroMapper centroMapper;	
	@Autowired 
	MedicoMapper medicoMapper;
	
	/**
	   * Servicio para obtener centros medicos
	   * @return Lista de DTO's de centros medicos
	*/
	public List<CentroMedicoDTO> getCentros(){
		return centroMapper.ToListCentroDTO((List<CentroMedico>) centroRepository.findAll());
	}
	
	/**
	   * Servicio para obtener medicos de un centro medico
	   * @return Lista de DTO's de medicos relacionados al centro medico
	*/
	public List<MedicoDTO> getMedicosCentro(Long idCentroMedico){
		return medicoMapper.toListMedicoDTO(medicoRepository.findByCentroMedico_idCentroMedico(idCentroMedico));
	}

}
