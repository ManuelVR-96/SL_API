package com.project.saludLegal.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.saludLegal.DTOS.AgendaDTO;
import com.project.saludLegal.DTOS.AperturaAgendasDTO;
import com.project.saludLegal.DTOS.TurnoDTO;
import com.project.saludLegal.exceptions.CantAppointException;
import com.project.saludLegal.exceptions.DiaryAlreadyExistsException;
import com.project.saludLegal.mappers.TurnosMapper;
import com.project.saludLegal.mappers.agendaMapper;
import com.project.saludLegal.models.Agenda;
import com.project.saludLegal.models.EstadoTurno;
import com.project.saludLegal.models.Medico;
import com.project.saludLegal.models.Turno;
import com.project.saludLegal.repositories.AgendaJDBCRepository;
import com.project.saludLegal.repositories.AgendaJDBCRepositoryImp;
import com.project.saludLegal.repositories.AgendaRepository;
import com.project.saludLegal.repositories.MedicoRepository;
import com.project.saludLegal.repositories.TurnoRepository;

import javassist.NotFoundException;

import java.time.temporal.ChronoUnit;

/**

 * Service para manejar la logica asociada a las agendas

 * @author: Manuel Alejandro Verjan Robles

 */
@Service
public class AgendaService {
	
	// Inyeccion de dependencia de los repositorios requeridos
	@Autowired
	MedicoRepository medicoRepository;
	@Autowired
	AgendaRepository agendaRepository;
	@Autowired
	TurnoRepository turnoRepository;
	@Autowired
	AgendaJDBCRepositoryImp jdbcRepo;
	
	// Mapper para los DTO de las agendas
	@Autowired
	private agendaMapper agendaMapper;
	// Mappers para los DTO de los turnos
	@Autowired
	private TurnosMapper turnoMapper;
	
	/**
	   * Servicio para agendar citas
	 * @return HashMap que contiene la cantidad de citas que fueron asignadas, y las que quedaron sin asignar por falta de agenda (Si es el caso)
	 * @throws CantAppointException 
	 * @throws SQLException 
	*/
	public HashMap<String,Integer> agendar(Long idUsuario) throws CantAppointException, SQLException{
		HashMap<String, Integer> results = new HashMap<String, Integer>();
		try {
			results = jdbcRepo.agendar(idUsuario);
		} catch(SQLException e) {
			throw new CantAppointException("Un error ha ocurrido y no se han podido agendar las citas");
		}
		return results;
	}
	
	
	/**
	   * Servicio auxiliar para obtener festivos del año 2021
	*/
	public List<LocalDate> get_festivos(){
	List<String> festivos =  new ArrayList<String>(List.of("2021-04-01", "2021-04-02", "2021-05-01", "2021-05-17", "2021-06-07", "2021-06-14", 
	          "2021-07-05", "2021-07-20", "2021-08-07", 
	        "2021-08-16", "2021-10-18", "2021-11-01", "2021-11-15", "2021-12-08", "2021-12-25"));
	List<LocalDate> festivos_date = new ArrayList<LocalDate>();
	festivos_date = festivos.stream().map(fecha -> LocalDate.parse(fecha)).collect(Collectors.toList());
	
	return festivos_date;
	}
	
	/**
	 * Metodo para obtener las fechas en que un médico ya tiene agenda abierta
	 * @param idMedico
	 * @return
	 */
	public List<String> fechas_agendadas(Long idMedico){
		List<String> lista_fechas = new ArrayList<String>();
		List<Agenda> listaAgendas = (List<Agenda>)agendaRepository.findByidMedico(idMedico);
		lista_fechas = listaAgendas.stream().map(agenda -> agenda.getFechaAgenda().toString()).collect(Collectors.toList());
		return lista_fechas;
	}
	
	/**
	   * Servicio para buscar las agendas de un medico
	   * @param idMedico. Id del medico del que se busca las agendas
	   * @return Lista con los DTO de las agendas encontradas
	   * @throws NotFoundException 
	*/
	public List<AgendaDTO> agendasMedico(Long idMedico) throws NotFoundException{
		//Si no se encuentra el medico, se retorna una excepcion
		if(!medicoRepository.existsById(idMedico)) {
			throw new NotFoundException("No existe el médico!!!");
		}
		return agendaMapper.toAgendaDtoList(agendaRepository.findByidMedico(idMedico));
	}
	
	/**
	   * Servicio para buscar los turnos asociados a una agenda
	   * @param idAgenda. Id de la agenda de la cual se busca los turnos
	   * @return Lista con los DTO de los turnos encontrados encontradas
	   * @throws NotFoundException 
	*/
	public List<TurnoDTO> getTurnosAgenda(Long idAgenda) throws NotFoundException{
		// Si no se encuentra la agenda, se envia un mensaje indicando que la agenda no existe
		if(!agendaRepository.existsById(idAgenda)) {
			throw new NotFoundException("No existe la agenda");
		}
		return turnoMapper.toListTurnoDTO(turnoRepository.findByAgenda_idAgenda(idAgenda));
	}
	
	
	/**
	   * Servicio para abrir agendas a un medico
	   * @param data. DTO con el id del medico, y la fecha de inicio y fin de las agendas.
	   * @return confirmacion de que las agendas fuera abiertas con exito
	   * @throws NotFoundException, DiaryAlreadyExistsException 
	*/
	@Transactional
	public boolean abrirAgendas (AperturaAgendasDTO data) throws Exception {
		
		// Se extraen fecha de inicio y fin del agendamiento
		List<LocalDate> festivos = this.get_festivos();
		LocalDate fechaInicio = LocalDate.parse(data.getFechaInicio()); 
		LocalDate fechaFin = LocalDate.parse(data.getFechaFinal()); 
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		// Se obtiene la cantidad de días que comprende dicho periodo de tiempo
		Long cantidadDias = Math.abs(ChronoUnit.DAYS.between(fechaFin, fechaInicio));
		// Se obtiene el medico al cual se busca asignar dicha agenda
		Medico medico = medicoRepository.findById(data.getIdMedico()).orElse(null);
		if (medico==null) {
			throw new NotFoundException("No existe el médico!!!");
		}
		// Se obtienen las horas de la jornada del médico
		Integer cantidadHoras = medico.getJornada().getHorasJornada();
		// Variable DATE auxiliar, para recorrer todas las fechas comprendidas en dicho rango.
		LocalDate fecha = fechaInicio;
		// Se cambia la hora a las 8AM
		int horaInicio = 8;
		int minutosInicio = 0;
		//fecha.setHours(horaInicio);
		System.out.println("Fecha antes del loop: " + fecha);
		System.out.println("-------------");
		// Loop para recorrer los días 
		  for(int i=0; i<=cantidadDias; i++) { 
			  // Se corrobora si no existe una agenda para dichos días
			  System.out.println(fecha);  
			  //System.out.println("Existe: " + agendaRepository.existsByfechaAgenda(fecha));
			  System.out.println("____");
			  // Se crea una nueva agenda y se guarda
				
			  if(agendaRepository.existsByfechaAgendaAndIdMedico_IdMedico(fecha, data.getIdMedico())) { 
				  throw new DiaryAlreadyExistsException("YA EXISTE FECHA!!!"); 
			  }
				  
			  if(fecha.getDayOfWeek().getValue()!=7 && !festivos.contains(fecha) ) {
				  Agenda nuevaAgenda = new Agenda(fecha ,medico);
				  agendaRepository.save(nuevaAgenda);
			  // Loop para recorrer las horas de trabajo del médico
				  for (int j=0; j<cantidadHoras*2; j++) {
				  			// Se crea una variable de tipo calendar para obtener fechas
				  			//calendar.setTime(fecha);  
				  			// Si la hora es diferente la 1pm (Hora de almuerzo)se crea un turno nuevo y se guarda
				  			if (horaInicio != 13) {
				  				Turno turno = new Turno(LocalDateTime.of(fecha, LocalTime.of(horaInicio, minutosInicio)), new EstadoTurno(2L), nuevaAgenda);
								 turnoRepository.save(turno);
								 System.out.println("fecha = " + turno.getFechaTurno());
				  			}
							 // Se aumenta la hora actual en 30 minutos
							 if (j%2==0) {
								  minutosInicio+=30;
							 }
								  else {
								  horaInicio+=1;
								  minutosInicio = 0;
							  } 
				  			System.out.println("Los Domingos no se trabaja =) !!!!");
				  		  
				  	}
			  }
		  // Se aumenta el día en 1
		  fecha = fecha.plusDays(1L);
		  // Se reinicia la hora de inicio a las 8am
		  horaInicio = 8;
		  minutosInicio = 0;
		  
		  }
		 
		return true;
	}
	
	/**
	   * Servicio auxiliar para generacion masiva de agendas para pruebas del software
	*/
	@Transactional
	public void agendar_muchas() throws Exception{
		//Si no se encuentra el medico, se retorna una excepcion
		String fechaInicio = "2021-05-01";
		String fechaFinal = "2021-06-01";
		ArrayList<Medico> todosMedico = (ArrayList<Medico>) medicoRepository.findAll();
		for(Medico medico: todosMedico ) {
			System.out.println(medico.getNombre()+"/n");
			AperturaAgendasDTO agendar = new AperturaAgendasDTO(fechaInicio, fechaFinal, medico.getIdMedico());
			this.abrirAgendas(agendar);
		}
	}
	
	/**
	   * Servicio auxiliar para vaciar las tablas de citas, agendas y turnos.
	*/
	public void vaciar() throws SQLException{
		this.jdbcRepo.vaciar();
	}
	
	

}
