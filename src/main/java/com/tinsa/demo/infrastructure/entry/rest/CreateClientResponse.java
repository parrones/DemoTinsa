package com.tinsa.demo.infrastructure.entry.rest;

public class CreateClientResponse 
{
	private long clientId;

	public CreateClientResponse() 
	{
	}

	public CreateClientResponse(long clientId) 
	{
		this.clientId = clientId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
}
