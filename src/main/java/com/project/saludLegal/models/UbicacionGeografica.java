package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="SL_ubicaciones_geograficas")
public class UbicacionGeografica {
	
	
	public UbicacionGeografica(Long idUbicacion, String nombreUbicacion, CentroMedico centroMedico) {
		super();
		this.idUbicacion = idUbicacion;
		this.nombreUbicacion = nombreUbicacion;
		this.centroMedico = centroMedico;
	}
	
	public UbicacionGeografica() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ubicacion")
	private Long idUbicacion;
	
	@Column(name="nombre_ubicacion")
	private String nombreUbicacion;

	@Valid
	@ManyToOne
	@JoinColumn(name="id_centro_medico")
	private CentroMedico centroMedico;

	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
}
