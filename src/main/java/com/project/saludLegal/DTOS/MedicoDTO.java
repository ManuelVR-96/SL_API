package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para modelo medicos

 * @author: Manuel Alejandro Verjan Robles

 */
public class MedicoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="El id del medico no puede ser vacio")
	private Long idMedico;// Id del medico
	
	@NotBlank(message="Los apellidos de medico no pueden ser vacios")
	private String apellidos;// apellidos del medico
	
	@NotBlank(message="El nombre del medico no puede ser vacio")
	private String nombre;// nombre del medico
	
	@NotBlank(message="El nombre de la especialidad no puede ser vacio")
	private String nombreEspecialidad;// nombre de la especialidad del medico
	
	public Long getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

}
