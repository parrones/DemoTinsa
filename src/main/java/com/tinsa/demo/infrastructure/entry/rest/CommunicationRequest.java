package com.tinsa.demo.infrastructure.entry.rest;

public class CommunicationRequest 
{
	private String destinatario;
	private String mensaje;
	private String tipoEnvio;
	
	public CommunicationRequest() 
	{
		// default constructor CommunicationRequest
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
}
