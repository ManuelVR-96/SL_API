package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="SL_tipos_citas")
public class TipoCita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_cita")
	private Long idTipoCita;

	@Column(name="desc_tipo_cita")
	@NotBlank(message="Se descripcion del tipo de cita")
	private String descTipoCita;
	/*
	 SL_tipos_citas
	 id_tipo_citas NUMBER GENERATED ALWAYS AS IDENTITY,
		desc_tipo_citas VARCHAR(50)NOT NULL
	 */

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
