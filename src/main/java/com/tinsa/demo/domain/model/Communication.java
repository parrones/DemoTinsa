package com.tinsa.demo.domain.model;

public class Communication 
{
	private String message;
	private long clientId;
	private String status;
	
	public Communication(String message, long clientId, String status) 
	{
		this.message = message;
		this.clientId = clientId;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
