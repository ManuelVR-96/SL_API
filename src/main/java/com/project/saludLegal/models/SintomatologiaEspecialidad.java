package com.project.saludLegal.models;

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
@Table(name="SL_sintomatologias_especialidades")
public class SintomatologiaEspecialidad {
	
	@Id
	@Column(name="id_sintomatologia_especialidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSintomatologiaEspecialidad;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sintomatologia")
	private Sintomatologia sintomatologia;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;
	
	public SintomatologiaEspecialidad(Sintomatologia sintomatologia, Especialidad especialidad) {
		super();
		this.sintomatologia = sintomatologia;
		this.especialidad = especialidad;
	}
	
	public SintomatologiaEspecialidad() {
	}

	public Long getIdSintomatologiaEspecialidad() {
		return idSintomatologiaEspecialidad;
	}

	public void setIdSintomatologiaEspecialidad(Long idSintomatologiaEspecialidad) {
		this.idSintomatologiaEspecialidad = idSintomatologiaEspecialidad;
	}

	public Sintomatologia getSintomatologia() {
		return sintomatologia;
	}

	public void setSintomatologia(Sintomatologia sintomatologia) {
		this.sintomatologia = sintomatologia;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

}
