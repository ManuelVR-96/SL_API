package com.project.saludLegal.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.PrioridadSintomaDTO;
import com.project.saludLegal.DTOS.RegistroSintomaDTO;
import com.project.saludLegal.DTOS.SintomatologiaDTO;
import com.project.saludLegal.exceptions.SintomaAlreadyExistsException;
import com.project.saludLegal.mappers.PrioridadSintomaMapper;
import com.project.saludLegal.mappers.SintomatologiasMapper;
import com.project.saludLegal.models.PrioridadSintoma;
import com.project.saludLegal.models.Sintomatologia;
import com.project.saludLegal.models.SintomatologiaEspecialidad;
import com.project.saludLegal.repositories.EspecialidadRepository;
import com.project.saludLegal.repositories.PrioridadSintomaRepository;
import com.project.saludLegal.repositories.SintomaEspecialidadRepository;
import com.project.saludLegal.repositories.SintomatologiaRepository;

import javassist.NotFoundException;

/**

 * Service para logica relacionada a los sintomas

 * @author: Manuel Alejandro Verjan Robles

*/
@Service
public class SintomatologiaService {
	
	//Inyeccion de dependencia de los repositorios solicitados
	@Autowired
	SintomatologiaRepository sintomatologiaRepository;
	@Autowired
	SintomaEspecialidadRepository sintomaEspecialidadRepository;
	@Autowired
	PrioridadSintomaRepository prioridadSintomaRepository;
	@Autowired
	EspecialidadRepository especialidadRepository;
	// Inyeccion de dependencia de los mappers de sintomas y prioridades de sintomas
	@Autowired
	SintomatologiasMapper sintomatologiasMapper;
	@Autowired
	PrioridadSintomaMapper prioridadSintomaMapper;
	
	/**
	   * Servicio para obtener sintomas
	   * @return Lista de DTO's de sintomas
	  */
	public List<SintomatologiaDTO> getSintomas (){
		return sintomatologiasMapper.toListSintomaDTO((List<Sintomatologia>)sintomatologiaRepository.findAll());
	}
	
	/**
	   * Servicio para obtener prioridades de los sintomas
	   * @return Lista de DTO's de las prioridades de los sintomas
	 */
	public List<PrioridadSintomaDTO> getPrioridadesSintoma (){
		return prioridadSintomaMapper.toListPrioridadSintomaDTO((List<PrioridadSintoma>)prioridadSintomaRepository.findAll());
	}
	
	/**
	   * Service para agregar nuevo sintoma y guardar su relacion con las especialidades en la correspondiente tabla pivote
	   * @param sintomatologiaData, DTO que incluye nombre del sintoma y lista de especialidades asociadas
	   * @return DTO con la info del sintoma agregado
	   * @throws SintomaAlreadyExistsException 
	   */
	@Transactional
	public SintomatologiaDTO addSintoma(RegistroSintomaDTO sintomatologiaData) throws SintomaAlreadyExistsException {
		if(sintomatologiaRepository.existsByDescripcionIgnoreCase(sintomatologiaData.getDescSintoma())) {
			throw new SintomaAlreadyExistsException("Sintomatología repetida");
		}
		PrioridadSintoma prioridadSintoma = prioridadSintomaRepository.findById(sintomatologiaData.getIdPrioridad()).orElse(null);
		System.out.println("Prioridad = " + prioridadSintoma);
		Sintomatologia sintomaAgregar = new Sintomatologia(sintomatologiaData.getDescSintoma(), prioridadSintoma);
		sintomatologiaRepository.save(sintomaAgregar);
		
		sintomatologiaData.getEspecialidadesAsociadas().stream().forEach(idEspecialidad-> sintomaEspecialidadRepository.save(new
		SintomatologiaEspecialidad(sintomaAgregar, especialidadRepository.findById(idEspecialidad).orElse(null) )));

		 
		return sintomatologiasMapper.sintomatoSintomaDTO(sintomaAgregar);
		//return sintomatologiasMapper.sintomatoSintomaDTO(sintomaAgregar);
	}

}
