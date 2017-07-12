package com.tinsa.demo.domain.ports.primary;

public class CreateNotificationRequest 
{
	private long clientId;
	private String message;
	
	public CreateNotificationRequest(long clientId, String message) 
	{
		this.clientId = clientId;
		this.message = message;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
