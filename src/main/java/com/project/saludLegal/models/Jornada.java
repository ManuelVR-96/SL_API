package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SL_jornadas")
public class Jornada {
	
	@Id
	@Column(name="id_jornada",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idJornada;
	
	@Column(name="nombre_jornada",unique=true, nullable=false)
	private String nombreJornada;
	
	@Column(name="horas_jornada",unique=true, nullable=false)
	private Integer horasJornada;
	
	public Long getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Long idJornada) {
		this.idJornada = idJornada;
	}

	public String getNombreJornada() {
		return nombreJornada;
	}

	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

	public Integer getHorasJornada() {
		return horasJornada;
	}

	public void setHorasJornada(Integer horasJornada) {
		this.horasJornada = horasJornada;
	}

	

}
