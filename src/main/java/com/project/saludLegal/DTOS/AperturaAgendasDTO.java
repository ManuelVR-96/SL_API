package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**

 * DTO para transportar la informacion cuando se busca abrir una agenda

 * @author: Manuel Alejandro Verjan Robles

 */
public class AperturaAgendasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="La fecha de inicio es obligatoria")
	private String fechaInicio;// Fecha de inicio de las agendas a agregar
	
	@NotBlank(message="La fecha final es obligatoria")
	private String fechaFinal;// Fecha final de las agendas a agregar
	
	@NotNull(message="El campo id medico no puede ser vacio")
	private Long idMedico;// Id del medico relacionado a la agenda
	
	private Long idCentroMedico; // Id del centro medico relacionado a la agenda
	
	public AperturaAgendasDTO(String fechaInicio, String fechaFinal, Long idMedico) {
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.idMedico = idMedico;
	}
	
	public AperturaAgendasDTO() {
	}


	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Long getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}


	public Long getIdCentroMedico() {
		return idCentroMedico;
	}


	public void setIdCentroMedico(Long idCentroMedico) {
		this.idCentroMedico = idCentroMedico;
	}
	
	
	
	
}
