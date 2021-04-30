package com.project.saludLegal.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;


@Entity
@Table(name="SL_agendas") 
public class Agenda {
	
	@Id
	@Column(name="id_agenda",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgenda;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_agenda",unique=true, nullable=false)
	private LocalDate fechaAgenda;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_medico")
	private Medico idMedico;
	
	
	public Agenda(LocalDate fechaAgenda, Medico idMedico) {
		this.fechaAgenda = fechaAgenda;
		this.idMedico = idMedico;
	}
	
	public Agenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	
	public Agenda() {
		super();
	}

	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public LocalDate getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(LocalDate fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public Medico getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

}
