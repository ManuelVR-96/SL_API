package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SL_estados_turnos")
public class EstadoTurno {
	
	@Id
	@Column(name="id_estado_turno", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEstadoTurno;
	
	@Column(name="desc_estado_turno", unique=true, nullable=true)
	private String descEstadoTurno;
	
	
	public EstadoTurno() {
		super();
	}

	public EstadoTurno(Long idEstadoTurno) {
		this.idEstadoTurno = idEstadoTurno;
	}

	public Long getIdEstadoTurno() {
		return idEstadoTurno;
	}

	public void setIdEstadoTurno(Long idEstadoTurno) {
		this.idEstadoTurno = idEstadoTurno;
	}

	public String getDescEstadoTurno() {
		return descEstadoTurno;
	}

	public void setDescEstadoTurno(String descEstadoTurno) {
		this.descEstadoTurno = descEstadoTurno;
	}

}
