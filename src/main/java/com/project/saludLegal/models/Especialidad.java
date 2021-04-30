package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_especialidades")
public class Especialidad {
	
	@Id
	@Column(name="id_especialidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspecialidad;
	@Column(name="descripcion_especialidad", nullable=false)
	private String descripcionEspecialidad;
	
	public Especialidad(Long idEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
	}
	
	public Especialidad() {
	}
	
	
	
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", descripcionEspecialidad=" + descripcionEspecialidad
				+ "]";
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

}
