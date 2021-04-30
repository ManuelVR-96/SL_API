package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_prioridades_sintomas")
public class PrioridadSintoma {
	
	@Id
	@Column(name="id_prioridad_sintoma")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPrioridadSintoma;
	
	@Column(name="desc_prioridad_sintomas", nullable=false)
	private String descPrioridadSintoma;
	
	@Column(name="valor_prioridad", nullable=false)
	private Integer valorPrioridad;

	public PrioridadSintoma() {
		super();
	}
	
	public PrioridadSintoma(Long idPrioridadSintoma) {
		this.idPrioridadSintoma = idPrioridadSintoma;
	}
	
	public Long getIdPrioridadSintoma() {
		return idPrioridadSintoma;
	}

	public void setIdPrioridadSintoma(Long idPrioridadSintoma) {
		this.idPrioridadSintoma = idPrioridadSintoma;
	}

	public String getDescPrioridadSintoma() {
		return descPrioridadSintoma;
	}

	public void setDescPrioridadSintoma(String descPrioridadSintoma) {
		this.descPrioridadSintoma = descPrioridadSintoma;
	}

	public Integer getValorPrioridad() {
		return valorPrioridad;
	}

	public void setValorPrioridad(Integer valorPrioridad) {
		this.valorPrioridad = valorPrioridad;
	}

}
