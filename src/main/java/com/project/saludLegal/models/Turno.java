package com.project.saludLegal.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="SL_turnos") 
public class Turno {
	@Id
	@Column(name="id_turno",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTurno;
	
	@Valid
	@OneToOne(mappedBy = "turno")
    private Cita cita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_estado_turno")
    private EstadoTurno estadoTurno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_agenda")
    private Agenda agenda;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha", unique=true, nullable=true)
	private LocalDateTime fechaTurno;
		
	public Turno(LocalDateTime fechaTurno, EstadoTurno estadoTurno, Agenda agenda) {
		super();
		this.estadoTurno = estadoTurno;
		this.fechaTurno = fechaTurno;
		this.agenda = agenda;
	}

	public Turno(){
		}

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDateTime getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(LocalDateTime fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public EstadoTurno getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(EstadoTurno estadoTurno) {
		this.estadoTurno = estadoTurno;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	public Cita getCita() {
		return cita;
	}


}
