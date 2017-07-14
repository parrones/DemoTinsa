package com.tinsa.demo.infrastructure.entry.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tinsa.demo.infrastructure.entry.validations.ValidCommunication;
import com.tinsa.demo.infrastructure.entry.validations.ValidRecipient;

public class CreateClientRequest 
{
	@NotNull
	@Size(min=1, max=50)
	private String name;
	@NotNull
	@ValidCommunication(acceptedValues= {"SMS","FAX"}, message="Invalid communication")
	private String communication;
	@NotNull
	@ValidRecipient
	private String recipient;
	
	public CreateClientRequest()
	{
		// default constructor CreateClientRequest
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
