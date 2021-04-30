package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_estados_citas")
public class EstadoCita {
	
	@Id
	@Column(name="id_estado_cita")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEstadoCita; 
	
	@Column(name="desc_estado_cita", nullable=false)
	private String descEstadoCita;

	public Long getIdEstadoCita() {
		return idEstadoCita;
	}

	public EstadoCita() {
		super();
	}

	public void setIdEstadoCita(Long id_estado_cita) {
		this.idEstadoCita = id_estado_cita;
	}
	
	

	public EstadoCita(Long idEstadoCita, String descEstadoCita) {
		super();
		this.idEstadoCita = idEstadoCita;
		this.descEstadoCita = descEstadoCita;
	}

	public String getDescEstadoCita() {
		return descEstadoCita;
	}

	public void setDescEstadoCita(String descEstadoCita) {
		this.descEstadoCita = descEstadoCita;
	}
}
