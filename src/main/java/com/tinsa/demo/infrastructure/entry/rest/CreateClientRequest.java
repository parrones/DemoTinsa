package com.tinsa.demo.infrastructure.entry.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tinsa.demo.infrastructure.entry.validations.ValidNotificationType;
import com.tinsa.demo.infrastructure.entry.validations.ValidRecipient;

public class CreateClientRequest 
{
	@NotNull
	@Size(min=1, max=50)
	private String name;
	@NotNull
	@ValidNotificationType(acceptedValues= {"SMS","FAX"}, message="Invalid notification type")
	private String notificationType;
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

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
