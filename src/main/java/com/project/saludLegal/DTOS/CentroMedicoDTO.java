package com.project.saludLegal.DTOS;

import javax.validation.constraints.NotNull;

/**

 * DTO para modelo centro medico

 * @author: Manuel Alejandro Verjan Robles

 */
public class CentroMedicoDTO {
	
	@NotNull(message="Falta el id del centro medico")
	private Long idCentroMedico;// Id del centro medico
	
	@NotNull(message="Falta el nombre del centro medico")
	private String nombreCentroMedico;// Nombre del centro medico
	
	public Long getIdCentroMedico() {
		return idCentroMedico;
	}
	public void setIdCentroMedico(Long idCentroMedico) {
		this.idCentroMedico = idCentroMedico;
	}
	public String getNombreCentroMedico() {
		return nombreCentroMedico;
	}
	public void setNombreCentroMedico(String nombreCentroMedico) {
		this.nombreCentroMedico = nombreCentroMedico;
	}
	
}
