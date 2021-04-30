package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**

 * DTO para modelo cuotas moderadora

 * @author: Manuel Alejandro Verjan Robles

 */
public class CuotaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idCuotaModeradora;//Id de la cuota moderadora
	
	@NotNull(message="Falta el valor de la cuota moderadora")
	private Long valorCuotaModeradora;// Valor de la cuota moderadora
	
	@NotNull(message="Falta id del tipo de contrato")
	private Long idTipoContrato;// Id del tipo de contrato relacionado a la cuota
	
	@NotNull(message="Falta el id del tipo de cita")
	private Long idTipoCita;// Id del tipo de cita
	
	

	public CuotaDTO() {
		super();
	}

	public Long getIdCuotaModeradora() {
		return idCuotaModeradora;
	}

	public void setIdCuotaModeradora(Long idCuotaModeradora) {
		this.idCuotaModeradora = idCuotaModeradora;
	}

	public Long getValorCuotaModeradora() {
		return valorCuotaModeradora;
	}

	public void setValorCuotaModeradora(Long valorCuotaModeradora) {
		this.valorCuotaModeradora = valorCuotaModeradora;
	}

	public Long getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(Long idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public Long getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(Long idTipoCita) {
		this.idTipoCita = idTipoCita;
	}
	
	
	
}
