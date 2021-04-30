package com.project.saludLegal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.CitaDTO;
import com.project.saludLegal.DTOS.CitaRegistroDTO;
import com.project.saludLegal.DTOS.EspecialidadDTO;
import com.project.saludLegal.exceptions.AppointmentAlreadyExistsException;
import com.project.saludLegal.mappers.CitasMapper;
import com.project.saludLegal.mappers.EspecialidadMapper;
import com.project.saludLegal.models.CentroMedico;
import com.project.saludLegal.models.Cita;
import com.project.saludLegal.models.CuotaModeradora;
import com.project.saludLegal.models.Especialidad;
import com.project.saludLegal.models.EstadoCita;
import com.project.saludLegal.models.Paciente;
import com.project.saludLegal.models.Sintomatologia;
import com.project.saludLegal.models.SintomatologiaEspecialidad;
import com.project.saludLegal.models.TipoCita;
import com.project.saludLegal.repositories.CentroRepository;
import com.project.saludLegal.repositories.CitasRepository;
import com.project.saludLegal.repositories.CuotaRepository;
import com.project.saludLegal.repositories.EspecialidadRepository;
import com.project.saludLegal.repositories.EstadoCitaRepository;
import com.project.saludLegal.repositories.PacienteRepository;
import com.project.saludLegal.repositories.SintomaEspecialidadRepository;
import com.project.saludLegal.repositories.SintomatologiaRepository;
import com.project.saludLegal.repositories.TipoCitaRepository;
import com.project.saludLegal.repositories.TurnoRepository;

import javassist.NotFoundException;


/**

 * Service para manejar la logica asociada a las citas

 * @author: Manuel Alejandro Verjan Robles

 */

@Service
public class CitaService {
	//Repositorios usados en el service
	@Autowired
	CitasRepository citaRepository;
	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	CentroRepository centroRepository;
	@Autowired
	CuotaRepository cuotaRepository;
	@Autowired
	EspecialidadRepository especialidadRepository;
	@Autowired
	SintomatologiaRepository sintomatologiaRepository;
	@Autowired
	TipoCitaRepository tipoCitaRepository;
	@Autowired
	EstadoCitaRepository estadoCitaRepository;
	@Autowired
	TurnoRepository turnoRepository;
	@Autowired
	SintomaEspecialidadRepository sintoEspeRepository;
	
	// Mapper para DTO's de citas
	@Autowired
	CitasMapper citasMapper;
	// Mapper para DTO's de citas
	@Autowired
	EspecialidadMapper especialidadesMapper;
	
	/**
	   * Servicio para cancelar una cita
	   * @param idCita. Id relacionado a la cita que se busca cancelar
	   * @return Entero indicando si se actualizó el estado de la cita, es decir, si se cancelo
	*/
	@Transactional 
	public int cancelCita(Long idCita, Long idTurno) {
		if(idTurno!=null) {
			System.out.print("not null");
			turnoRepository.setEstadoTurnoForTurno(idTurno);
		}
		return citaRepository.setEstadoCitaForCita(idCita);
	}
	
	/**
	   * Servicio para retornar citas sin agendar
	   * @return Lista de DTO's de citas no agendadas
	*/
	public List<CitaDTO> citasSinAgendar(){
		return citasMapper.toCitaDtoList(citaRepository.findByEstadoCita_idEstadoCita(1L));
	}
	
	/**
	   * Servicio para buscar citas de un paciente
	   * @param cedulaPaciente. Cedula del paciente del cual se buscan sus citas
	   * @return Lista con los DTO de las citas encontradas
	   * @throws NotFoundException 
	*/
	public List<CitaDTO> citasPaciente(String cedulaPaciente) throws NotFoundException{
		// Si el paciente correspondiente a la cedula ingresada no existe, es decir, es null, se lanza error 404
		Paciente paciente = pacienteRepository.findPacienteByCedula(cedulaPaciente);
		if(paciente==null) {
			throw new NotFoundException("El paciente no existe!!!");
		}
		//Se obtiene id del paciente para buscar las citas con su id
		Long idPaciente = paciente.getIdPaciente();
		// Se buscan las citas con su id
		return citasMapper.toCitaDtoList(citaRepository.findByPaciente_idPacienteAndEstadoCita_idEstadoCita(idPaciente, 3L));
	}
	
	/**
	   * Servicio para buscar citas pertenencientes a una especialidad
	   * @param idEspecialidad. Id de la especialidad de la cual se buscan las citas
	   * @return Lista con los DTO de las citas encontradas
	   * @throws NotFoundException 
	*/
	public List<CitaDTO> citasEspecialidad(Long idEspecialidad) throws NotFoundException{
		// Si la especialidad buscada no existe, es decir, es null, se lanza error 404
		if (!especialidadRepository.existsById(idEspecialidad)) {
			throw new NotFoundException("La especialidad buscada, no existe!!!");
		}
		// Si la especialidad no es null, se devuelve la especialidad 
		return citasMapper.toCitaDtoList(citaRepository.findByEspecialidad(idEspecialidad));
	}
	
	/**
	   * Servicio para buscar especialidades asociadas a un sintoma
	   * @param idSintoma. Id del sintoma del cual se buscan las especialidades asociadas
	   * @return Lista con los DTO de las especialidades encontradas
	   * @throws NotFoundException 
	*/
	public List<EspecialidadDTO> sintomaEspecialidad(Long idSintoma) throws NotFoundException{
		if(!sintomatologiaRepository.existsById(idSintoma)) {
			throw new NotFoundException("No se ha encontrado el síntoma");
		}
		List<SintomatologiaEspecialidad> listaResultados = sintoEspeRepository.findBySintomatologia_idSintomatologia(idSintoma);
		List<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
		listaResultados.stream().map(result -> listaEspecialidad.add(result.getEspecialidad())).collect(Collectors.toList());
		return especialidadesMapper.toListEspecialidadDTO(listaEspecialidad); 
	}
	
	
	 /**
	   * Servicio para agregar una nueva cita
	   * @param cita. DTO que contiene cedula del paciente que solicita cita, sintoma asociado, especialidad requerida y tipo cita
	   * @Exception 404 NOT FOUND
	   * @return Response entity de un DTO que contiene la info de la cita agregada
	   */
	@Transactional
	public CitaDTO saveCita(CitaRegistroDTO cita) throws Exception {
		Cita citaGuardar = new Cita();
		// Se busca el paciente relacionado a la cedula ingresada
		Paciente paciente = pacienteRepository.findPacienteByCedula(cita.getCedulaPaciente());
		// Si es nulo, se devuelve un Not Found Exception
		if(paciente==null) {
			throw new NotFoundException("El paciente no existe!!!");
		}
		
		// Se busca el centro medico asignado al paciente
		CentroMedico centroMedico = paciente.getUbicacionGeografica().getCentroMedico();
			
			//Se verifica si el cliente ya tiene una cita para dicha especialidad en espera, de ser asi, se lanza una excepcion
		if(citaRepository.tiene_pendientes(cita.getEspecialidad(),paciente.getIdPaciente(), 1L)) {
			throw new AppointmentAlreadyExistsException("El cliente ya tiene una cita pendiente de agenda para esta especialidad !!!");
				//return citasMapper.citaToCitaDTO(new Cita());
		}
		
//		if(turnoRepository.turnos_disponibles(cita.getEspecialidad(),
//				2L,centroMedico.getIdCentroMedico())<=0) { throw new
//			NotFoundException("No hay agenda abierta para la cita solicitada"); }
		 
		Integer val_prioridad_contrato = 0;
		// Se obtiene prioridad del contrato. Si la cita NO es prioritaria, se asigna el valor de prioridad correspondiente al contrato del paciente
		if(cita.getTipoCita()!=4L) {
			val_prioridad_contrato = paciente.getTipoContrato().getValorPrioridadContrato();
		} else { //Pero si la cita solicitada es prioritaria, se le asignara el valor de prioridad maximo de contrato, sin importar si este es el mas basico, esto con el fin de ser agendada de manera oportuna
			val_prioridad_contrato = 40;
		}
		// Se obtiene sintoma asociado y su valor de proridad
		Sintomatologia sintoma = sintomatologiaRepository.findById(cita.getSintoma()).orElse(null);
		Integer val_prioridad_sintoma = sintoma.getPrioridadSintoma().getValorPrioridad();
		// Se obtiene especialidad requerida
		Especialidad especialidad = especialidadRepository.findById(cita.getEspecialidad()).orElse(null);
		// Se obtiene el tipo de cita solicitada
		TipoCita tipoCita = tipoCitaRepository.findById(cita.getTipoCita()).orElse(null);
		// Se asigna el estado de cita
		EstadoCita estadoCita = estadoCitaRepository.findById(1L).orElse(null);
		// Se obtiene la cuota moderadora de la cita, haciendo uso del tipo de contrato y el tipo de cita
		CuotaModeradora cuota = cuotaRepository.findByIdTipoContratoIdTipoContratoAndIdTipoCitaIdTipoCita(paciente.getTipoContrato().getIdTipoContrato(), tipoCita.getIdTipoCita());
		// Se setean todos los valores de la cita 
		citaGuardar.setPaciente(paciente);
		citaGuardar.setEspecialidad(especialidad);
		citaGuardar.setSintomatologia(sintoma);
		citaGuardar.setTipoCita(tipoCita);
		citaGuardar.setCuotaModeradora(cuota);
		citaGuardar.setPrioridad(Long.valueOf(val_prioridad_contrato*val_prioridad_sintoma));
		citaGuardar.setCentroMedico(centroMedico);
		citaGuardar.setEstadoCita(estadoCita);
		citaRepository.save(citaGuardar);
		return citasMapper.citaToCitaDTO(citaGuardar);
	}
	
	
	/**
	 * Servicio auxiliar para agendar muchas agendas de forma masiva
	 * @throws Exception
	 */
	public void agendar_muchas() throws Exception {
		System.out.println("agregando muchas citas");
		ArrayList<SintomatologiaEspecialidad> todosSintomas = (ArrayList<SintomatologiaEspecialidad>)sintoEspeRepository.findAll();
		ArrayList<TipoCita> todosTipos = (ArrayList<TipoCita>) tipoCitaRepository.findAll();
		ArrayList<Paciente> todosPacientes = (ArrayList<Paciente>) pacienteRepository.findAll();
		
		for(Paciente paciente: todosPacientes) {
			for(int i=0; i<3; i++) {
				int indice_sintoma = (int) Math.floor(Math.random()*(todosSintomas.size()));
				int indice_tipo = (int) Math.floor(Math.random()*(todosTipos.size()));
				SintomatologiaEspecialidad sintoma = todosSintomas.get(indice_sintoma);
				TipoCita tipoCita = todosTipos.get(indice_tipo);
				try {
					CitaRegistroDTO cita = new CitaRegistroDTO(paciente.getCedula(), sintoma.getSintomatologia().getIdSintomatologia(), 
							sintoma.getEspecialidad().getIdEspecialidad(), tipoCita.getIdTipoCita());
					this.saveCita(cita);
				} catch(Exception e) {
					System.out.println(e);
				}
			}	
		}
	}
	
	/**
	   * Servicio auxiliar para generación masiva de citas dada una especialidad, para prueba del Software
	   */
	public void agendar_muchas_especialidad(Long idEspecialidad, Long idSintoma) throws Exception {
		ArrayList<Paciente> todosPacientes = (ArrayList<Paciente>) pacienteRepository.findAll();
			for(Paciente paciente: todosPacientes) {
					CitaRegistroDTO cita = new CitaRegistroDTO(paciente.getCedula(), idSintoma, idEspecialidad, 1L);
					this.saveCita(cita);
		}
	}
}
