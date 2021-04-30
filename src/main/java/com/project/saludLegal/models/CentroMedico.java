package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_centros_medicos")
public class CentroMedico {
	
	@Id
	@Column(name = "id_centro_medico")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCentroMedico;
	
	@Column(name = "nombre_centro_medico", nullable=false)
	private String nombreCentroMedico;
	
	@Column(name = "direccion", nullable=false)
	private String direccion;
	
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoCentroMedico() {
		return telefonoCentroMedico;
	}

	public void setTelefonoCentroMedico(String telefonoCentroMedico) {
		this.telefonoCentroMedico = telefonoCentroMedico;
	}

	@Column(name = "telefono_centro_medico", nullable=false)
	private String telefonoCentroMedico;

}
