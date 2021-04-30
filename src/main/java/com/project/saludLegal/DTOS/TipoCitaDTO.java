package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para sintomas

 * @author: Manuel Alejandro Verjan Robles

 */
public class TipoCitaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Se requiere el id del tipo de cita")
	private Long idTipoCita;// id del tipo de cita
	
	@NotBlank(message="El tipo de cita debe tener una descripcion")
	private String descTipoCita;// descripcion del tipo de cita
	
	public TipoCitaDTO(Long idTipoCita, String descTipoCita) {
		super();
		this.idTipoCita = idTipoCita;
		this.descTipoCita = descTipoCita;
	}
	
	public TipoCitaDTO() {
		super();
	}

	public Long getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(Long idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	public String getDescTipoCita() {
		return descTipoCita;
	}

	public void setDescTipoCita(String descTipoCita) {
		this.descTipoCita = descTipoCita;
	}
	
	
	
	

}
