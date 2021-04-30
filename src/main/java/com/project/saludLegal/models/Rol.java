package com.project.saludLegal.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_roles")
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(name="nombre_rol", nullable=false)
	private String nombreRol;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

}
