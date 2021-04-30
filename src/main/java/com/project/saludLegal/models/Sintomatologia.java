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
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="SL_sintomatologias")
public class Sintomatologia {
	
	@Id
	@Column(name="id_sintomatologia", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSintomatologia;
	
	@NotBlank(message="La sintomatologia debe tener una descripcion")
	private String descripcion;
	
	public Sintomatologia(String descripcion, PrioridadSintoma prioridadSintoma) {
		this.descripcion = descripcion;
		this.prioridadSintoma = prioridadSintoma;
	}
	

	public Sintomatologia() {
		super();
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_prioridad_sintoma")
	private PrioridadSintoma prioridadSintoma;
	
	public Long getIdSintomatologia() {
		return idSintomatologia;
	}
	public void setIdSintomatologia(Long idSintomatologia) {
		this.idSintomatologia = idSintomatologia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public PrioridadSintoma getPrioridadSintoma() {
		return prioridadSintoma;
	}
	public void setPrioridadSintoma(PrioridadSintoma prioridadSintoma) {
		this.prioridadSintoma = prioridadSintoma;
	}
	
}
