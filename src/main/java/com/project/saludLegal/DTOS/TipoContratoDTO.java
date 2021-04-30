package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para modelo TipoContrato

 * @author: Manuel Alejandro Verjan Robles

 */
public class TipoContratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Se requiere el id del tipo de contrato")
	private Long idTipoContrato;// id del tipo de contrato
	
	@NotBlank(message="El tipo de contrato debe tener un nombre")
	private String nombreContrato;// nombre del tipo de contrato
	
	public TipoContratoDTO(Long idTipoContrato, String nombreContrato) {
		super();
		this.idTipoContrato = idTipoContrato;
		this.nombreContrato = nombreContrato;
	}

	public TipoContratoDTO() {
		super();
	}

	public Long getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(Long idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getNombreContrato() {
		return nombreContrato;
	}

	public void setNombreContrato(String nombreContrato) {
		this.nombreContrato = nombreContrato;
	}
	
	
	
	
}
