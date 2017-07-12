package com.tinsa.demo.domain.model;

public class Communication 
{
	private String destinatario;
	private String mensaje;
	private String tipoEnvio;
	private String estado;
	
	public Communication(String destinatario, String mensaje, String tipoEnvio, String estado) 
	{
		this.destinatario = destinatario;
		this.mensaje = mensaje;
		this.tipoEnvio = tipoEnvio;
		this.estado = estado;
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

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
