package com.tinsa.demo.infrastructure.entry.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateNotificationRequest 
{
	@NotNull
	@Size(min=1, max=500)
	private String message;

	public CreateNotificationRequest() 
	{
		// Default constructor
	}

	public CreateNotificationRequest(String message) 
	{
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
