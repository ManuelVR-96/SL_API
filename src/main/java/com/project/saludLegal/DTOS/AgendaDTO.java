package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para modelo agendas.

 * @author: Manuel Alejandro Verjan Robles

 */

public class AgendaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Falta id de agenda")
	private Long idAgenda;
	
	@NotBlank(message="No hay fecha de la agenda")
	private String fechaAgenda;// fecha de la agenda
	
	@NotBlank(message="Falta nombre del medico")
	private String nombreMedico; // nombre del medico de la agenda
	
	public Long getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	public String getFechaAgenda() {
		return fechaAgenda;
	}
	public void setFechaAgenda(String fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}
	public String getNombreMedico() {
		return nombreMedico;
	}
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}
}
