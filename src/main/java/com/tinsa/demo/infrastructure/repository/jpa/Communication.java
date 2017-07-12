package com.tinsa.demo.infrastructure.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="communications")
@Table(name="COMMUNICATIONS")
public class Communication 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "DESTINATARIO")
	@NotNull
	private String destinatario;

	@Column(name = "MENSAJE")
	@NotNull
	private String mensaje;
	
	@Column(name = "ESTADO")
	@NotNull
	private String estado;
	
	@Column(name="TIPO_ENVIO")
	@NotNull
	private String tipoEnvio;

	public Communication() {

	}

	public Communication(String destinatario, String mensaje, String estado, String tipoEnvio) 
	{
		this.destinatario = destinatario;
		this.mensaje = mensaje;
		this.estado = estado;
		this.tipoEnvio = tipoEnvio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
}
