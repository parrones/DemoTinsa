package com.tinsa.demo.domain.ports.primary;

public class ClientRequest 
{
	private String name;
	private String communication;
	private String recipient;
	
	public ClientRequest(String name, String communication, String recipient) 
	{
		this.name = name;
		this.communication = communication;
		this.recipient = recipient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
