package com.project.saludLegal.DTOS;

import java.io.Serializable;

/**

 * DTO para especialidades.

 * @author: Manuel Alejandro Verjan Robles

 */
public class EspecialidadDTO implements Serializable{
	
	private Long idEspecialidad;// Id de la especialidad
	private String descripcionEspecialidad;// Descripcion de la especialidad
	
	private static final long serialVersionUID = 1L;
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
