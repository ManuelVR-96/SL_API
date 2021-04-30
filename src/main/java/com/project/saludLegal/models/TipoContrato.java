package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_tipos_contratos")
public class TipoContrato {
	
	@Id
	@Column(name="id_tipo_contrato")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTipoContrato;
	
	@Column(name="nombre_contrato")
	private String nombreContrato;
	
	@Column(name="prioridad_tipo_contrato")
	private String prioridadTipoContrato;
	
	@Column(name="valor_prioridad_contrato")
	private Integer valorPrioridadContrato;
	
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

	public String getPrioridadTipoContrato() {
		return prioridadTipoContrato;
	}

	public void setPrioridadTipoContrato(String prioridadTipoContrato) {
		this.prioridadTipoContrato = prioridadTipoContrato;
	}

	public Integer getValorPrioridadContrato() {
		return valorPrioridadContrato;
	}

	public void setValorPrioridadContrato(Integer valorPrioridadContrato) {
		this.valorPrioridadContrato = valorPrioridadContrato;
	}

}
