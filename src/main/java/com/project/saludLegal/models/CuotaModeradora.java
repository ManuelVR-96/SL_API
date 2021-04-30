package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SL_cuotas_moderadoras")
public class CuotaModeradora {
	
	@Id
	@Column(name="id_cuota_moderadora")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCuotaModeradora;
	
	@Column(name="valor_cuota_moderadora", nullable=false)
	private Long valorCuotaModeradora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_contrato", nullable=false)
	private TipoContrato idTipoContrato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_cita", nullable=false)
	private TipoCita idTipoCita;
	
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

}
